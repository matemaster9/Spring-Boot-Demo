package tech.matemaster9.batch.util;

import tech.matemaster9.batch.entity.Person;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author matemaster9
 * @date 2021/12/20 14:49
 */
public class RandomUtil {
    private static Random rdm = new Random();
    private static String[] nameList = {"XuChao", "MateMaster", "Kobe", "JackMa", "Turbo", "RichardYu", "Make", "Tom", "Tony"};
    private static String[] addressList = {"二仙桥", "成华大道", "春熙路", "锦里", "宽窄巷子", "双子塔", "天府大道", "软件园", "熊猫大道", "交子大道"};
    private static String[] companyList = {"Apple", "腾讯", "百度", "Amazon", "Meta", "IBM", "字节跳动", "美团", "华为", "阿里巴巴"};

    private RandomUtil(){
    }

    public static ArrayList<Person> getList(int count) {
        ArrayList<Person> people = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            people.add(createPerson());
        }
        return people;
    }

    private static Person createPerson() {
        Person person = Person.builder()
                .name(nameList[rdm.nextInt(nameList.length)])
                .phone(18800000000L + rdm.nextInt(88888888))
                .salary(new BigDecimal(rdm.nextInt(99999)))
                .company(companyList[rdm.nextInt(companyList.length)])
                .single(rdm.nextInt(2))
                .sex(rdm.nextInt(2))
                .address("成都市" + addressList[rdm.nextInt(addressList.length)])
                .createUser("matemaster9")
                .build();

        return person;
    }

}
