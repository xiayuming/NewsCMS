package ldu.guofeng.news.user.action;

import com.opensymphony.xwork2.ActionSupport;
import ldu.guofeng.news.admin.domain.CommentPO;
import ldu.guofeng.news.user.service.ReviewService;
import net.sf.json.JSONArray;

import java.util.List;

/**
 * Created by GUOFENG on 2017/5/7.
 */
public class ReviewAction extends ActionSupport {

    private JSONArray root;
    private ReviewService reviewService;
    private int cmtnewsid;

    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    public String findReview() {
        System.out.println("新闻id" + cmtnewsid);
        List<CommentPO> commentPOList = reviewService.findReviewOfFive(cmtnewsid);
        if (commentPOList != null) {
            root = JSONArray.fromObject(commentPOList);
        }
        return SUCCESS;
    }


    public JSONArray getRoot() {
        return root;
    }

    public void setRoot(JSONArray root) {
        this.root = root;
    }

    public void setCmtnewsid(int cmtnewsid) {
        this.cmtnewsid = cmtnewsid;
    }
}
