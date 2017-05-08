package ldu.guofeng.news.admin.test;

import ldu.guofeng.news.admin.domain.UserPO;
import ldu.guofeng.news.admin.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 登录测试
 */
public class LoginTest {

    private UserService userServiceImpl;

    @Before
    public void loginBefore() {
        //加载
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        userServiceImpl = (UserService) beanFactory.getBean("userService");
    }

    @Test
    public void loginTest() {
        //封装实体类
        UserPO userPO = new UserPO();
        userPO.setUserId(10000);
        userPO.setPassword("10000");
        //业务层调用登录方法
        UserPO user = userServiceImpl.login(userPO);
        if (user == null) {
            System.out.println("登录失败");
        } else {
            System.out.println(user.getUserId() + "登录成功");
        }
    }
}
