package Lecture7.Exercise7_6;

public class ThreadDescriptor extends Thread{
    private String Id, Group, CurrentPriority;
    @Override
    public String toString() {
        return "[" +
                "ID='" + Id + ',' +
                ", GRP='" + Group + ',' +
                ", PRI='" + CurrentPriority + ',' +
                ']';
    }

    public ThreadDescriptor(String id, String group, String currentPriority) {
        Id = id;
        Group = group;
        CurrentPriority = currentPriority;
    }
}
