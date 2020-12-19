package Tutorial7.Exercise7_5;

public class ThreadGroupTest {
    public static void main(String[] args) {
        ThreadGroupHierarchy tge = new ThreadGroupHierarchy();
        for(ThreadGroup group: tge.groups){
            tge.getThreadGroupInfo(group);
        }
    }
}
