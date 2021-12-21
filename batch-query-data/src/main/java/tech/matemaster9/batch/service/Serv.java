package tech.matemaster9.batch.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.matemaster9.batch.dto.PersonDTO;
import tech.matemaster9.batch.mapper.PersonMapper;

import java.util.List;

/**
 * @author matemaster9
 * @date 2021/12/20 23:25
 */
@Service
public class Serv {
    @Autowired
    private PersonMapper mapper;

    public List<PersonDTO> batchQuery() {
//        PageHelper.startPage(1351,500);
        long start = System.currentTimeMillis();
        List<PersonDTO> list = mapper.batchQuery();
        System.out.println("耗时："+ (System.currentTimeMillis() - start));
//        PageInfo pageInfo = new PageInfo(list);
        return list;
    }
}
