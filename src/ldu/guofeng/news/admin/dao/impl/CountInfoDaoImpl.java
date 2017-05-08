package ldu.guofeng.news.admin.dao.impl;

import ldu.guofeng.news.admin.dao.CountInfoDao;
import ldu.guofeng.news.utils.MyFileUtils;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.IOException;
import java.util.List;

/**
 * Created by GUOFENG on 2017/4/20.
 */
public class CountInfoDaoImpl extends HibernateDaoSupport implements CountInfoDao {

    @Override
    public int countUser() {
        String hql = "SELECT COUNT(*) FROM UserPO ";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public int countNews() {
        String hql = "SELECT COUNT(*) FROM NewsPO";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public int countComment() {
        String hql = "SELECT COUNT(*) FROM CommentPO";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public int countLook() {
        try {
            return MyFileUtils.readTxtFile();
        } catch (IOException e) {
            return 0;
        }
    }
}
