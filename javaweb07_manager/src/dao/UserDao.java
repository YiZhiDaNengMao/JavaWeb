package dao;

import pojo.User;

import java.util.List;

public interface UserDao {
    User findUserByNameAndPwd(String name, String password);

    List<User> selectAll();

    boolean insertUser(User user);

    void updateUser(User user);

    void delete(int id);

    User findUser(String id);

    List<User> findByPage(int currentPage, int rows);

    int findTotalCount();
}
