package tech.matemaster9.multi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tech.matemaster9.multi.dao.sqlserver.SqlServerMapper;
import tech.matemaster9.multi.dto.ActAuditBacklogDTO;
import tech.matemaster9.multi.util.RandomUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author matemaster9
 * @date 2021/12/22 9:49
 */
@Service
public class SqlServerService {
    private static final int THREAD_COUNT = 10;
    private AtomicInteger val = new AtomicInteger();

    @Autowired
    private ThreadPoolExecutor executor;

    @Resource
    private SqlServerMapper sqlServerMapper;

    @Scheduled(cron = "0/10 * * * * ?")
    public void batchInsertDemo() {
        System.out.println("本轮任务开始，总任务数：" + THREAD_COUNT);
        long start = System.currentTimeMillis();
        AtomicLong end = new AtomicLong();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        sqlServerMapper.batchInsert(RandomUtil.getList(200));
                    }
                    end.set(System.currentTimeMillis());
                    System.out.println("本轮任务结束，耗时：" + (end.get() - start) + "______已经执行" + val.addAndGet(1) + "个任务" + "____当前队列任务数：" + executor.getQueue().size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            try {
                executor.execute(thread);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<ActAuditBacklogDTO> getData() {
        ArrayList<ActAuditBacklogDTO> list = new ArrayList<>();
        list.addAll(sqlServerMapper.readAll());
        return list;
    }
}
