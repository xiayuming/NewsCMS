package ldu.guofeng.news.user.service;

import ldu.guofeng.news.admin.domain.UserPO;

/**
 * Created by GUOFENG on 2017/5/7.
 */
public interface LoginRegService  {
    boolean register(UserPO userPO);

    UserPO login(UserPO userPO);
}
