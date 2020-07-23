package FIFO;

/**
 * @author Jianshu
 * @time 20200722
 */
import java.util.ArrayList;

public class FIFOMain {
    public static void main(String[] args){
        ArrayList<Page> pageArrayList=new ArrayList<>();

        int[] pageNums=new int[]{7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
        for(int i=0;i<pageNums.length;i++){
            pageArrayList.add(new Page(pageNums[i]));
        }
        FIFO fifo=new FIFO(pageArrayList);
        fifo.fifo();
        System.out.println("\n命中次数：["+fifo.hitNum+"]");

        double pageMiss=((double)pageNums.length-(double)fifo.hitNum)/((double)pageNums.length);
        System.out.println("缺页率：["+pageMiss*100+"%]");
    }
}
