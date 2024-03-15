package fundamentals.labs.lab08.lab08_05;

public class MyTable {
    final private Entry[] entries = new Entry[26];
    private final int base = 'a';

    //returns the String that is matched with char c in the table
    public String get(char c){
        int index = (int) c - base;
        return entries[index].toString();
    }

    public void add(char c, String s) {
        int index = (int) c - base;
        this.entries[index] = new Entry(s,c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : entries) {
            if (entry != null) {
                sb.append(entry).append("\n");
            }
        }
        return sb.toString();
    }


    private static  class Entry {
        final private String str;
        final private char ch;
        Entry(String str, char ch){
            this.str = str;
            this.ch = ch;
        }
        //returns a String of the form "ch->str"
        public String toString() {
            return this.ch + "->" + this.str;
        }
    }

    public static void main(String[] args){
        MyTable t = new MyTable();
        t.add('a', "Andrew");
        t.add('b',"Billy");
        t.add('w',"Willie");
        System.out.println(t);
    }

}
