package ldu.guofeng.news.admin.dao.impl;

import ldu.guofeng.news.admin.dao.UserDao;
import ldu.guofeng.news.admin.domain.UserPO;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by GUOFENG on 2017/4/14.
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    public UserPO login(UserPO userPO) {
        String hql = "FROM UserPO WHERE userId=? AND password=?";
        List<UserPO> userPOList = (List<UserPO>) this.getHibernateTemplate().find(hql, userPO.getUserId(), userPO.getPassword());
        if (userPOList.size() > 0) {
            return userPOList.get(0);
        }
        return null;
    }

    @Override
    public boolean checkOldPassword(int userId, String oldPassword) {
        String hql = "FROM UserPO WHERE userId=? AND password=?";
        List<UserPO> userPOList = (List<UserPO>) this.getHibernateTemplate().find(hql, userId, oldPassword);
        if (userPOList.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void updatePassword(int userId, String password) {
        UserPO user = this.getHibernateTemplate().get(UserPO.class, userId);
        user.setPassword(password);
        this.getHibernateTemplate().update(user);
    }

}
