package FCFS;

/**
 * @author Jianshu
 * @time 20200722
 */
import java.util.Deque;

public class FCFS {

    Deque<Process> processes;

    FCFS(Deque<Process> processes){
        this.processes=processes;
    }

    public void fcfs(){

        Process first=processes.getFirst();

        first.startTime=first.arriveTime;
        first.finishedTime=first.arriveTime+first.serverTime;
        first.roundTime=first.finishedTime-first.arriveTime;
        first.weightTime=first.roundTime/first.serverTime;

        while(!processes.isEmpty()){

            Process pre=processes.removeFirst();
            printProcess(pre);

            Process process=processes.getFirst();
            process.startTime=pre.finishedTime;
            process.finishedTime=process.startTime+process.serverTime;
            process.roundTime=process.finishedTime-process.arriveTime;
            process.weightTime=process.roundTime/process.serverTime;
            //如果是最后一个元素，出队，不参与下一次运算
            if(processes.getFirst()==processes.getLast()){
                printProcess(processes.removeFirst());
            }
        }
    }

    public void printProcess(Process process){
        System.out.printf("%-10s%-15s%-15s%-15s%-15s%-20s\n",process.name,process.arriveTime,
                process.serverTime,process.finishedTime,process.roundTime,process.weightTime);
    }
}
