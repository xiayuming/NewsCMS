package ldu.guofeng.news.admin.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import ldu.guofeng.news.admin.domain.UserPO;
import ldu.guofeng.news.admin.service.UserService;

/**
 * Created by GUOFENG on 2017/4/14.
 */
public class UserAction extends ActionSupport implements ModelDriven<UserPO> {

    private UserPO userPO = new UserPO();
    private String oldPassword;
    private UserService userService;

    @Override
    public UserPO getModel() {
        return userPO;
    }

    //注入Service
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    /**
     * 管理员登录
     *
     * @return
     */
    public String login() {
        UserPO user = userService.login(userPO);
        if (user == null) {
            return LOGIN;
        }
        ActionContext.getContext().getSession().put("admininfo", user);
        return "loginSuccess";
    }


    /**
     * 修改管理员密码
     *
     * @return
     */
    public String updatePassword() {
        if (userPO.getUserId() == 0) {
            return "updatePwdSuccess";
        }
        userService.updatePassword(userPO, oldPassword);
        return "updatePwdSuccess";
    }


    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
