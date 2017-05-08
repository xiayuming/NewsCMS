package ldu.guofeng.news.admin.dao;

import ldu.guofeng.news.admin.domain.UserPO;

/**
 * Created by GUOFENG on 2017/4/14.
 */
public interface UserDao {
    UserPO login(UserPO userPO);

    boolean checkOldPassword(int userId, String oldPassword);

    void updatePassword(int userId, String password);

}
