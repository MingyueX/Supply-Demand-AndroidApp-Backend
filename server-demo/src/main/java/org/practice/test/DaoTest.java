package org.practice.test;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.practice.dao.AccountDao;
import org.practice.model.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {
    private Logger logger = Logger.getLogger(DaoTest.class);

    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        AccountDao accountDao = ac.getBean(AccountDao.class);
        Account acc = accountDao.getByName("Hello");
        logger.info(JSON.toJSONString(acc));
    }
}
