package ldu.guofeng.news.admin.test;

import ldu.guofeng.news.admin.domain.NewsPO;
import ldu.guofeng.news.admin.domain.NewsTypePO;
import ldu.guofeng.news.admin.service.NewsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by GUOFENG on 2017/4/18.
 */
public class AddNewsTest {
    private NewsService newsService;

    @Before
    public void loginBefore() {
        //加载
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        newsService = (NewsService) beanFactory.getBean("newsService");
    }

    @Test
    public void loginTest() {
        //封装实体类
        NewsTypePO newsTypePO=new NewsTypePO();
        newsTypePO.setTypeId(1);

        NewsPO newsPO = new NewsPO();
        newsPO.setNewsId(1);
        newsPO.setNewsTitle("新闻1");
        newsPO.setNewsContent("新闻1内容");
        newsPO.setNewsTypePO(newsTypePO);

        newsService.addNews(newsPO);
    }
}
