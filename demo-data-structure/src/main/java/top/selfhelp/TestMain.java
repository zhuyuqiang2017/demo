package top.selfhelp;


public class TestMain {

    public static void main(String[] args) {
        int size = 15;
        for(int i = 0;i<100;i++){
            System.out.println((size & i)+"---"+i%(size+1));
        }
    }
}
