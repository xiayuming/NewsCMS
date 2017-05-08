package ldu.guofeng.news.user.dao.impl;

import ldu.guofeng.news.admin.domain.UserPO;
import ldu.guofeng.news.user.dao.LoginRegDao;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by GUOFENG on 2017/5/7.
 */
public class LoginRegDaoImpl extends HibernateDaoSupport implements LoginRegDao {
    @Override
    public boolean register(UserPO userPO) {
        if (this.getHibernateTemplate().get(userPO.getClass(), userPO.getUserId()) != null) {
            return false;
        }
        this.getHibernateTemplate().save(userPO);
        return true;
    }

    @Override
    public UserPO login(UserPO userPO) {
        String hql = "FROM UserPO WHERE userId=? AND password=?";
        List<UserPO> userPOList = (List<UserPO>) this.getHibernateTemplate().find(hql, userPO.getUserId(), userPO.getPassword());
        if (userPOList.size() > 0) {
            return userPOList.get(0);
        }
        return null;
    }
}
