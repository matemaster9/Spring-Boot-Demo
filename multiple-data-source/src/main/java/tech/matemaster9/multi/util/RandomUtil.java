package tech.matemaster9.multi.util;

import tech.matemaster9.multi.dto.ActAuditBacklogDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author matemaster9
 * @date 2021/12/22 9:48
 */
public class RandomUtil {

    private static Random rdm = new Random();
    private static String[] actIdList = {"AGP20211203164410jkldM3A4c", "AGP20211213164410jdbcM3A4c", "AGP20201203164410mateM3A4c", "AGP20191203165510jkldM3A4c", "AGP20210903144410kobeM3A4c"};
    private static String[] deptIdList = {"320076", "291187", "378099", "365401", "280345", "452043", "681031", "702146", "010011", "190031"};
    private static String[] submitterIdList = {"asdfghjklouweipytrqmnzxclaj", "LMYbo108659ny6b3L98bgfdloy", "plokmIJN6798YBFGtvsraefhwl", "MNB908bvc765zxaslp12klweui", "98LMKTYbhgtazlmkdncyqhzLM"};
    private static String[] nameList = {"XuChao", "MateMaster", "Kobe", "JackMa", "Turbo", "RichardYu", "Make", "Tom", "Tony"};

    private RandomUtil() {
    }

    public static List<ActAuditBacklogDTO> getList(int count) {
        ArrayList<ActAuditBacklogDTO> dtos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            dtos.add(createData());
        }
        return dtos;
    }

    private static ActAuditBacklogDTO createData() {
        ActAuditBacklogDTO dto = ActAuditBacklogDTO.builder()
                .activityId(actIdList[rdm.nextInt(actIdList.length)])
                .deptId(deptIdList[rdm.nextInt(deptIdList.length)])
                .submitterId(submitterIdList[rdm.nextInt(submitterIdList.length)])
                .submitterName(nameList[rdm.nextInt(nameList.length)])
                .status(rdm.nextInt(10))
                .deleteFlag(rdm.nextInt(2))
                .build();
        return dto;
    }

}
