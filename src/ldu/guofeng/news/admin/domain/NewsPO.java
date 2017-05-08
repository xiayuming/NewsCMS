package ldu.guofeng.news.admin.domain;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

/**
 * Created by GUOFENG on 2017/4/17.
 */
@Entity
@Table(name = "news", schema = "newssystem", catalog = "")
public class NewsPO {
    private int newsId;
    private String newsTitle;
    private String newsContent;
    private String newsKey;
    private String newsAuthor;
    private String newsImg;
    private java.util.Date newsDate;
    private NewsTypePO newsTypePO;

    @Id
    @Column(name = "news_id")
    @ColumnDefault("0")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    @Basic
    @Column(name = "news_title")
    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    @Basic
    @Column(name = "news_content")
    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Basic
    @Column(name = "news_key")
    public String getNewsKey() {
        return newsKey;
    }

    public void setNewsKey(String newsKey) {
        this.newsKey = newsKey;
    }

    @Basic
    @Column(name = "news_author")
    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    @Basic
    @Column(name = "news_img")
    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg;
    }

    @Basic
    @Column(name = "news_date")
    public java.util.Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(java.util.Date newsDate) {
        this.newsDate = newsDate;
    }

    /**
     * type_id 外键
     *
     * @return
     */
    @ManyToOne
    @JoinColumn(name = "type_id", foreignKey = @ForeignKey(name = "NEWSTYPE_ID_FK"))
    public NewsTypePO getNewsTypePO() {
        return newsTypePO;
    }

    public void setNewsTypePO(NewsTypePO newsTypePO) {
        this.newsTypePO = newsTypePO;
    }
}
