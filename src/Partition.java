public class Partition {

    String PartitionName;
    int PartitionSize;
    Process process;
    boolean Status;

    public Partition() {
    }

    public Partition(String partitionName, int partitionSize,boolean status) {
        PartitionName = partitionName;
        PartitionSize = partitionSize;
        Status = status;
    }

    public String getPartitionName() {
        return PartitionName;
    }

    public void setPartitionName(String partitionName) {
        PartitionName = partitionName;
    }

    public int getPartitionSize() {
        return PartitionSize;
    }

    public void setPartitionSize(int partitionSize) {
        PartitionSize = partitionSize;
    }
    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }
    
}
