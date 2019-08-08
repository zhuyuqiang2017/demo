package top.selfhelp.common.param;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public class CommonPageParam {

    protected int pageNumber = 1;
    protected int pageSize = 10;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
