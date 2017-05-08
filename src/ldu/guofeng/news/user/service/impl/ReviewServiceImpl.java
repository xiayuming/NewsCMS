package ldu.guofeng.news.user.service.impl;

import ldu.guofeng.news.admin.domain.CommentPO;
import ldu.guofeng.news.user.dao.ReviewDao;
import ldu.guofeng.news.user.service.ReviewService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by GUOFENG on 2017/5/7.
 */
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private ReviewDao reviewDao;

    public void setReviewDao(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    public List<CommentPO> findReviewOfFive(int newsId) {
        int begin = 0;
        int count = 5;
        return reviewDao.findReviewOfFive(begin, count,newsId);
    }

    @Override
    public void addReview(CommentPO commentPO) {
        reviewDao.addReview(commentPO);
    }
}
