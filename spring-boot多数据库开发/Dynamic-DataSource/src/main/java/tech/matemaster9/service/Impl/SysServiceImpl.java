package tech.matemaster9.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.matemaster9.annotation.DataSource;
import tech.matemaster9.entity.dto.CompanyDto;
import tech.matemaster9.entity.dto.SysUserDto;
import tech.matemaster9.entity.enums.DataSourceEnum;
import tech.matemaster9.mapper.master.SysUserMapper;
import tech.matemaster9.mapper.slave.CompanyMapper;
import tech.matemaster9.service.SysService;

import java.util.List;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2022/1/5 19:21
 */
@Service
@AllArgsConstructor
public class SysServiceImpl implements SysService {
    private SysUserMapper master;
    private CompanyMapper slave;

    @Override
    @DataSource(DataSourceEnum.MASTER)
    public List<SysUserDto> getSysUserInfo() {
        return master.selectAll();
    }

    @Override
    @DataSource(DataSourceEnum.SLAVE)
    public List<CompanyDto> getCompanyInfo() {
        return slave.selectAll();
    }
}
