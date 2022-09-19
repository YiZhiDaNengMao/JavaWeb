package service;

import exception.LoginException;
import pojo.PageBean;
import pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll() throws LoginException;

    User login(User user) throws LoginException;

    boolean addUser(User user);

    void delete(int id);

    User findUser(String id);

    void update(User user);

    void delSelected(String[] uids);

    PageBean findUserByPage(String currentPage, String rows);
}
