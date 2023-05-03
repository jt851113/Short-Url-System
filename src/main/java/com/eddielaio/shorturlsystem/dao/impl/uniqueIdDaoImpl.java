package com.eddielaio.shorturlsystem.dao.impl;

import com.eddielaio.shorturlsystem.common.transformUtil;
import com.eddielaio.shorturlsystem.dao.uniqueIdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;


@Component
public class uniqueIdDaoImpl implements uniqueIdDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public String createUniqueId(String originalUrl) {
        //先檢查傳入原始網址是否存在
        String checkExist = queryUniqueId(originalUrl);
        if(checkExist != null){
            return checkExist;
        }else{
            //不存在原始網址，開始建立新網址
            KeyHolder keyHolder = new GeneratedKeyHolder();
            HashMap<String, Object> map = new HashMap<>();
            map.put("original_url", originalUrl);
            String sql = "Insert Into url_db(original_url) Values(:original_url)";
            namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
            int key = keyHolder.getKey().intValue();
            String s = transformUtil.base62(key);
            s = String.format("%0" + (6 - s.length()) + "d%s", 0, s);
            map.put("short_url", s);
            map.put("id", key);
            String sql2 = "UPDATE url_db set short_url=:short_url where id = :id";
            int update = namedParameterJdbcTemplate.update(sql2, new MapSqlParameterSource(map));
            if (update >= 1) {
                System.out.println("update successful"+"key: "+key+" code: "+s);
            }else{
                System.out.println("fail");
            }
            return s;
        }
    }

    @Override
    public String getUniqueId(String shortUrl) {
        String sql = "select original_url from url_db where short_url = :shortUrl";
        HashMap<String, String> map = new HashMap<>();
        map.put("shortUrl", shortUrl);
        List<String> stringList = namedParameterJdbcTemplate.query(sql, map, (rs, rowNum) -> rs.getString("original_url"));
        if (stringList.isEmpty()) {
            return null;
        }else {
            return stringList.get(0);
        }
    }

    public String queryUniqueId(String originalUrl) {
        //如果長網址存在DB，回傳對應的短網址，否則回傳null
        String sql = "select short_url from url_db where original_url = :originalUrl";
        HashMap<String, String> map = new HashMap<>();
        map.put("originalUrl", originalUrl);
        List<String> stringList = namedParameterJdbcTemplate.query(sql, map, (rs, rowNum) -> rs.getString("short_url"));
        if (stringList.isEmpty()) {
            return null;
        }else {
            return stringList.get(0);
        }
    }
}
