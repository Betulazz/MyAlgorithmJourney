package recursion;

public class TowerOfHanoi {
    public static void hanoi(int n){
        f(n,"左","中","右");
    }

    public static void f(int i,String from,String to,String other){
        if(i==1){
            System.out.println("移动圆盘1从"+from+"到"+to);
        }else{
            f(i-1,from,other,to);
            System.out.println("移动圆盘"+i+"从"+from+"到"+to);
            f(i-1,other,to,from);
        }
    }

    public static void main(String[] args) {
        hanoi(5);
    }
}
