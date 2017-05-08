package ldu.guofeng.news.admin.service;

import ldu.guofeng.news.admin.domain.HeadNewsPO;
import ldu.guofeng.news.admin.domain.PageBean;

/**
 * Created by GUOFENG on 2017/4/19.
 */
public interface HeadNewsService {


    void deleteHeadNews(HeadNewsPO headNewsPO);

    PageBean<HeadNewsPO> findHeadNews();

    HeadNewsPO existHeadNews(HeadNewsPO headNewsPO);

    void addHeadNews(HeadNewsPO headNewsPO);

    void updateHeadNews(HeadNewsPO headNewsPO);
}
