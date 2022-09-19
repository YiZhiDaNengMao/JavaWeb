package dao.impl;

import dao.UserDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.User;
import utils.DruidUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());;
    @Override
    public User findUserByNameAndPwd(String name, String password) {
        String sql = "select * from user " +
                "where username = ? and password = ?";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class)
                , name, password);
        return list.size() == 0 ? null : list.get(0);
    }

    @Override
    public List<User> selectAll() {
        String sql = "select * from user";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    @Override
    public boolean insertUser(User user) {
        String sql = "insert into user " +
                "values(null,?,?,?,?,?,?,null,null)";
        int update = template.update(sql, user.getName(), user.getGender(),
                user.getAge(), user.getAddress(),
                user.getQq(), user.getEmail());
        return update == 1;

    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name=?,gender=?,age=?," +
                "address=?,qq=?,email=? where id = ?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),
                user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql,id);
    }

    @Override
    public User findUser(String id) {
        String sql = "select * from user where id = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),
                Integer.parseInt(id));
        return user;
    }

    @Override
    public List<User> findByPage(int start, int rows) {
        String sql = "select * from user limit ?, ?";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class),
                start,rows);
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from user";
        return template.queryForObject(sql,Integer.class);
    }
}
