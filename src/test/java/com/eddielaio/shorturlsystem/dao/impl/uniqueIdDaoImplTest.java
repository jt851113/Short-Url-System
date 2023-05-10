package com.eddielaio.shorturlsystem.dao.impl;

import com.eddielaio.shorturlsystem.dao.uniqueIdDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class uniqueIdDaoImplTest {
    @Autowired
    private uniqueIdDao uniqueIdDao;
    @Test
    @Transactional
    void createUniqueId() {
        String uniqueId = uniqueIdDao.createUniqueId("https://medium.com/starbugs/git-%E6%88%91%E4%BB%A5%E7%82%BA%E7%9A%84-git-rebase-%E8%88%87%E5%92%8C-git-merge-%E5%81%9A%E5%90%88%E4%BD%B5%E5%88%86%E6%94%AF%E7%9A%84%E5%B7%AE%E7%95%B0-cacd3f45294d");
        System.out.println(uniqueId);
    }

    @Test
    void getUniqueId() {
        String c = uniqueIdDao.getUniqueId("bXeEIA");
        System.out.println(c);
    }


    @Test
    void testCreateUniqueId() {
    }

}