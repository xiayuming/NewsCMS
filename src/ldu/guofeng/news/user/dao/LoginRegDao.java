package ldu.guofeng.news.user.dao;

import ldu.guofeng.news.admin.domain.UserPO;

/**
 * Created by GUOFENG on 2017/5/7.
 */
public interface LoginRegDao {
    boolean register(UserPO userPO);

    UserPO login(UserPO userPO);

}
