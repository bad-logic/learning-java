package algorithms.labs.lab04;

//Devise an O(n) algorithm to accomplish this task.
//Given a none-empty string S of length n, S consists some words separated by
//spaces. We want to reverse every word in S.
// For example, given S = “we test coders”, your algorithm is going to return a string
//with every word in S reversed and separated by spaces. So the result for the above
//example would be “ew tset sredoc”.


public class ReverseString {
    public static String reverse(String st){
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int length = st.length();
        for(int i=0;i<length;i++){
            char ch = st.charAt(length -1 - i);
            if(ch == 32){
                result.insert(0, sb + " ");
                sb.setLength(0);
                continue;
            }
            sb.append(ch);
        }
        result.insert(0, sb + " ");

        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(reverse("we test coders"));
    }
}
