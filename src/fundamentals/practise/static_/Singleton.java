package fundamentals.practise.static_;

public class Singleton {
        public static int count = 0;
        private static Singleton instance;
        private Singleton() {
            count++;
        }

        public static Singleton getInstance() {
            if(instance == null) {
                instance = new Singleton();
            }
            return instance;
        }

        public static void main(String[] args) {
            for(int i = 0; i < 10; ++i) {
                Singleton.getInstance();
            }
            System.out.println(count);
        }
}
