package ldu.guofeng.news.admin.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import ldu.guofeng.news.admin.domain.NewsPO;
import ldu.guofeng.news.admin.domain.NewsTypePO;
import ldu.guofeng.news.admin.domain.PageBean;
import ldu.guofeng.news.admin.service.NewsService;
import ldu.guofeng.news.utils.Constant;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by GUOFENG on 2017/4/16.
 */
public class NewsAction extends ActionSupport implements ModelDriven<NewsPO> {

    private NewsPO newsPO = new NewsPO();
    private NewsService newsService;
    private File file;//上传文件
    private String fileFileName;//上传文件名
    private String checkNews;//多选序号串


    @Override
    public NewsPO getModel() {
        return newsPO;
    }

    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    //获取当前页
    private int currentPage = 1;

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String addNews() {
        if (file != null) {
            try {
                File tempFile = new File(Constant.systemPath, fileFileName);
                FileUtils.copyFile(file, tempFile);
                newsPO.setNewsImg(fileFileName);
            } catch (IOException e) {
                return INPUT;
            }
        }
        newsService.addNews(newsPO);
        return "addNewsSuccess";
    }


    public String findNewsByCondition() {
        if (newsPO.getNewsTypePO() == null) {
            NewsTypePO newsTypePO = new NewsTypePO();
            newsTypePO.setTypeId(0);
            newsPO.setNewsTypePO(newsTypePO);
        }
        if (newsPO.getNewsKey() == null) {
            newsPO.setNewsKey("");
        }
        ActionContext.getContext().getSession().put("find_type", newsPO.getNewsTypePO().getTypeId());
        ActionContext.getContext().getSession().put("find_key", newsPO.getNewsKey().trim());
        PageBean<NewsPO> pageBean = newsService.findNewsByCondition(
                currentPage,
                newsPO.getNewsTypePO().getTypeId(),
                newsPO.getNewsKey()
        );
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findNewsByConditionSuccess";
    }

    public String deleteNews() {

        newsService.deleteNews(newsPO);
        return "deleteNewsSuccess";
    }


    public String deleteMoreNews() {
        String[] checkNewsIDs = this.getCheckNews().split(",");
        newsService.deleteMoreNews(checkNewsIDs);
        return "deleteMoreNewsSuccess";
    }


    public String getCheckNews() {
        return checkNews;
    }

    public void setCheckNews(String checkNews) {
        this.checkNews = checkNews;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }
}
