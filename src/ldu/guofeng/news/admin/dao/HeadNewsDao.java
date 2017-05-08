package ldu.guofeng.news.admin.dao;

import ldu.guofeng.news.admin.domain.HeadNewsPO;

import java.util.List;

/**
 * Created by GUOFENG on 2017/4/19.
 */
public interface HeadNewsDao {



    void deleteHeadNews(HeadNewsPO headNewsPO);

    List<HeadNewsPO> findHeadNews();

    void addHeadNews(HeadNewsPO headNewsPO);

    void updateHeadNews(HeadNewsPO headNewsPO);

    HeadNewsPO existHeadNews(HeadNewsPO headNewsPO);
}
