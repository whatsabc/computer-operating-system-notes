package BankerAlgorithm;

/**
 * @author Jianshu
 * @time 20200724
 */
public class Process {

    final int resourcesNum=3;

    String processName;
    int[] MAX;
    int[] ALLOCATION;
    int[] NEED=new int[resourcesNum];
    boolean isFinished=false;

    public Process(String processName, int[] MAX, int[] ALLOCATION) {
        this.processName = processName;
        this.MAX = MAX;
        this.ALLOCATION = ALLOCATION;
    }

}
