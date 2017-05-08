package ldu.guofeng.news.user.service;

import ldu.guofeng.news.admin.domain.HeadNewsPO;
import ldu.guofeng.news.admin.domain.NewsPO;

import java.util.List;

/**
 * Created by GUOFENG on 2017/5/5.
 */
public interface IndexService {
    List<HeadNewsPO> findNewsOfHead();

    int PageSizeOfSociety(int pageCount);

    List<NewsPO> findNewsOfSociety(int societyCurrentPage, int pageCount);

    int PageSizeOfTech(int pageCount);

    List<NewsPO> findNewsOfTech(int techCurrentPage, int pageCount);

    int PageSizeOfInte(int pageCount);

    List<NewsPO> findNewsOfInte(int inteCurrentPage, int pageCount);

    int PageSizeOfMili(int pageCount);

    List<NewsPO> findNewsOfMili(int miliCurrentPage, int pageCount);

    int PageSizeOfHot(int pageCount);

    List<NewsPO> findNewsOfHot(int hotCurrentPage, int pageCount);

    NewsPO findNewsOfThis(int thisNewsId);

}
