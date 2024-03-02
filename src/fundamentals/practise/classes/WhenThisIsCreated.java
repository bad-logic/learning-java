package fundamentals.practise.classes;

public class WhenThisIsCreated {
    Object t = this;
    String val0 = (this == null) ? "null" : "Not null\n  Using 'this' to get class name: "
            + this.getClass().getName();
    String val1 = null, val2 = null;
    WhenThisIsCreated(){
        val1 = (this == null)? "null" : "Not null\n  Using 'this' to get class name: "
                + this.getClass().getName();
    }
    void test() {
        val2 = (this == null)? "null" : "Not null\n  Using 'this' to get class name: "
                + this.getClass().getName();
    }

    public static void main(String[] args) {
        WhenThisIsCreated w = new WhenThisIsCreated();
        System.out.println(w.t);
        w.test();
        System.out.println("before constructor: " + w.val0);
//		System.out.println("first line of constructor: " + w.val1);
//		System.out.println("after constructor: " + w.val2);
    }
}