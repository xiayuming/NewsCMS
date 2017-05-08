package ldu.guofeng.news.admin.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 分页Bean
 */
public class PageBean<T> implements Serializable {

    private int currentPage;//当前页数
    private int pageCount;//每页显示的记录数
    private List<T> list;//每页显示的数据
    private int pageSize;//总页数
    private int totalSize;//总记录数


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
