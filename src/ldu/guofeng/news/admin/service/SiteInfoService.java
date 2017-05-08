package ldu.guofeng.news.admin.service;

import ldu.guofeng.news.admin.domain.SiteInfoPO;

/**
 * Created by GUOFENG on 2017/4/17.
 */
public interface SiteInfoService {
    SiteInfoPO findInfo(int wsId);

    void saveInfo(SiteInfoPO siteInfoPO);
}
