package ldu.guofeng.news.user.dao.impl;

import ldu.guofeng.news.admin.domain.SiteInfoPO;
import ldu.guofeng.news.user.dao.FooterDao;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by GUOFENG on 2017/5/7.
 */
public class FooterDaoImpl extends HibernateDaoSupport implements FooterDao {
    @Override
    public SiteInfoPO findFooter(int wsId) {
        String hql = "FROM SiteInfoPO WHERE wsId=?";
        List<SiteInfoPO> siteInfoPOS = (List<SiteInfoPO>) this.getHibernateTemplate().find(hql, wsId);
        if (siteInfoPOS.size() > 0) {
            return siteInfoPOS.get(0);
        }
        return null;
    }
}
