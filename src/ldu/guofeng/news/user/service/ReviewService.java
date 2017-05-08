package ldu.guofeng.news.user.service;

import ldu.guofeng.news.admin.domain.CommentPO;

import java.util.List;

/**
 * Created by GUOFENG on 2017/5/7.
 */
public interface ReviewService {
    List<CommentPO> findReviewOfFive(int newsId);

    void addReview(CommentPO commentPO);
}
