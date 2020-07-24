package TimeSlice;

/**
 * @author Jianshu
 * @time 20200722
 */
import java.util.Deque;

public class TimeSlice {

    Deque<Process> processes;

    TimeSlice(Deque<Process> processes){
        this.processes=processes;
    }

    public void timeSlice(int TIME_SLICE){
        float timeCount=0f;
        while(!processes.isEmpty()){
            final Process process=processes.getFirst();
            if (process.surplusTime>0) {
                if (process.surplusTime<=TIME_SLICE) {
                    timeCount=timeCount+process.surplusTime;//此时的时间计数器等于原来的时间+当前进程剩余时间
                    process.finishedTime=timeCount;
                    process.surplusTime=0f;//剩余时间置为0
                }
                else {
                    process.surplusTime=process.surplusTime-TIME_SLICE;//时间片重算
                    timeCount=timeCount+TIME_SLICE;
                    process.finishedTime=timeCount;
                }
                process.roundTime=process.finishedTime-process.arriveTime;
                process.weightTime=process.roundTime/process.serverTime;
                processes.add(processes.removeFirst());//队首进入队尾
            }
            else {
                printProcess(processes.removeFirst());//执行完就出队
            }
        }
    }

    public void printProcess(Process process){
        System.out.printf("%10s%15f%15f%15f%15f%15f\n",process.name,process.arriveTime,
                process.serverTime,process.finishedTime,process.roundTime,process.weightTime);
    }

}
