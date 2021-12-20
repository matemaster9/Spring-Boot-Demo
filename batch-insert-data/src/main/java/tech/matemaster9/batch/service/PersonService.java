package tech.matemaster9.batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tech.matemaster9.batch.mapper.PersonMapper;
import tech.matemaster9.batch.util.RandomUtil;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author matemaster9
 * @date 2021/12/20 14:49
 */

@Service
public class PersonService {
    private static final int THREAD_COUNT = 10;
    private AtomicInteger val = new AtomicInteger();

    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private ThreadPoolExecutor executor;

    @Scheduled(cron = "0/10 * * * * ?")
    public void batchDemo() {
        System.out.println("本轮任务开始，总任务数：" + THREAD_COUNT);
        long start = System.currentTimeMillis();
        AtomicLong end = new AtomicLong();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(() -> {
                try {
                    for (int j = 0; j < 20; j++) {
                        personMapper.batchInsert(RandomUtil.getList(5000));
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

}
