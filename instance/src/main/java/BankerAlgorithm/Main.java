package BankerAlgorithm;

/**
 * @author Jianshu
 * @time 20200724
 */
public class Main {
    public static void main(String[] args){

        Process process1=new Process("P0",new int[]{7,5,3},new int[]{0,1,0});
        Process process2=new Process("P1",new int[]{3,2,2},new int[]{2,0,0});
        Process process3=new Process("P2",new int[]{9,0,2},new int[]{3,0,2});
        Process process4=new Process("P3",new int[]{2,2,2},new int[]{2,1,1});
        Process process5=new Process("P4",new int[]{4,3,3},new int[]{0,0,2});

        int reqProcessNum=0;
        int[] request=new int[]{0,2,0};
        System.out.println("进程["+reqProcessNum+"]请求的资源是：["+request[0]+request[1]+request[2]+"]");
        Algorithm algorithm=new Algorithm(new Process[]{process1,process2,process3,process4,process5},reqProcessNum,request);
        algorithm.bankAlg();
    }
}
