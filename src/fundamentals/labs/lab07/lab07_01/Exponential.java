package fundamentals.labs.lab07.lab07_01;

public class Exponential {

    private double pow(double x, int n){
        if(n == 1) return x;
        return x * pow(x,n-1);
    }
    private double signedPower(double x, int n){
        int xSign = x < 0 ? -1 : 1;
        int nSign = n < 0 ? -1 : 1;
        double power = pow(xSign * x, nSign * n);
        double result = nSign < 0 ? 1 / power : power;
        return xSign * result;
    }
    public double power(double x, int n) throws IllegalArgumentException{
        if( n < 0 ){
            throw new IllegalArgumentException("power should be greater than zero (0)");
        }
        int xSign = x < 0 ? -1 : 1;
        return xSign * pow(xSign * x, n);
    }

    public static void main(String[] args){
            Exponential exp = new Exponential();
            System.out.println(exp.power(2,10));
    }
}
