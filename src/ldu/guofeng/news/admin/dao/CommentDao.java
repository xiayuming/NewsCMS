package ldu.guofeng.news.admin.dao;

import ldu.guofeng.news.admin.domain.CommentPO;

import java.util.List;

/**
 * Created by GUOFENG on 2017/4/20.
 */
public interface CommentDao {
    int findCountComment();

    List<CommentPO> findComment(int begin, int pageCount);

    void deleteComment(CommentPO commentPO);

    void deleteMoreComment(String[] checkCommentIDs);

}
