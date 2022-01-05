package tech.matemaster9.service;

import tech.matemaster9.entity.dto.CompanyDto;
import tech.matemaster9.entity.dto.SysUserDto;

import java.util.List;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2022/1/5 19:20
 */
public interface SysService {
    List<SysUserDto> getSysUserInfo();

    List<CompanyDto> getCompanyInfo();
}
