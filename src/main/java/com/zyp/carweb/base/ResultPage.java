package com.zyp.carweb.base;


import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

public class ResultPage {

    private List list;
    private CustomPage page;

    public ResultPage() {
    }

    public ResultPage(Page page) {
        this.page = new CustomPage()
                .setPageNumber(page.getCurrent())
                .setTotal(page.getTotal())
                .setPageSize(page.getSize())
                .setPageCount(page.getPages());
        this.list = page.getRecords();
    }
    public ResultPage(Boolean isFocus){


    }

    public List getList() {
        return list;
    }

    public ResultPage setList(List list) {
        this.list = list;
        return this;
    }

    public CustomPage getPage() {
        return page;
    }

    public ResultPage setPage(CustomPage page) {
        this.page = page;
        return this;
    }

    class CustomPage {
        private long pageCount;
        private long total;
        private int pageNumber;
        private long pageSize ;

        public long getPageCount() {
            return pageCount;
        }

        public CustomPage setPageCount(long pageCount) {
            this.pageCount = pageCount;
            return this;
        }

        public long getTotal() {
            return total;
        }

        public CustomPage setTotal(long total) {
            this.total = total;
            return this;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public CustomPage setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public long getPageSize() {
            return pageSize;
        }

        public CustomPage setPageSize(long size) {
            this.pageSize = size;
            return this;
        }
    }

}
