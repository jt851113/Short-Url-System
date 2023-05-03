package com.eddielaio.shorturlsystem.dao;

import javax.sql.DataSource;

public interface uniqueIdDao {

    String createUniqueId(String originalUrl);

    String getUniqueId(String shortUrl);

    String queryUniqueId(String OriginalUrl);
}
