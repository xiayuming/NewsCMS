package ldu.guofeng.news.admin.test;

import ldu.guofeng.news.admin.domain.NewsPO;
import ldu.guofeng.news.admin.domain.NewsTypePO;
import ldu.guofeng.news.admin.service.NewsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by GUOFENG on 2017/4/27.
 */
public class FTest {
    private NewsService newsService;

    @Before
    public void addBefore() {
        //加载
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        newsService = (NewsService) beanFactory.getBean("newsService");
    }

    @Test
    public void addTest() {
        //封装实体类
        NewsTypePO newsTypePO=new NewsTypePO();
        newsTypePO.setTypeId(1);
        NewsPO newsPO = new NewsPO();
        newsPO.setNewsId(1);
        newsPO.setNewsTitle("新闻test");
        newsPO.setNewsContent("新闻test内容");
        newsPO.setNewsTypePO(newsTypePO);
        newsService.addNews(newsPO);
    }
}
