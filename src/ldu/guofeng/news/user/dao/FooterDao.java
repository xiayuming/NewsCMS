package ldu.guofeng.news.user.dao;

import ldu.guofeng.news.admin.domain.SiteInfoPO;

/**
 * Created by GUOFENG on 2017/5/7.
 */
public interface FooterDao {
    SiteInfoPO findFooter(int wsId);
}
