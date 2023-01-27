import java.util.*;
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args)  {
        
        Scanner input = new Scanner(System.in);

        LinkedList<Process> processes = new LinkedList<Process>();
        LinkedList<Partition> partitions = new LinkedList<Partition>();

        // System.out.print("Enter Number of partitions : ");
        // int NumOfPartitions = input.nextInt();
        // String PName ;
        // int PSize;
        // for (int i = 0; i < NumOfPartitions ; i++) {

        //     System.out.println("Enter Partition name and its size ");
        //     PName = input.next();
        //     PSize = input.nextInt();
        //     Partition partition = new Partition(PName, PSize,false);
        //     partitions.add(partition);
        // }
        // System.out.print("Enter Number of processes : ");
        // int NumOfProcesses = input.nextInt();
        // for (int i = 0; i < NumOfProcesses ; i++) {
        //     System.out.println("Enter Process name and its size ");
        //     PName = input.next();
        //     PSize = input.nextInt();
        //     Process process = new Process(PName, PSize,false);
        //     processes.add(process);
        // }

        String[] PName = {"partition0","partition1","partition2","partition3","partition4","partition5"};
        int [] PSize={90,20,5,30,120,80};
        for (int i = 0; i < PName.length ; i++) {
            Partition partition = new Partition(PName[i], PSize[i],false);
            partitions.add(partition);
        }

        String[] Pname = {"process1","process2","process3","process4"};
        int [] Psize={15,90,30,100};
        for (int i = 0; i < Pname.length ; i++) {
            
            Process process = new Process(Pname[i], Psize[i],false);
            processes.add(process);
        }
        Memory memory = new Memory(processes, partitions);
        System.out.println("Select the policy you want to apply: ");
        System.out.println("1. First fit \n2. Worst fit \n3. Best fit\nSelect policy");
        int policy = input.nextInt();
        if (policy==1){
            memory.FirstFit();
        }
        else if (policy==2)
        {
            memory.WorstFit();
        }
        else{
            memory.BestFit();
        }
    }
}
