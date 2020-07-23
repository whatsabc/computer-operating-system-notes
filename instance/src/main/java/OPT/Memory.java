package OPT;

/**
 * @author Jianshu
 * @time 20200722
 */
import java.util.ArrayList;

public class Memory {
    final int memorySize=3;
    ArrayList<Page> pages=new ArrayList<>(memorySize);

    public boolean addPage(Page page){
        if(pages.add(page)){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(pages.size()>=memorySize){
            return true;
        }
        return false;
    }

    public void printMemory(){
        System.out.println("\n--[内存]--");
        for(Page p:pages){
            System.out.println(p.pageNum);
        }
    }

}
