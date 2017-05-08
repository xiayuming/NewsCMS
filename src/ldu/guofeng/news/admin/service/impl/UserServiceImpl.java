package ldu.guofeng.news.admin.service.impl;

import ldu.guofeng.news.admin.dao.UserDao;
import ldu.guofeng.news.admin.domain.UserPO;
import ldu.guofeng.news.admin.service.UserService;
import org.springframework.transaction.annotation.Transactional;

/**
 * user业务层
 */
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    //注入DAO
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public UserPO login(UserPO userPO) {
        return userDao.login(userPO);
    }

    @Override
    public boolean updatePassword(UserPO userPO, String oldPassword) {
        //输入的老密码不正确
        boolean isOK = userDao.checkOldPassword(userPO.getUserId(), oldPassword);
        if (!isOK) {
            return false;
        }
        userDao.updatePassword(userPO.getUserId(), userPO.getPassword());
        return true;
    }
}
