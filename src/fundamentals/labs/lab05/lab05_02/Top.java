package fundamentals.labs.lab05.lab05_02;

public class Top {
    int t = 1;
    Middle mid;
    Middle.Bottom midbot;

    Top(){
        mid = new Middle();
        midbot = mid.new Bottom();
    }

    int readBottom() {
        return midbot.b;
    }
    class Middle {
        int m = 2;
        int addTopAndBottom() {
            return Top.this.t + midbot.b;
        }
        class Bottom {
            int b = 3;
            int multiplyAllThree() {
                return Top.this.t * Middle.this.m * this.b;
            }
        }
    }

    public static void main(String[] args){
        Top top = new Top();
        System.out.println(top.readBottom());
        System.out.println(top.mid.addTopAndBottom());
        System.out.println(top.midbot.multiplyAllThree());
    }

}
