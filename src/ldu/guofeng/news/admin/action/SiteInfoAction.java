package ldu.guofeng.news.admin.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import ldu.guofeng.news.admin.domain.SiteInfoPO;
import ldu.guofeng.news.admin.service.SiteInfoService;

/**
 * Created by GUOFENG on 2017/4/17.
 */
public class SiteInfoAction extends ActionSupport implements ModelDriven<SiteInfoPO> {

    private SiteInfoPO siteInfoPO = new SiteInfoPO();
    private SiteInfoService siteInfoService;

    @Override
    public SiteInfoPO getModel() {
        return siteInfoPO;
    }

    public void setSiteInfoService(SiteInfoService siteInfoService) {
        this.siteInfoService = siteInfoService;
    }

    /**
     * 查询网址基本信息
     *
     * @return
     */
    public String findInfo() {
        siteInfoPO = siteInfoService.findInfo(1);
        ActionContext.getContext().getSession().put("siteinfo", siteInfoPO);
        return "findInfoSuccess";
    }

    /**
     * 修改网址基本信息
     *
     * @return
     */
    public String saveInfo() {
        siteInfoService.saveInfo(siteInfoPO);
        return "saveInfoSuccess";
    }

}
