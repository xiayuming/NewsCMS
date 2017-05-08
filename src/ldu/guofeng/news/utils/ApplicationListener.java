package ldu.guofeng.news.utils;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.IOException;

/**
 * SessionListener统计浏览量
 */
public class ApplicationListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {;
        MyFileUtils.createFile(Constant.countFilePath);
        try {
            MyFileUtils.writeTxtFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }


}
