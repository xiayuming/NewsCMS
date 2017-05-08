package ldu.guofeng.news.admin.dao.impl;

import ldu.guofeng.news.admin.dao.NewsDao;
import ldu.guofeng.news.admin.domain.NewsPO;
import ldu.guofeng.news.utils.Constant;
import ldu.guofeng.news.utils.MyFileUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by GUOFENG on 2017/4/16.
 */
public class NewsDaoImpl extends HibernateDaoSupport implements NewsDao {

    @Override
    public void addNews(NewsPO newsPO) {
        this.getHibernateTemplate().save(newsPO);
    }

    @Override
    public void deleteNews(NewsPO newsPO) {
        NewsPO thisNews = this.getHibernateTemplate().get(NewsPO.class, newsPO.getNewsId());
        if (thisNews.getNewsImg() != null) {
            MyFileUtils.deleteFile(Constant.systemPath + "\\" + thisNews.getNewsImg());
        }
        this.getHibernateTemplate().delete(thisNews);
    }

    @Override
    public int findCountNewsByCondition(int typeId, String newsKey) {
        List<Long> list = null;
        String hql;
        if (typeId == 0 && !newsKey.equals("")) {//只有关键词
            hql = "SELECT COUNT(*) FROM NewsPO WHERE newsKey LIKE ?";
            list = (List<Long>) this.getHibernateTemplate().find(hql, "%" + newsKey + "%");
        } else if (typeId != 0 && newsKey.equals("")) {//只有类别
            hql = "SELECT COUNT(*) FROM NewsPO WHERE newsTypePO.id=?";
            list = (List<Long>) this.getHibernateTemplate().find(hql, typeId);
        } else if (typeId != 0 && !newsKey.equals("")) {//类别和关键词都有
            hql = "SELECT COUNT(*) FROM NewsPO WHERE newsTypePO.id=? AND newsKey LIKE ?";
            list = (List<Long>) this.getHibernateTemplate().find(hql, typeId, "%" + newsKey + "%");
        } else {
            hql = "SELECT COUNT(*) FROM NewsPO";
            list = (List<Long>) this.getHibernateTemplate().find(hql);
        }
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<NewsPO> findNewsByCondition(int begin, int pageCount, int typeId, String newsKey) {
        DetachedCriteria criteria = DetachedCriteria.forClass(NewsPO.class);
        if (typeId != 0) {
            criteria.add(Restrictions.eq("newsTypePO.typeId", typeId));
        }
        if (!newsKey.equals("")) {
            criteria.add(Restrictions.like("newsKey", "%" + newsKey + "%"));
        }
        criteria.addOrder(Order.desc("id"));
        List<NewsPO> list = (List<NewsPO>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageCount);
        return list;
    }

    @Override
    public void deleteMoreNews(String[] checkNewsIDs) {
        for (String newsID : checkNewsIDs) {
            NewsPO thisNews = this.getHibernateTemplate().get(NewsPO.class, Integer.parseInt(newsID.trim()));
            if (thisNews.getNewsImg() != null) {
                MyFileUtils.deleteFile(Constant.systemPath + "\\" + thisNews.getNewsImg());
            }
            this.getHibernateTemplate().delete(thisNews);
        }
    }
}
