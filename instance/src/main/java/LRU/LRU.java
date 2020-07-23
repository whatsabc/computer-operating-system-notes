package LRU;

import java.util.ArrayList;

/**
 * @author Jianshu
 * @time 20200723
 */
public class LRU {

    ArrayList<Page> pages;
    Memory memory=new Memory();
    public int hitNum=0;

    public LRU(ArrayList<Page> pages){
        this.pages=pages;
    }

    public void lru(){

        while(!pages.isEmpty()){
            while(!memory.isFull()){
                memory.addPage(pages.remove(0));
                addAllPagesCount();//所有页面计数器自加
                memory.printMemory();
            }

            Page thisPage=pages.remove(0);

            //如果在该页内存命中了
            if(isInMemory(thisPage)){
                hitPageSet(thisPage);
                addAllPagesCount();//所有页面计数器自加
                hitNum++;
            }
            else{
                //没有命中则替换内存中计数器最大的页面
                memory.pages.set(maxPageCountIndex(),thisPage);
                addAllPagesCount();//所有页面计数器自加
            }
            memory.printMemory();
        }
    }

    public boolean isInMemory(Page page){
        return memory.pages.contains(page);
    }

    public void addAllPagesCount(){
        for(Page p:memory.pages){
            p.pageMiss();
        }
    }

    public int maxPageCountIndex(){

        int maxPageCount=memory.pages.get(0).pageCount;
        int oldPageIndex=0;//最久未使用页面在内存中的索引
        for(Page p:memory.pages){
            if(p.pageCount>maxPageCount){
                maxPageCount=p.pageCount;
                oldPageIndex=memory.pages.indexOf(p);
            }
        }
        return oldPageIndex;
    }

    public void hitPageSet(Page page){
        int hitPageIndex=memory.pages.indexOf(page);
        memory.pages.get(hitPageIndex).pageHit();
    }
}
