package ldu.guofeng.news.admin.service.impl;

import ldu.guofeng.news.admin.dao.NewsDao;
import ldu.guofeng.news.admin.domain.NewsPO;
import ldu.guofeng.news.admin.domain.PageBean;
import ldu.guofeng.news.admin.service.NewsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by GUOFENG on 2017/4/16.
 */
@Transactional
public class NewsServiceImpl implements NewsService{

    private NewsDao newsDao;

    public void setNewsDao(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    public void addNews(NewsPO newsPO) {
        newsDao.addNews(newsPO);
    }

    @Override
    public void deleteNews(NewsPO newsPO) {
        newsDao.deleteNews(newsPO);
    }


    @Override
    public PageBean<NewsPO> findNewsByCondition(int currentPage, int typeId, String newsKey) {
        PageBean<NewsPO> pageBean = new PageBean<NewsPO>();
        // 封装当前页数
        pageBean.setCurrentPage(currentPage);
        // 封装每页显示记录数
        int pageCount = 5;
        pageBean.setPageCount(pageCount);
        // 封装总记录数
        int totalSize = newsDao.findCountNewsByCondition(typeId,newsKey);
        pageBean.setTotalSize(totalSize);
        // 封装总页数
        double ts = totalSize;
        Double num = Math.ceil(ts / pageCount);
        pageBean.setPageSize(num.intValue());
        // 封装每页显示的数据
        int begin = (currentPage - 1) * pageCount;
        //查找出指定页数中的 List<FriendPO>
        List<NewsPO> list = newsDao.findNewsByCondition(begin, pageCount,typeId,newsKey);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void deleteMoreNews(String[] checkNewsIDs) {
        newsDao.deleteMoreNews(checkNewsIDs);
    }
}
