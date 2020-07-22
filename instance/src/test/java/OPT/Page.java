package OPT;

/**
 * @author Jianshu
 * @time 20200722
 */
public class Page {
    Integer pageNum;

    public Page(int pageNum){
        this.pageNum=pageNum;
    }

    @Override
    /**
     * 重写的equal方法
     */
    public boolean equals(Object obj) {
        if (obj instanceof Page) {
            if (this.pageNum.equals(((Page) obj).pageNum)) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
