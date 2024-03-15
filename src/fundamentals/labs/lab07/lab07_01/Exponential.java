package fundamentals.labs.lab07.lab07_01;

public class Exponential {

    private double pow(double x, int n){
        if(n == 1) return x;
        return x * pow(x,n-1);
    }
    private double signedPower(double x, int n){
        int nSign = n < 0 ? -1 : 1;
        double power = pow( x, nSign * n);
        return nSign < 0 ? 1 / power : power;
    }
    public double power(double x, int n) throws IllegalArgumentException{
        if( n < 0 ){
            throw new IllegalArgumentException("power should be greater than zero (0)");
        }
        return  pow( x, n );
    }

    public static void main(String[] args){
            Exponential exp = new Exponential();
            System.out.println(exp.power(2,10));
    }
}
