package Lecture7.Exercise7_6;

public class ThreadGroupTest {
    public static void main(String[] args) {
        ThreadGroupHierarchy tge = new ThreadGroupHierarchy();
        for(ThreadGroup group: tge.groups){
            tge.getThreadGroupInfo(group);
        }
    }
}
