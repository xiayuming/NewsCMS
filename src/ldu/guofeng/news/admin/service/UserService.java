package ldu.guofeng.news.admin.service;

import ldu.guofeng.news.admin.domain.UserPO;

/**
 * Created by GUOFENG on 2017/4/14.
 */
public interface UserService {
    UserPO login(UserPO userPO);

    boolean updatePassword(UserPO userPO, String oldPassword);
}
