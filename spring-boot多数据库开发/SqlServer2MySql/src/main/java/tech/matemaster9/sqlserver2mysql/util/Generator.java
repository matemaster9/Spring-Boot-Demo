package tech.matemaster9.sqlserver2mysql.util;

import tech.matemaster9.sqlserver2mysql.entity.dto.SysUserDto;
import tech.matemaster9.sqlserver2mysql.entity.dto.TempTbDto;
import tech.matemaster9.sqlserver2mysql.entity.enums.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description: 测试数据的生成器
 * @Author: matemaster9
 * @Date: 2021/12/25 11:47
 */
public class Generator {
    private static Random rdm = new Random();
    private static String[] name = {"Kurt", "Stanley", "Earthy", "Richard", "Horace", "Stacy", "Halden", "Quinby", "Prosperous", "Kyle", "Wyman", "Luther", "Logan", "Fleming", "Trent"};
    private static String[] address = {"美国加利福尼亚库比蒂诺", "美国加利福尼亚山景城", "美国华盛顿西雅图", "美国华盛顿雷德蒙德", "美国得克萨斯奥斯汀", "韩国水原市", "美国纽约阿蒙克", "中国深圳市", "日本东京都港区", "美国纽约", "德国慕尼黑", "韩国首尔", "美国加利福尼亚门洛帕克", "中国杭州"};
    private static String[] company = {"Apple", "Alphabet", "Amazon", "Microsoft", "Tesla", "Samsung", "IBM", "Huawei", "Sony", "Pfizer", "Siemens", "LG", "Meta", "Alibaba", "Oracle"};

    public static List<SysUserDto> testData4SqlServer(int count) {
        ArrayList<SysUserDto> data = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            data.add(createData4SqlServer());
        }
        return data;
    }

    public static List<SysUserDto> testData4Mysql(int count) {
        ArrayList<SysUserDto> data = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            data.add(createData4Mysql());
        }
        return data;
    }

    public static List<TempTbDto> testData4TempTb(int count) {
        ArrayList<TempTbDto> data = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            data.add(createData4TempTb());
        }
        return data;
    }

    private static TempTbDto createData4TempTb() {
        TempTbDto dto = TempTbDto.builder()
                .tableName(Table.SYS_USER.getType())
                .latestCount(rdm.nextLong())
                .latestStamp(rdm.nextLong())
                .build();
        return dto;
    }

    private static SysUserDto createData4Mysql() {
        SysUserDto dto = SysUserDto.builder()
                .name(name[rdm.nextInt(name.length)])
                .phone(String.valueOf(13000000000L + rdm.nextInt(999999999)))
                .company(company[rdm.nextInt(company.length)])
                .sex(rdm.nextInt(2))
                .address(address[rdm.nextInt(address.length)])
                .createTime(LocalDateTime.now())
                .build();
        return dto;
    }

    private static SysUserDto createData4SqlServer() {
        SysUserDto dto = SysUserDto.builder()
                .name(name[rdm.nextInt(name.length)])
                .phone(String.valueOf(13000000000L + rdm.nextInt(999999999)))
                .company(company[rdm.nextInt(company.length)])
                .sex(rdm.nextInt(2))
                .address(address[rdm.nextInt(address.length)])
                .build();
        return dto;
    }
}
