package ldu.guofeng.news.user.service.impl;

import ldu.guofeng.news.admin.domain.UserPO;
import ldu.guofeng.news.user.dao.LoginRegDao;
import ldu.guofeng.news.user.service.LoginRegService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by GUOFENG on 2017/5/7.
 */
@Transactional
public class LoginRegServiceImpl implements LoginRegService {
    private LoginRegDao loginRegDao;

    public void setLoginRegDao(LoginRegDao loginRegDao) {
        this.loginRegDao = loginRegDao;
    }

    @Override
    public boolean register(UserPO userPO) {
        return loginRegDao.register(userPO);
    }

    @Override
    public UserPO login(UserPO userPO) {
        return loginRegDao.login(userPO);
    }
}
