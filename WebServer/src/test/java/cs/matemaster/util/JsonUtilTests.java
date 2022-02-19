package cs.matemaster.util;

import cs.matemaster.domain.SysUser;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Description:
 * @Author: MateMaster
 * @Date: 2022/2/19 16:51
 */
public class JsonUtilTests {

    @Test
    public void test1() {
        SysUser sysUser = new SysUser();
        sysUser.setUid(1L);
        sysUser.setName("MateMaster");
        sysUser.setPassword("cmbChina9!");
        sysUser.setRegisterDate(new Date());
        sysUser.setBirth(LocalDateTime.now());

        // 序列化
        String result = JsonUtil.serialize(sysUser);
        System.out.println(result);

        // 反序列化
        SysUser deserialize = JsonUtil.deserialize(result, SysUser.class);
        System.out.println(deserialize);
    }

    @Test
    public void test2() {
        SysUser sysUser = new SysUser();
        sysUser.setUid(1L);
        sysUser.setName("MateMaster");
        sysUser.setPassword("cmbChina9!");
        sysUser.setRegisterDate(new Date());
        sysUser.setBirth(LocalDateTime.now());

        // 序列化大驼峰
        String result = JsonUtil.serializeWithUpperCamel(sysUser);
        System.out.println(result);
    }

    @Test
    public void test3() {
        SysUser sysUser = new SysUser();
        sysUser.setUid(1L);
        sysUser.setName("MateMaster");
        sysUser.setPassword("cmbChina9!");
        sysUser.setRegisterDate(new Date());
        sysUser.setBirth(null);

        // 序列化忽略null属性
        String result = JsonUtil.serializeIgnoreNull(sysUser);
        System.out.println(result);
    }

    @Test
    public void test4() {
        String data = "{\"uid\":1,\"name\":\"MateMaster\",\"password\":\"cmbChina9!\",\"registerDate\":\"2022-02-19 17:18:47\",\"birth\":\"2022-02-19 17:18:47\",\"Sex\":\"man\"}";

        // 反序列化忽略不匹配属性 (属性字符串必须保持大小写一致)
        SysUser deserialize = JsonUtil.deserialize(data, SysUser.class);
        System.out.println(deserialize);
    }
}
