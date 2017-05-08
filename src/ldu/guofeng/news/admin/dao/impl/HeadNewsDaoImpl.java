package ldu.guofeng.news.admin.dao.impl;

import ldu.guofeng.news.admin.dao.HeadNewsDao;
import ldu.guofeng.news.admin.domain.HeadNewsPO;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GUOFENG on 2017/4/19.
 */
public class HeadNewsDaoImpl extends HibernateDaoSupport implements HeadNewsDao {
    @Override
    public HeadNewsPO existHeadNews(HeadNewsPO headNewsPO) {
        return this.getHibernateTemplate().get(HeadNewsPO.class, headNewsPO.getHeadId());
    }

    @Override
    public void addHeadNews(HeadNewsPO headNewsPO) {
        this.getHibernateTemplate().save(headNewsPO);
    }

    @Override
    public void updateHeadNews(HeadNewsPO headNewsPO) {
        this.getHibernateTemplate().update(headNewsPO);
    }

    @Override
    public void deleteHeadNews(HeadNewsPO headNewsPO) {
        this.getHibernateTemplate().delete(headNewsPO);
    }


    @Override
    public List<HeadNewsPO> findHeadNews() {
        String hql = "FROM HeadNewsPO";
        ArrayList<HeadNewsPO> headNewsPOList = (ArrayList<HeadNewsPO>) this.getHibernateTemplate().find(hql);
        if (headNewsPOList.size() > 0) {
            return headNewsPOList;
        }
        return null;
    }

}
