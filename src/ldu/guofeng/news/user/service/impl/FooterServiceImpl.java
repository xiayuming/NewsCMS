package ldu.guofeng.news.user.service.impl;

import ldu.guofeng.news.admin.domain.SiteInfoPO;
import ldu.guofeng.news.user.dao.FooterDao;
import ldu.guofeng.news.user.service.FooterService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by GUOFENG on 2017/5/7.
 */
@Transactional
public class FooterServiceImpl implements FooterService {
    private FooterDao footerDao;

    public void setFooterDao(FooterDao footerDao) {
        this.footerDao = footerDao;
    }

    @Override
    public SiteInfoPO findFooter(int wsId) {
        return footerDao.findFooter(wsId);
    }
}
