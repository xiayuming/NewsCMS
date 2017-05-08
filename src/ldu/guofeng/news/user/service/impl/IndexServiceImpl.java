package ldu.guofeng.news.user.service.impl;

import ldu.guofeng.news.admin.domain.HeadNewsPO;
import ldu.guofeng.news.admin.domain.NewsPO;
import ldu.guofeng.news.user.dao.IndexDao;
import ldu.guofeng.news.user.service.IndexService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by GUOFENG on 2017/5/5.
 */
@Transactional
public class IndexServiceImpl implements IndexService {
    private IndexDao indexDao;

    public void setIndexDao(IndexDao indexDao) {
        this.indexDao = indexDao;
    }

    @Override
    public NewsPO findNewsOfThis(int thisNewsId) {
        return indexDao.findNewsOfThis(thisNewsId);
    }


    @Override
    public List<HeadNewsPO> findNewsOfHead() {
        List<HeadNewsPO> list = indexDao.findNewsOfHead();
        return list;
    }

    @Override
    public int PageSizeOfHot(int pageCount) {
        // 封装总记录数
        int totalSize = indexDao.findCountNewsOfHot();
        // 封装总页数
        double ts = totalSize;
        Double num = Math.ceil(ts / pageCount);
        return num.intValue();
    }

    @Override
    public List<NewsPO> findNewsOfHot(int hotCurrentPage, int pageCount) {
        int begin = (hotCurrentPage - 1) * pageCount;
        List<NewsPO> list = indexDao.findNewsOfHot(begin, pageCount);
        return list;
    }

    @Override
    public int PageSizeOfSociety(int pageCount) {
        // 封装总记录数
        int totalSize = indexDao.findCountNewsOfSociety();
        // 封装总页数
        double ts = totalSize;
        Double num = Math.ceil(ts / pageCount);
        return num.intValue();
    }

    @Override
    public List<NewsPO> findNewsOfSociety(int societyCurrentPage, int pageCount) {
        int begin = (societyCurrentPage - 1) * pageCount;
        List<NewsPO> list = indexDao.findNewsOfSociety(begin, pageCount);
        return list;
    }


    @Override
    public int PageSizeOfTech(int pageCount) {
        int totalSize = indexDao.findCountNewsOfTech();
        double ts = totalSize;
        Double num = Math.ceil(ts / pageCount);
        return num.intValue();
    }

    @Override
    public List<NewsPO> findNewsOfTech(int techCurrentPage, int pageCount) {
        int begin = (techCurrentPage - 1) * pageCount;
        List<NewsPO> list = indexDao.findNewsOfTech(begin, pageCount);
        return list;
    }

    @Override
    public int PageSizeOfInte(int pageCount) {
        int totalSize = indexDao.findCountNewsOfInte();
        double ts = totalSize;
        Double num = Math.ceil(ts / pageCount);
        return num.intValue();
    }

    @Override
    public List<NewsPO> findNewsOfInte(int inteCurrentPage, int pageCount) {
        int begin = (inteCurrentPage - 1) * pageCount;
        List<NewsPO> list = indexDao.findNewsOfInte(begin, pageCount);
        return list;
    }

    @Override
    public int PageSizeOfMili(int pageCount) {
        int totalSize = indexDao.findCountNewsOfMili();
        double ts = totalSize;
        Double num = Math.ceil(ts / pageCount);
        return num.intValue();
    }

    @Override
    public List<NewsPO> findNewsOfMili(int miliCurrentPage, int pageCount) {
        int begin = (miliCurrentPage - 1) * pageCount;
        List<NewsPO> list = indexDao.findNewsOfMili(begin, pageCount);
        return list;
    }
}
