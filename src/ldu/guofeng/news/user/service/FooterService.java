package ldu.guofeng.news.user.service;

import ldu.guofeng.news.admin.domain.SiteInfoPO;

/**
 * Created by GUOFENG on 2017/5/7.
 */
public interface FooterService {
    SiteInfoPO findFooter(int wsId);
}
