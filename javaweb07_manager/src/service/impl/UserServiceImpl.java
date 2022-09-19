package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import exception.LoginException;
import pojo.PageBean;
import pojo.User;
import service.UserService;

import java.util.List;
import java.util.zip.CRC32;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() throws LoginException {
        List<User> list = dao.selectAll();
        if (list != null) {
            return list;
        } else {
            throw new LoginException("用户列表为空！！");
        }
    }

    @Override
    public User login(User user) throws LoginException {
        User usr = dao.findUserByNameAndPwd(user.getUsername(),user.getPassword());
        if (usr != null) {
            return usr;
        } else {
            throw new LoginException("用户名或密码错误！！");
        }
    }

    @Override
    public boolean addUser(User user) {
        boolean isInsert = dao.insertUser(user);
        return isInsert;
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public User findUser(String id) {
        User user = dao.findUser(id);
        return user;
    }

    @Override
    public void update(User user) {
        dao.updateUser(user);
    }


    @Override
    public void delSelected(String[] uids) {
        if(uids != null && uids.length != 0){
            for(String id : uids){
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean findUserByPage(String currentPage, String rows) {
        int current = Integer.parseInt(currentPage);
        int row = Integer.parseInt(rows);

        if(current <= 0){
            current = 1;
        }

        PageBean<User> page = new PageBean<>();
        page.setCurrentPage(current);
        page.setRows(row);

        int start = (current - 1) * row;
        List<User> list = dao.findByPage(start,row);
        page.setList(list);

        int totalCount = dao.findTotalCount();
        page.setTotalCount(totalCount);

        int totalPage = (totalCount % row == 0) ?
                (totalCount / row) : (totalCount / row + 1);
        page.setTotalPage(totalPage);

        return page;
    }
}
