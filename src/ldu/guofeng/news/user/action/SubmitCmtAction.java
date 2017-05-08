package ldu.guofeng.news.user.action;

import com.opensymphony.xwork2.ActionSupport;
import ldu.guofeng.news.admin.domain.CommentPO;
import ldu.guofeng.news.admin.domain.NewsPO;
import ldu.guofeng.news.admin.domain.UserPO;
import ldu.guofeng.news.user.service.ReviewService;
import net.sf.json.JSONArray;

import java.util.Date;

/**
 * Created by GUOFENG on 2017/5/8.
 */
public class SubmitCmtAction extends ActionSupport {

    private ReviewService reviewService;
    private JSONArray root;

    private int newsId;
    private int userId;
    private String cmtContent;

    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    public String addReview() {
        CommentPO commentPO = new CommentPO();
        NewsPO newsPO = new NewsPO();
        newsPO.setNewsId(newsId);
        commentPO.setNewsPO(newsPO);
        UserPO userPO = new UserPO();
        userPO.setUserId(userId);
        commentPO.setUserPO(userPO);
        commentPO.setCmtContent(cmtContent);
        commentPO.setCmtDate(new Date());
        reviewService.addReview(commentPO);
        root = JSONArray.fromObject(1);
        return SUCCESS;
    }

    public JSONArray getRoot() {
        return root;
    }

    public void setRoot(JSONArray root) {
        this.root = root;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCmtContent() {
        return cmtContent;
    }

    public void setCmtContent(String cmtContent) {
        this.cmtContent = cmtContent;
    }

}
