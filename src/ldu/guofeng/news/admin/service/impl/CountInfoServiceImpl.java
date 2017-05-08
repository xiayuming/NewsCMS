package ldu.guofeng.news.admin.service.impl;

import ldu.guofeng.news.admin.dao.CountInfoDao;
import ldu.guofeng.news.admin.domain.CountInfoPO;
import ldu.guofeng.news.admin.service.CountInfoService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by GUOFENG on 2017/4/20.
 */
@Transactional
public class CountInfoServiceImpl implements CountInfoService {
    private CountInfoDao countInfoDao;

    public void setCountInfoDao(CountInfoDao countInfoDao) {
        this.countInfoDao = countInfoDao;
    }

    @Override
    public CountInfoPO countInfo() {
        CountInfoPO countInfoPO = new CountInfoPO();
        countInfoPO.setCountUser(countInfoDao.countUser());
        countInfoPO.setCountNews(countInfoDao.countNews());
        countInfoPO.setCountComment(countInfoDao.countComment());
        countInfoPO.setCountLook(countInfoDao.countLook());
        return countInfoPO;
    }
}
