package ldu.guofeng.news.user.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import ldu.guofeng.news.admin.domain.UserPO;
import ldu.guofeng.news.user.service.LoginRegService;
import net.sf.json.JSONArray;

/**
 * Created by GUOFENG on 2017/5/7.
 */
public class LoginRegAction extends ActionSupport implements ModelDriven<UserPO> {

    private UserPO userPO = new UserPO();
    private LoginRegService loginRegService;
    private JSONArray root;

    public void setLoginRegService(LoginRegService loginRegService) {
        this.loginRegService = loginRegService;
    }

    /**
     * 注册
     */
    public String register() {
        if (loginRegService.register(userPO)) {
            root = JSONArray.fromObject(1);
        }else{
            root = JSONArray.fromObject(0);
        }
        return SUCCESS;
    }

    /**
     * 登录
     */
    public String login() {
        System.out.println(userPO.getUserId());
        System.out.println(userPO.getPassword());
        UserPO loginUserPO = loginRegService.login(userPO);
        if (loginUserPO == null) {
            root = JSONArray.fromObject(0);
            return SUCCESS;
        } else {
            root = JSONArray.fromObject(loginUserPO);
            return SUCCESS;
        }
    }

    @Override
    public UserPO getModel() {
        return userPO;
    }


    public JSONArray getRoot() {
        return root;
    }

    public void setRoot(JSONArray root) {
        this.root = root;
    }
}
