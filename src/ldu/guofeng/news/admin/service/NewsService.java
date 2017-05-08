package ldu.guofeng.news.admin.service;

import ldu.guofeng.news.admin.domain.NewsPO;
import ldu.guofeng.news.admin.domain.PageBean;

/**
 * Created by GUOFENG on 2017/4/16.
 */
public interface NewsService {
    void addNews(NewsPO newsPO);

    void deleteNews(NewsPO newsPO);

    PageBean<NewsPO> findNewsByCondition(int currentPage, int typeId, String newsKey);

    void deleteMoreNews(String[] checkNewsIDs);

}
