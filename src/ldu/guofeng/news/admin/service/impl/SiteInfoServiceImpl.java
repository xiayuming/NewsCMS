package ldu.guofeng.news.admin.service.impl;

import ldu.guofeng.news.admin.dao.SiteInfoDao;
import ldu.guofeng.news.admin.domain.SiteInfoPO;
import ldu.guofeng.news.admin.service.SiteInfoService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by GUOFENG on 2017/4/17.
 */
@Transactional
public class SiteInfoServiceImpl implements SiteInfoService {

    private SiteInfoDao siteInfoDao;

    public void setSiteInfoDao(SiteInfoDao siteInfoDao) {
        this.siteInfoDao = siteInfoDao;
    }

    @Override
    public SiteInfoPO findInfo(int wsId) {
        return siteInfoDao.findInfo(wsId);
    }

    @Override
    public void saveInfo(SiteInfoPO siteInfoPO) {
        siteInfoDao.saveOrUpdateInfo(siteInfoPO);
    }
}
