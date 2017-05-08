package ldu.guofeng.news.user.dao.impl;

import ldu.guofeng.news.admin.domain.HeadNewsPO;
import ldu.guofeng.news.admin.domain.NewsPO;
import ldu.guofeng.news.user.dao.IndexDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by GUOFENG on 2017/5/5.
 */
public class IndexDaoImpl extends HibernateDaoSupport implements IndexDao {


    @Override
    public NewsPO findNewsOfThis(int thisNewsId) {
        return this.getHibernateTemplate().get(NewsPO.class, thisNewsId);
    }


    @Override
    public List<HeadNewsPO> findNewsOfHead() {
        DetachedCriteria criteria = DetachedCriteria.forClass(HeadNewsPO.class);
        criteria.addOrder(Order.desc("id"));
        List<HeadNewsPO> list = (List<HeadNewsPO>) this.getHibernateTemplate().findByCriteria(criteria);
        return list;
    }


    @Override
    public int findCountNewsOfHot() {
        String sql = "select COUNT(distinct news_id) from `comment`";

        return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
            @Override
            public Integer doInHibernate(Session session) throws HibernateException {
                Query query = session.createSQLQuery(sql);
                return ((BigInteger) query.uniqueResult()).intValue();
            }
        });
    }

    /**
     * 此方法有更优雅的方式编写，请不啬赐教。
     * iamguofeng@163.com
     *
     * @param begin
     * @param pageCount
     * @return
     */
    @Override
    public List<NewsPO> findNewsOfHot(int begin, int pageCount) {
        String sql = "SELECT  mynews.*  FROM `news` as mynews,(select news_id as  nid,count(*) as ct FROM `comment` GROUP BY `comment`.news_id) as mycount WHERE mynews.news_id=mycount.nid ORDER BY mycount.ct DESC";
        return this.getHibernateTemplate().execute(new HibernateCallback<List<NewsPO>>() {
            @Override
            public List<NewsPO> doInHibernate(Session session) throws HibernateException {
                Query query = session.createSQLQuery(sql).addEntity(NewsPO.class)
                        .setFirstResult(begin)
                        .setMaxResults(pageCount);
                return (List<NewsPO>) query.list();
            }
        });
    }

    //--------------------------------------------------------
    @Override
    public int findCountNewsOfSociety() {
        String hql = "SELECT COUNT(*) FROM NewsPO WHERE newsTypePO.id=?";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, 1);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<NewsPO> findNewsOfSociety(int begin, int pageCount) {
        DetachedCriteria criteria = DetachedCriteria.forClass(NewsPO.class);
        criteria.add(Restrictions.eq("newsTypePO.typeId", 1));
        criteria.addOrder(Order.desc("id"));
        List<NewsPO> list = (List<NewsPO>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageCount);
        return list;
    }

    @Override
    public int findCountNewsOfTech() {
        String hql = "SELECT COUNT(*) FROM NewsPO WHERE newsTypePO.id=?";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, 2);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<NewsPO> findNewsOfTech(int begin, int pageCount) {
        DetachedCriteria criteria = DetachedCriteria.forClass(NewsPO.class);
        criteria.add(Restrictions.eq("newsTypePO.typeId", 2));
        criteria.addOrder(Order.desc("id"));
        List<NewsPO> list = (List<NewsPO>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageCount);
        return list;
    }

    @Override
    public int findCountNewsOfInte() {
        String hql = "SELECT COUNT(*) FROM NewsPO WHERE newsTypePO.id=?";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, 3);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<NewsPO> findNewsOfInte(int begin, int pageCount) {
        DetachedCriteria criteria = DetachedCriteria.forClass(NewsPO.class);
        criteria.add(Restrictions.eq("newsTypePO.typeId", 3));
        criteria.addOrder(Order.desc("id"));
        List<NewsPO> list = (List<NewsPO>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageCount);
        return list;
    }

    @Override
    public int findCountNewsOfMili() {
        String hql = "SELECT COUNT(*) FROM NewsPO WHERE newsTypePO.id=?";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, 4);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<NewsPO> findNewsOfMili(int begin, int pageCount) {
        DetachedCriteria criteria = DetachedCriteria.forClass(NewsPO.class);
        criteria.add(Restrictions.eq("newsTypePO.typeId", 4));
        criteria.addOrder(Order.desc("id"));
        List<NewsPO> list = (List<NewsPO>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageCount);
        return list;
    }
}
