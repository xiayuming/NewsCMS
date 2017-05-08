package ldu.guofeng.news.user.dao.impl;

import ldu.guofeng.news.admin.domain.CommentPO;
import ldu.guofeng.news.user.dao.ReviewDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by GUOFENG on 2017/5/7.
 */
public class ReviewDaoImpl extends HibernateDaoSupport implements ReviewDao {
    @Override
    public List<CommentPO> findReviewOfFive(int begin, int count, int newsId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(CommentPO.class);
        criteria.add(Restrictions.eq("newsPO.newsId", newsId));
        criteria.addOrder(Order.desc("id"));
        List<CommentPO> list = (List<CommentPO>) this.getHibernateTemplate().findByCriteria(criteria, begin, count);
        return list;
    }

    @Override
    public void addReview(CommentPO commentPO) {
        this.getHibernateTemplate().save(commentPO);
    }
}
