package ldu.guofeng.news.user.action;

import com.opensymphony.xwork2.ActionSupport;
import ldu.guofeng.news.admin.domain.SiteInfoPO;
import ldu.guofeng.news.user.service.FooterService;
import net.sf.json.JSONArray;

/**
 * Created by GUOFENG on 2017/5/7.
 */
public class FooterAction extends ActionSupport {

    private FooterService footerService;
    private JSONArray root;

    public void setFooterService(FooterService footerService) {
        this.footerService = footerService;
    }

    public JSONArray getRoot() {
        return root;
    }

    public void setRoot(JSONArray root) {
        this.root = root;
    }

    /**
     * 查询网址基本信息
     *
     * @return
     */
    public String findFooter() {
        SiteInfoPO siteInfoPO = footerService.findFooter(1);
        root = JSONArray.fromObject(siteInfoPO);
        return SUCCESS;
    }

}
