package ldu.guofeng.news.admin.dao;

import ldu.guofeng.news.admin.domain.NewsPO;

import java.util.List;

/**
 * Created by GUOFENG on 2017/4/16.
 */
public interface NewsDao {
    void addNews(NewsPO newsPO);

    void deleteNews(NewsPO newsPO);

    int findCountNewsByCondition(int typeId, String newsKey);

    List<NewsPO> findNewsByCondition(int begin, int pageCount, int typeId, String newsKey);

    void deleteMoreNews(String[] checkNewsIDs);

}
