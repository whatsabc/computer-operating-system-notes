package TimeSlice;

/**
 * @author Jianshu
 * @time 20200722
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class TimeSliceMain {
    public static void main(String[] args){

        final int PROCESS_NUM=10;

        Deque<Process> processDeque=new ArrayDeque<Process>();
        processDeque.add(new Process("A",0f,4f));
        processDeque.add(new Process("B",1f,3f));
        processDeque.add(new Process("C",2f,4f));
        processDeque.add(new Process("D",3f,2f));
        processDeque.add(new Process("E",4f,4f));

        int TIME_SLICE=1;
        TimeSlice timeslice=new TimeSlice(processDeque);
        System.out.printf("%-10s%-15s%-15s%-15s%-15s%-20s\n","进程名","到达时间", "服务时间","完成时间",
                "周转时间","带权周转时间");
        timeslice.timeSlice(TIME_SLICE);
    }
}
