public class Process {

    String ProcessName;
    int ProcessSize;
    boolean Allocated;
    public Process() {
    }

    public Process(String processName, int processSize,boolean allocated) {
        ProcessName = processName;
        ProcessSize = processSize;
        Allocated = allocated;
    }

    public String getProcessName() {
        return ProcessName;
    }
    public void setProcessName(String processName) {
        ProcessName = processName;
    }
    public int getProcessSize() {
        return ProcessSize;
    }
    public void setProcessSize(int processSize) {
        ProcessSize = processSize;
    }
    
}
