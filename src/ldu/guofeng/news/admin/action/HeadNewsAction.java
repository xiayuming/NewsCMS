package ldu.guofeng.news.admin.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import ldu.guofeng.news.admin.domain.HeadNewsPO;
import ldu.guofeng.news.admin.domain.PageBean;
import ldu.guofeng.news.admin.service.HeadNewsService;
import ldu.guofeng.news.utils.Constant;
import ldu.guofeng.news.utils.MyFileUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by GUOFENG on 2017/4/19.
 */
public class HeadNewsAction extends ActionSupport implements ModelDriven<HeadNewsPO> {
    private HeadNewsPO headNewsPO = new HeadNewsPO();
    private HeadNewsService headNewsService;
    private File file;//上传文件
    private String fileFileName;//上传文件名

    public void setHeadNewsService(HeadNewsService headNewsService) {
        this.headNewsService = headNewsService;
    }

    @Override
    public HeadNewsPO getModel() {
        return headNewsPO;
    }

    public String addOrUpdateHeadNews() {
        if (file != null) {
            try {
                File tempFile = new File(Constant.systemPath, fileFileName);
                FileUtils.copyFile(file, tempFile);
                headNewsPO.setHeadImg(fileFileName);
            } catch (IOException e) {
                e.printStackTrace();
                return INPUT;
            }
        }
        HeadNewsPO getHeadNewsPO = headNewsService.existHeadNews(headNewsPO);
        if (getHeadNewsPO != null) {
            //删除图片
            MyFileUtils.deleteFile(Constant.systemPath + "\\" + getHeadNewsPO.getHeadImg());
            //更新数据
            headNewsService.updateHeadNews(headNewsPO);
        } else {
            //添加数据
            headNewsService.addHeadNews(headNewsPO);
        }
        return "addOrUpdateHeadNewsSuccess";
    }

    public String deleteHeadNews() {
        headNewsService.deleteHeadNews(headNewsPO);
        return "deleteHeadNewsSuccess";
    }

    public String findHeadNews() {
        PageBean<HeadNewsPO> pageBean = headNewsService.findHeadNews();
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findHeadNewsHeadNews";
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
