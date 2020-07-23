package LRU;

/**
 * @author Jianshu
 * @time 20200723
 */
public class Page {

    Integer pageNum;
    Integer pageCount;

    public Page(int pageNum){
        this.pageNum=pageNum;
        pageCount=0;//初始化页面命中非命中次数
    }


    public void pageHit(){
        pageCount=0;
    }

    public void pageMiss(){
        pageCount++;
    }

    @Override
    /**
     * 重写的equal方法，ArrayList的indexof()和contains()方法都需要用到重载的方法
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
