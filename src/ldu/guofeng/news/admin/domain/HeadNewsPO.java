package ldu.guofeng.news.admin.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by GUOFENG on 2017/4/19.
 */
@Entity
@Table(name = "headnews", schema = "newssystem", catalog = "")
public class HeadNewsPO {
    private int headId;
    private String headTitle;
    private String headImg;
    private NewsPO newsPO;

    @Id
    @GeneratedValue(generator = "headIdGenerator")
    @GenericGenerator(name = "headIdGenerator", strategy = "assigned")
    @Column(name = "head_id")
    public int getHeadId() {
        return headId;
    }

    public void setHeadId(int headId) {
        this.headId = headId;
    }

    @Basic
    @Column(name = "head_title")
    public String getHeadTitle() {
        return headTitle;
    }

    public void setHeadTitle(String headTitle) {
        this.headTitle = headTitle;
    }

    @Basic
    @Column(name = "head_img")
    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }


    @ManyToOne
    @JoinColumn(name = "news_id", foreignKey = @ForeignKey(name = "NEWS_ID_FK"))
    public NewsPO getNewsPO() {
        return newsPO;
    }

    public void setNewsPO(NewsPO newsPO) {
        this.newsPO = newsPO;
    }
}
