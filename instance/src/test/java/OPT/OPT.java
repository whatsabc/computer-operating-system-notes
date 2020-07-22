package OPT;

import java.util.ArrayList;

/**
 * @author Jianshu
 * @time 20200722
 */
public class OPT {

    ArrayList<Page> pages;
    Memory memory=new Memory();
    public int hitNum=0;

    public OPT(ArrayList<Page> pages){
        this.pages=pages;
    }

    public void opt(){

        while(!pages.isEmpty()){
            while(!memory.isFull()){
                memory.addPage(pages.remove(0));
                memory.printMemory();
            }

            Page thisPage=pages.remove(0);
            if(isInMemory(thisPage)){
                hitNum++;
            }
            else{
                memory.pages.set(returnSubPage(),thisPage);
            }
            memory.printMemory();
        }
    }

    /**
     *
     * @return 返回内存中的需要置换的页面（index）
     */
    public int returnSubPage(){
        int farIndex=pages.indexOf(memory.pages.get(0));
        int farPageNum=0;//内存中需要置换的页面索引
        for(Page page:memory.pages){
            int index=pages.indexOf(page);//返回pages中p值的第一个index值
            if(index==-1){//如果内存中的某个页面无法匹配到pages中的页面，则该页面视为最佳置换页面
                return memory.pages.indexOf(page);
            }
            if(index>farIndex){
                farIndex=index;//更新最大值
                farPageNum=memory.pages.indexOf(page);//返回该页在内存中的索引
            }
        }
        return farPageNum;
    }

    public boolean isInMemory(Page page){
        return memory.pages.contains(page);
    }
}
