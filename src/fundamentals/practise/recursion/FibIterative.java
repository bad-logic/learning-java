package fundamentals.practise.recursion;

public class FibIterative {


        public int fib(int n) {
            int a = 0;
            int b = 1;

            if(n == 1 || n == 0){
                return n;
            }

            int result = 0;
            for(int i = 2; i <= n; ++i) {
                result = a + b;
                a = b;
                b = result;
            }
            return result;
        }

        //  0 1 1 2 3 5 8 13 21 34 55
        public static void main(String[] args) {
            FibIterative fi = new FibIterative();
            System.out.println("fib(10) = " + fi.fib(5));
        }

}
