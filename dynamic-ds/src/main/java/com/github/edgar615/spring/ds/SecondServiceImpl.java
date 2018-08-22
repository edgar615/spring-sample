package com.github.edgar615.spring.ds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by Edgar on 2018/8/22.
 *
 * @author Edgar  Date 2018/8/22
 */
@Service
public class SecondServiceImpl implements SecondService {

//    @Resource(name = "secondDataSource")
    @Autowired
    @Qualifier("secondDataSource")
    private DataSource dataSource;

    @Override
    public long count() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Map<String, Object> map =
                jdbcTemplate.queryForMap("select count(*) as d_count from device");
        return (long) map.get("d_count");
    }
}
