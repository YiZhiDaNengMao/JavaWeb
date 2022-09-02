package dao.impl;

import bean.User;
import dao.UserDao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.DruidUtils;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    @Override
    public User login(User user) {
        String sql = "select username,password from user " +
                "where username = ? and password = ?";
//        try {
            User loginUser = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    user.getUsername(), user.getPassword());
            return loginUser;
//        } catch (DataAccessException e) {
//            return null;
//        }
    }
}
