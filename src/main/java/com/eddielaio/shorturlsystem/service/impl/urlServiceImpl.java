package com.eddielaio.shorturlsystem.service.impl;

import com.eddielaio.shorturlsystem.dao.uniqueIdDao;
import com.eddielaio.shorturlsystem.service.urlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class urlServiceImpl implements urlService {
    @Autowired
    private uniqueIdDao uniqueIdDao;
    @Override
    public String encode(String longUrl) {
        return uniqueIdDao.createUniqueId(longUrl);
    }

    @Override
    public String decode(String shortUrl) {
        return uniqueIdDao.getUniqueId(shortUrl);
    }
}
