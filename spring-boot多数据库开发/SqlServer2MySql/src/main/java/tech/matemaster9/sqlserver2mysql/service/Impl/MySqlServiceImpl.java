package tech.matemaster9.sqlserver2mysql.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.matemaster9.sqlserver2mysql.entity.dto.SysUserDto;
import tech.matemaster9.sqlserver2mysql.entity.dto.TempTbDto;
import tech.matemaster9.sqlserver2mysql.entity.enums.Table;
import tech.matemaster9.sqlserver2mysql.mapper.mysql.MySqlMapper;
import tech.matemaster9.sqlserver2mysql.mapper.sqlserver.SqlServerMapper;
import tech.matemaster9.sqlserver2mysql.service.MySqlService;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2021/12/29 19:58
 */
@Service
@AllArgsConstructor
public class MySqlServiceImpl implements MySqlService {

    private MySqlMapper mySqlMapper;
    private SqlServerMapper sqlServerMapper;

    private ThreadPoolExecutor executor;

    @Override
    public boolean batchInsertData2SysUser(List<SysUserDto> data) {
        if (Objects.isNull(data) || data.size() ==0) {
            return false;
        }
        // TODO: 加入缓存处理，放置插入数据失败，带来临时表的脏数据
        TempTbDto cache = tempInfoCache();
        if (mySqlMapper.insertMassData2SysUser(data) != 0) {
            mySqlMapper.insertData2TempTb(cache);
        }
        return true;
    }

    @Override
    public boolean batchUpdateData2SysUser(List<SysUserDto> data) {
        if (Objects.isNull(data) || data.size() ==0) {
            return false;
        }
        TempTbDto cache = tempInfoCache();
        Iterator<SysUserDto> it = data.iterator();
        while (it.hasNext()) {
            SysUserDto dto = it.next();
            mySqlMapper.updateData2SysUser(dto, dto.getPhone());
        }
        mySqlMapper.insertData2TempTb(cache);
        return true;
    }

    @Override
    public void concurrentInsert2SysUser(List<SysUserDto> data) throws Exception {

    }

    @Override
    public void concurrentUpdateSysUser(List<SysUserDto> data) throws Exception {

    }

    private TempTbDto tempInfoCache() {
        String tableName = Table.SYS_USER.getType().toUpperCase();
        Long latestCount = sqlServerMapper.readLatestCount();
        Long latestStamp = sqlServerMapper.readLatestStamp();
        TempTbDto cache = TempTbDto.builder()
                .tableName(tableName)
                .latestCount(latestCount)
                .latestStamp(latestStamp)
                .build();
        return cache;
    }
}
