package ldu.guofeng.news.admin.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import ldu.guofeng.news.admin.domain.CommentPO;
import ldu.guofeng.news.admin.domain.PageBean;
import ldu.guofeng.news.admin.service.CommentService;

/**
 * Created by GUOFENG on 2017/4/20.
 */
public class CommentAction extends ActionSupport implements ModelDriven<CommentPO> {
    private CommentPO commentPO = new CommentPO();
    private CommentService commentService;
    private String checkComment;

    @Override
    public CommentPO getModel() {
        return commentPO;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    //获取当前页
    private int currentPage = 1;

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String findComment() {
        PageBean<CommentPO> pageBean = commentService.findComment(currentPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findCommentSuccess";
    }

    public String deleteComment() {
        commentService.deleteComment(commentPO);
        return "deleteCommentSuccess";
    }

    public String deleteMoreComment() {
        String[] checkCommentIDs = this.getCheckComment().split(",");
        commentService.deleteMoreComment(checkCommentIDs);
        return "deleteMoreCommentSuccess";
    }

    public String getCheckComment() {
        return checkComment;
    }

    public void setCheckComment(String checkComment) {
        this.checkComment = checkComment;
    }
}
