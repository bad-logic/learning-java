package fundamentals.labs.lab07.lab07_02;

public class MinSort {

    MinSort(){

    }

    private int getMinPos(String s){
        int minPos = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) < s.charAt(minPos)){
                minPos = i;
            }
        }
        return minPos;
    }

    private String swapMinPosWithFirstIndex(String s, int minPos ){
        String[] arr = s.split("");
        String temp = arr[minPos];
        arr[minPos] = arr[0];
        arr[0] = temp;

        StringBuilder result = new StringBuilder();

        for (String ch : arr) {
            result.append(ch);
        }

        return result.toString();
    }

    public String sort(String s){
        if(s.isEmpty()) return "";
        int minPos = getMinPos(s);
        String result = swapMinPosWithFirstIndex(s,minPos);
        return result.charAt(0) + sort(result.substring(1));
    }


    public static void main(String[] args){
        MinSort ms = new MinSort();
        String result = ms.sort("zwxuabfkafutbbbb");
        System.out.println(result);
    }



}
