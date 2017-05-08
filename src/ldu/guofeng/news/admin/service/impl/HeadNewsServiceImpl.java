package ldu.guofeng.news.admin.service.impl;

import ldu.guofeng.news.admin.dao.HeadNewsDao;
import ldu.guofeng.news.admin.domain.HeadNewsPO;
import ldu.guofeng.news.admin.domain.PageBean;
import ldu.guofeng.news.admin.service.HeadNewsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by GUOFENG on 2017/4/19.
 */
@Transactional
public class HeadNewsServiceImpl implements HeadNewsService {
    private HeadNewsDao headNewsDao;

    public void setHeadNewsDao(HeadNewsDao headNewsDao) {
        this.headNewsDao = headNewsDao;
    }

    @Override
    public HeadNewsPO existHeadNews(HeadNewsPO headNewsPO) {
        return headNewsDao.existHeadNews(headNewsPO);
    }

    @Override
    public void addHeadNews(HeadNewsPO headNewsPO) {
        headNewsDao.addHeadNews(headNewsPO);
    }

    @Override
    public void updateHeadNews(HeadNewsPO headNewsPO) {
        headNewsDao.updateHeadNews(headNewsPO);
    }


    @Override
    public void deleteHeadNews(HeadNewsPO headNewsPO) {
        headNewsDao.deleteHeadNews(headNewsPO);
    }

    @Override
    public PageBean<HeadNewsPO> findHeadNews() {
        PageBean<HeadNewsPO> pageBean = new PageBean<HeadNewsPO>();
        // 封装每页显示的数据
        List<HeadNewsPO> list = headNewsDao.findHeadNews();
        pageBean.setList(list);
        return pageBean;
    }
}
