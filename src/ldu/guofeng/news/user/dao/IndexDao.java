package ldu.guofeng.news.user.dao;

import ldu.guofeng.news.admin.domain.HeadNewsPO;
import ldu.guofeng.news.admin.domain.NewsPO;

import java.util.List;

/**
 * Created by GUOFENG on 2017/5/5.
 */
public interface IndexDao {
    List<HeadNewsPO> findNewsOfHead();

    int findCountNewsOfHot();

    List<NewsPO> findNewsOfHot(int begin, int pageCount);

    int findCountNewsOfSociety();

    List<NewsPO> findNewsOfSociety(int begin, int pageCount);

    int findCountNewsOfTech();

    List<NewsPO> findNewsOfTech(int begin, int pageCount);

    int findCountNewsOfInte();

    List<NewsPO> findNewsOfInte(int begin, int pageCount);

    int findCountNewsOfMili();

    List<NewsPO> findNewsOfMili(int begin, int pageCount);


    NewsPO findNewsOfThis(int thisNewsId);

}
