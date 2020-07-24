package BankerAlgorithm;

/**
 * @author Jianshu
 * @time 20200724
 */
public class Algorithm {

    final int processesNum=5;
    final int resourcesNum=3;

    int[] request;//请求向量
    int reqProcessNum;//请求进程号[0-4]

    Process[] processes;//输入的进程
    int[] secureProcessList=new int[processesNum];//安全序列列表
    int[] AVAILABLE=new int[resourcesNum];//可用资源数量矩阵
    int[] WORK=new int[resourcesNum];//工作矩阵

    public Algorithm(Process[] processes, int reqProcessNum, int[] request) {
        this.processes = processes;
        this.reqProcessNum = reqProcessNum;
        this.request = request;
        init();//初始化矩阵
    }

    /**
     * A B C三种资源的数目为10，5，7
     * 初始化每个进程的NEED矩阵
     * 初始化AVAILABLE矩阵和WORK矩阵
     */
    public void init(){

        AVAILABLE[0]=3;AVAILABLE[1]=3;AVAILABLE[2]=2;//初始化可用资源矩阵

        //计算每个进程还需要多少资源
        for(int i=0;i<processesNum;i++)
            for(int j=0;j<resourcesNum;j++)
                processes[i].NEED[j]=processes[i].MAX[j]-processes[i].ALLOCATION[j];

        //初始化工作矩阵
        System.arraycopy(AVAILABLE, 0, WORK, 0, resourcesNum);
    }

    /**
     * 安全序列算法
     * @return 返回是否存在安全序列 true false
     */
    public boolean secureAlg(){
        //WORK 3 3 2
        int count=0;
        for (int j=0;j<processesNum;j++) {
            for (int i=0;i<processesNum;i++) {
                if ((!processes[i].isFinished) &&
                        (processes[i].NEED[0]<=WORK[0])&&
                        (processes[i].NEED[1]<=WORK[1])&&
                        (processes[i].NEED[2]<=WORK[2])) {
                    for(int x=0;x<resourcesNum;x++){
                        WORK[x]=WORK[x]+processes[i].ALLOCATION[x];
                    }
                    processes[i].isFinished=true;
                    secureProcessList[count]=i;
                    count++;
                }
            }
        }
        return count == 5;
    }

    /**
     * 银行家算法
     */
    public void bankAlg(){

        if (request[0]<=processes[reqProcessNum].NEED[0]&&
                request[1]<=processes[reqProcessNum].NEED[1]&&
                request[2]<=processes[reqProcessNum].NEED[2]) {
            if (request[0]<=AVAILABLE[0]&&request[1]<=AVAILABLE[1]&&request[2]<=AVAILABLE[2]){
                for(int i=0;i<resourcesNum;i++){
                    processes[reqProcessNum].NEED[i]=processes[reqProcessNum].NEED[i]-request[i];//7 2 3
                    processes[reqProcessNum].ALLOCATION[i]=processes[reqProcessNum].ALLOCATION[i]+request[i];//0 3 0
                    AVAILABLE[i]=AVAILABLE[i]-request[i];//3 1 2
                }
                if (secureAlg()) {
                    printSecureList();
                    System.out.println("成功分配资源");
                }
                else {
                    //分配失败资源返回初始值
                    for(int i=0;i<resourcesNum;i++){
                        processes[reqProcessNum].NEED[i]=processes[reqProcessNum].NEED[i]+request[i];
                        processes[reqProcessNum].ALLOCATION[i]=processes[reqProcessNum].ALLOCATION[i]-request[i];
                        AVAILABLE[i]=AVAILABLE[i]+request[i];
                    }
                    System.out.println("当前系统不安全，资源分配失败");
                }
            }
            else {
                System.out.println("资源不足，资源分配失败");
            }
        }
        else {
            System.out.println("所需要的资源超过了所宣布的最大值，资源分配失败");
        }
    }

    public void printSecureList(){
        System.out.println("存在一个安全序列：");
        for (int i=0;i<processesNum;i++) {
            System.out.print("-->"+processes[secureProcessList[i]].processName);
        }
        System.out.println("\n");
    }

    public void printProcess(){

    }
}
