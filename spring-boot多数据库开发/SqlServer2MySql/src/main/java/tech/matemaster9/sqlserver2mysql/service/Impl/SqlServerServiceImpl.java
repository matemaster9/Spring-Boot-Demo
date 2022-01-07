package tech.matemaster9.sqlserver2mysql.service.Impl;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.matemaster9.sqlserver2mysql.entity.dto.SysUserDto;
import tech.matemaster9.sqlserver2mysql.entity.dto.TempTbDto;
import tech.matemaster9.sqlserver2mysql.entity.enums.Table;
import tech.matemaster9.sqlserver2mysql.mapper.mysql.MySqlMapper;
import tech.matemaster9.sqlserver2mysql.mapper.sqlserver.SqlServerMapper;
import tech.matemaster9.sqlserver2mysql.service.SqlServerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2021/12/29 20:20
 */
@Service
@AllArgsConstructor
public class SqlServerServiceImpl implements SqlServerService {

    private MySqlMapper mySqlMapper;
    private SqlServerMapper sqlServerMapper;

    private ThreadPoolExecutor executor;

    @Override
    public List<SysUserDto> readAddData() {
        ArrayList<SysUserDto> addData = Lists.newArrayList();
        TempTbDto tempInfo = getTempInfo();
        List<SysUserDto> sysUserDtos = sqlServerMapper.readAddData(tempInfo.getLatestCount());
        addData.addAll(sysUserDtos);
        return addData;
    }

    @Override
    public List<SysUserDto> readChangedData() {
        ArrayList<SysUserDto> changedData = Lists.newArrayList();
        TempTbDto tempInfo = getTempInfo();
        List<SysUserDto> sysUserDtos = sqlServerMapper.readChangedData(tempInfo.getLatestStamp(), tempInfo.getLatestCount());
        changedData.addAll(sysUserDtos);
        return changedData;
    }

    @Override
    public void concurrentInsertData() {

    }

    private TempTbDto getTempInfo() {
        String tableName = Table.SYS_USER.getType().toUpperCase();
        TempTbDto tempTbDto = mySqlMapper.queryDataFromTempTb(tableName);
        return Objects.isNull(tempTbDto) ? new TempTbDto() : tempTbDto;
    }
}
