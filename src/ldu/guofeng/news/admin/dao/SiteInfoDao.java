package ldu.guofeng.news.admin.dao;

import ldu.guofeng.news.admin.domain.SiteInfoPO;

/**
 * Created by GUOFENG on 2017/4/17.
 */
public interface SiteInfoDao {
    SiteInfoPO findInfo(int wsId);

    void saveOrUpdateInfo(SiteInfoPO siteInfoPO);
}
