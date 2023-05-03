package com.eddielaio.shorturlsystem.dao.impl;

import com.eddielaio.shorturlsystem.dao.uniqueIdDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class uniqueIdDaoImplTest {
    @Autowired
    private uniqueIdDao uniqueIdDao;
    @Test
    @Transactional
    void createUniqueId() {
        String uniqueId = uniqueIdDao.createUniqueId("https://google.com.tw");
        System.out.println(uniqueId);

    }

    @Test
    void getUniqueId() {
        String c = uniqueIdDao.getUniqueId("d");
        System.out.println(c);
    }


    @Test
    void testCreateUniqueId() {
    }
}