package array.binarysearch;

/**
 * @author: anran.ma
 * @created: 2024/4/20
 * @description:
 **/
public class Bs69 {
    public static void main(String[] args) {
        int res = new Bs69().mySqrt(8);
        System.out.println("res = " + res);
    }

    int s;

    public int mySqrt(int x) {
        s = x;
        return s == 0 ? s : (int) sqrt(x);
    }

    public double sqrt(double x) {
        double res = (x + s / x) / 2;
        return res == x ? x : sqrt(res);
    }


    

}
