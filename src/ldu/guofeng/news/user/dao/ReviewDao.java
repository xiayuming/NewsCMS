package ldu.guofeng.news.user.dao;

import ldu.guofeng.news.admin.domain.CommentPO;

import java.util.List;

/**
 * Created by GUOFENG on 2017/5/7.
 */
public interface ReviewDao {
    List<CommentPO> findReviewOfFive(int begin, int count, int newsId);

    void addReview(CommentPO commentPO);

}
