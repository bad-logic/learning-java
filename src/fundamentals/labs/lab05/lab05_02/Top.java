package fundamentals.labs.lab05.lab05_02;

public class Top {
    int t = 1;
    Middle mid;
    Middle.Bottom midbot;

    Top(){
        this.mid = new Middle();
        this.midbot = this.mid.new Bottom();
    }

    int readBottom() {
        return this.midbot.b;
    }
    class Middle {
        int m = 2;
        int addTopAndBottom() {
            return Top.this.t + Top.this.midbot.b;
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
