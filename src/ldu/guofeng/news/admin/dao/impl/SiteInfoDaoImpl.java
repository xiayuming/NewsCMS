package ldu.guofeng.news.admin.dao.impl;

import ldu.guofeng.news.admin.dao.SiteInfoDao;
import ldu.guofeng.news.admin.domain.SiteInfoPO;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by GUOFENG on 2017/4/17.
 */
public class SiteInfoDaoImpl extends HibernateDaoSupport implements SiteInfoDao {
    @Override
    public SiteInfoPO findInfo(int wsId) {
        String hql = "FROM SiteInfoPO WHERE wsId=?";
        List<SiteInfoPO> siteInfoPOS = (List<SiteInfoPO>) this.getHibernateTemplate().find(hql, wsId);
        if (siteInfoPOS.size() > 0) {
            return siteInfoPOS.get(0);
        }
        return null;
    }

    @Override
    public void saveOrUpdateInfo(SiteInfoPO siteInfoPO) {
        this.getHibernateTemplate().saveOrUpdate(siteInfoPO);
    }
}
