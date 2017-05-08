package ldu.guofeng.news.admin.service;

import ldu.guofeng.news.admin.domain.CommentPO;
import ldu.guofeng.news.admin.domain.PageBean;

/**
 * Created by GUOFENG on 2017/4/20.
 */
public interface CommentService {
    PageBean<CommentPO> findComment(int currentPage);

    void deleteComment(CommentPO commentPO);

    void deleteMoreComment(String[] checkCommentIDs);
}
