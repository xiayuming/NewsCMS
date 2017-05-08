package ldu.guofeng.news.admin.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import ldu.guofeng.news.admin.domain.CountInfoPO;
import ldu.guofeng.news.admin.service.CountInfoService;

/**
 * Created by GUOFENG on 2017/4/20.
 */
public class CountInfoAction extends ActionSupport implements ModelDriven<CountInfoPO> {
    private CountInfoPO countInfoPO;
    private CountInfoService countInfoService;

    @Override
    public CountInfoPO getModel() {
        return countInfoPO;
    }

    public void setCountInfoService(CountInfoService countInfoService) {
        this.countInfoService = countInfoService;
    }

    public String countInfo() {
        countInfoPO = countInfoService.countInfo();
        ActionContext.getContext().getSession().put("countinfo", countInfoPO);
        return "countInfoSuccess";
    }
}
