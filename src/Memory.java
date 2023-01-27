import java.util.*;
public class Memory {

    Scanner input = new Scanner(System.in);
    LinkedList<Process> processes;
    LinkedList<Partition> partitions;
    
    static int s;

    public Memory(LinkedList<Process> processes, LinkedList<Partition> partitions) {
        this.processes = processes;
        this.partitions = partitions;
        s = partitions.size();
    }

    public void FirstFit() {

        for (int i = 0; i < processes.size(); i++) {
            for (int j = 0; j < partitions.size(); j++) {
                if (partitions.get(j).PartitionSize >= processes.get(i).ProcessSize
                && processes.get(i).Allocated==false){
                    processes.get(i).Allocated = true;
                    partitions.get(j).setProcess(processes.get(i));
                    partitions.get(j).PartitionSize -= processes.get(i).ProcessSize;
                    partitions.get(j).Status = true;

                    if (partitions.get(j).PartitionSize > 0) {
                        s += 1;
                        Partition partition = new Partition("partition" + (s - 1), partitions.get(j).PartitionSize,
                                false);
                        partitions.add(j + 1, partition);
                        partitions.get(j).PartitionSize = 0;
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < partitions.size(); i++) {
            // if partition contain process
            if (partitions.get(i).Status == true) {
                System.out
                        .println(partitions.get(i).PartitionName + "(" + partitions.get(i).process.ProcessSize + " KB)"
                                + "=> " + partitions.get(i).process.ProcessName);
            } else {
                System.out.println(partitions.get(i).PartitionName + "(" + partitions.get(i).PartitionSize + " KB)"
                        + "=> External Fragmentation");
            }
        }
        for (int i = 0; i < processes.size(); i++) {
            if (!processes.get(i).Allocated) {
                System.out.println(processes.get(i).ProcessName + " Not Allocated");
            }

        }

        System.out.println("\nDo you want to compact? 1.yes 2.no");
        int answer = input.nextInt();
        if (answer == 1) {
            compaction();
            FirstFit();
        }else {
            System.out.println("exit...");
            System.exit(0);
        }
    }

    public void WorstFit() {

        for (int i = 0; i < processes.size(); i++) {
            int wstIdx = -1;
            for (int j = 0; j < partitions.size(); j++) {
                if (partitions.get(j).PartitionSize >= processes.get(i).ProcessSize) {
                    if (wstIdx == -1)
                        wstIdx = j;
                    else if (partitions.get(wstIdx).PartitionSize < partitions.get(j).PartitionSize)
                        wstIdx = j;
                }
            }
            if (wstIdx != -1 && processes.get(i).Allocated ==false) {
                processes.get(i).Allocated = true;
                partitions.get(wstIdx).setProcess(processes.get(i));
                partitions.get(wstIdx).PartitionSize -= processes.get(i).ProcessSize;
                partitions.get(wstIdx).Status = true;

                if (partitions.get(wstIdx).PartitionSize > 0) {
                    s += 1;
                    Partition partition = new Partition("partition" + (s - 1), partitions.get(wstIdx).PartitionSize,
                            false);
                    partitions.add(wstIdx + 1, partition);
                    partitions.get(wstIdx).PartitionSize = 0;
                }
            }
        }
        for (int i = 0; i < partitions.size(); i++) {
            // if partition contain process
            if (partitions.get(i).Status == true) {
                System.out
                        .println(partitions.get(i).PartitionName + "(" + partitions.get(i).process.ProcessSize + " KB)"
                                + "=> " + partitions.get(i).process.ProcessName);
            } else {
                System.out.println(partitions.get(i).PartitionName + "(" + partitions.get(i).PartitionSize + " KB)"
                        + "=> External Fragmentation");
            }
        }
        for (int i = 0; i < processes.size(); i++) {
            if (!processes.get(i).Allocated) {
                System.out.println(processes.get(i).ProcessName + " Not Allocated");
            }
        }

        System.out.println("\nDo you want to compact? 1.yes 2.no");
        int answer = input.nextInt();
        if (answer == 1) {
            compaction();
            WorstFit();
        }else {
            System.out.println("exit...");
            System.exit(0);
        }
    }

    public void BestFit() {
        for (int i = 0; i < processes.size(); i++) {
            int bestIdx = -1;
            for (int j = 0; j < partitions.size(); j++) {
                if (partitions.get(j).PartitionSize >= processes.get(i).ProcessSize) {
                    if (bestIdx == -1)
                        bestIdx = j;
                    else if (partitions.get(bestIdx).PartitionSize > partitions.get(j).PartitionSize)
                        bestIdx = j;
                }
            }

            if (bestIdx != -1 && processes.get(i).Allocated ==false ) {
                processes.get(i).Allocated = true;
                partitions.get(bestIdx).setProcess(processes.get(i));
                partitions.get(bestIdx).PartitionSize -= processes.get(i).ProcessSize;
                partitions.get(bestIdx).Status = true;

                if (partitions.get(bestIdx).PartitionSize > 0) {
                    s += 1;
                    Partition partition = new Partition("partition" + (s - 1), partitions.get(bestIdx).PartitionSize,
                            false);
                    partitions.add(bestIdx + 1, partition);
                    partitions.get(bestIdx).PartitionSize = 0;
                }
            }
        }
        for (int i = 0; i < partitions.size(); i++) {
            // if partition contain process
            if (partitions.get(i).Status == true) {
                System.out
                        .println(partitions.get(i).PartitionName + "(" + partitions.get(i).process.ProcessSize + " KB)"
                                + "=> " + partitions.get(i).process.ProcessName);
            } else {
                System.out.println(partitions.get(i).PartitionName + "(" + partitions.get(i).PartitionSize + " KB)"
                        + "=> External Fragmentation");
            }
        }
        for (int i = 0; i < processes.size(); i++) {
            if (!processes.get(i).Allocated) {
                System.out.println(processes.get(i).ProcessName + " Not Allocated");
            }
        }
        
        System.out.println("\nDo you want to compact? 1.yes 2.no");
        int answer = input.nextInt();
        if (answer == 1) {
            compaction();
            BestFit();
        }else {
            System.out.println("exit...");
            System.exit(0);
        }
    }


    public void compaction() {
        int SumSize = 0;
        int size = partitions.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < partitions.size(); j++) {
                if (partitions.get(j).Status == false) {
                    SumSize += partitions.get(j).PartitionSize;
                    partitions.remove(j);
                    break;
                }
            }
        }
        Partition partition = new Partition("partition" + (s), SumSize, false);
        partitions.add(partition);
    }
}
