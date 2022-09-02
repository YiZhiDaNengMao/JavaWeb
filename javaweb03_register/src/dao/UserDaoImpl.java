package dao;

import bean.User;
import dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import util.DruidUtils;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    @Override
    public void addUser(User user) {

        String sql = "insert into user values(null,?,?,?,?,?,?)";
        template.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),
                user.getRealname(),user.getGender(),user.getBirthday());
    }
}
