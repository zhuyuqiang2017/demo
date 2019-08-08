package top.selfhelp.common.result;

import pagehelper.PageInfo;

import java.util.Collection;

/**
 * @author zhuyuqiang2015@outlook.com
 * @param <T>
 */
public class CommonPageResult<T> {

    private long pageSize;
    private long currentPage;
    private long totalPages;
    private long totalRows;
    private long startRow;
    private long endRow;
    private Collection<T> datas;

    public CommonPageResult(Collection<T> list, PageInfo page){
        if (page != null && page.getTotal() >= 0L  && page.getPageSize() > 0 && page.getPageNum() >= 0) {
            this.datas = list;
            this.totalRows = page.getTotal();
            this.pageSize = (long)page.getPageSize();
            this.currentPage = (long)page.getPageNum();
            this.totalPages = page.getPages();
            this.endRow = page.getEndRow();
            this.startRow = page.getStartRow();
        } else {
            throw new IllegalArgumentException("totalCount must more than 0");
        }
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public long getStartRow() {
        return startRow;
    }

    public void setStartRow(long startRow) {
        this.startRow = startRow;
    }

    public long getEndRow() {
        return endRow;
    }

    public void setEndRow(long endRow) {
        this.endRow = endRow;
    }

    public Collection<T> getDatas() {
        return datas;
    }

    public void setDatas(Collection<T> datas) {
        this.datas = datas;
    }
}
