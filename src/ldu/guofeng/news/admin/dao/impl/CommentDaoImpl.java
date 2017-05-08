package ldu.guofeng.news.admin.dao.impl;

import ldu.guofeng.news.admin.dao.CommentDao;
import ldu.guofeng.news.admin.domain.CommentPO;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by GUOFENG on 2017/4/20.
 */
public class CommentDaoImpl extends HibernateDaoSupport implements CommentDao {
    @Override
    public int findCountComment() {
        String hql = "SELECT COUNT(*) FROM CommentPO ";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<CommentPO> findComment(int begin, int pageCount) {
        DetachedCriteria criteria = DetachedCriteria.forClass(CommentPO.class);
        criteria.addOrder(Order.desc("id"));
        List<CommentPO> list = (List<CommentPO>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageCount);
        return list;
    }

    @Override
    public void deleteComment(CommentPO commentPO) {
        this.getHibernateTemplate().delete(commentPO);
    }

    @Override
    public void deleteMoreComment(String[] checkCommentIDs) {
        for (String commentID : checkCommentIDs) {
            CommentPO thisComment = this.getHibernateTemplate().get(CommentPO.class, Integer.parseInt(commentID.trim()));
            this.getHibernateTemplate().delete(thisComment);
        }
    }
}
