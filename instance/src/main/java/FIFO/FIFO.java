package FIFO;

import java.util.ArrayList;

/**
 * @author Jianshu
 * @time 20200722
 */
public class FIFO {

    ArrayList<Page> pages;
    Memory memory=new Memory();
    public int hitNum=0;

    public FIFO(ArrayList<Page> pages){
        this.pages=pages;
    }

    public void fifo(){

        int oldPagePtr=0;//最老页面指针
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
                memory.pages.set(oldPagePtr,thisPage);
                //最老页面循环指向内存中各个页面
                oldPagePtr++;
                if(oldPagePtr>=memory.memorySize){
                    oldPagePtr=0;
                }
            }
            memory.printMemory();
        }
    }

    public boolean isInMemory(Page page){
        return memory.pages.contains(page);
    }
}
