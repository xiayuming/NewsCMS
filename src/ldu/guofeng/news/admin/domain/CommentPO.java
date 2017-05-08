package ldu.guofeng.news.admin.domain;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

/**
 * Created by GUOFENG on 2017/4/13.
 */
@Entity
@Table(name = "comment", schema = "newssystem", catalog = "")
public class CommentPO {
    private int cmtId;
    private NewsPO newsPO;
    private UserPO userPO;
    private String cmtContent;
    private java.util.Date cmtDate;

    @Id
    @Column(name = "cmt_id")
    @ColumnDefault("0")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCmtId() {
        return cmtId;
    }

    public void setCmtId(int cmtId) {
        this.cmtId = cmtId;
    }

    @ManyToOne
    @JoinColumn(name = "news_id", foreignKey = @ForeignKey(name = "NEWS_ID_FK"))
    public NewsPO getNewsPO() {
        return newsPO;
    }

    public void setNewsPO(NewsPO newsPO) {
        this.newsPO = newsPO;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "USER_ID_FK"))
    public UserPO getUserPO() {
        return userPO;
    }

    public void setUserPO(UserPO userPO) {
        this.userPO = userPO;
    }

    @Basic
    @Column(name = "cmt_content")
    public String getCmtContent() {
        return cmtContent;
    }

    public void setCmtContent(String cmtContent) {
        this.cmtContent = cmtContent;
    }

    @Basic
    @Column(name = "cmt_date")
    public java.util.Date getCmtDate() {
        return cmtDate;
    }

    public void setCmtDate(java.util.Date cmtDate) {
        this.cmtDate = cmtDate;
    }


}
