package ldu.guofeng.news.admin.service.impl;

import ldu.guofeng.news.admin.dao.CommentDao;
import ldu.guofeng.news.admin.domain.CommentPO;
import ldu.guofeng.news.admin.domain.PageBean;
import ldu.guofeng.news.admin.service.CommentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by GUOFENG on 2017/4/20.
 */
@Transactional
public class CommentServiceImpl implements CommentService {
    private CommentDao commentDao;

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public PageBean<CommentPO> findComment(int currentPage) {
        PageBean<CommentPO> pageBean = new PageBean<CommentPO>();
        // 封装当前页数
        pageBean.setCurrentPage(currentPage);
        // 封装每页显示记录数
        int pageCount = 5;
        pageBean.setPageCount(pageCount);
        // 封装总记录数
        int totalSize = commentDao.findCountComment();
        pageBean.setTotalSize(totalSize);
        // 封装总页数
        double ts = totalSize;
        Double num = Math.ceil(ts / pageCount);
        pageBean.setPageSize(num.intValue());
        // 封装每页显示的数据
        int begin = (currentPage - 1) * pageCount;
        //查找出指定页数中的 List<FriendPO>
        List<CommentPO> list = commentDao.findComment(begin, pageCount);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void deleteComment(CommentPO commentPO) {
        commentDao.deleteComment(commentPO);
    }

    @Override
    public void deleteMoreComment(String[] checkCommentIDs) {
        commentDao.deleteMoreComment(checkCommentIDs);
    }
}
