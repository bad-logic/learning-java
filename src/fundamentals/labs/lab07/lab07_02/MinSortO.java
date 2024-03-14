package fundamentals.labs.lab07.lab07_02;

public class MinSortO {

    public static void main(String[] args) {
        System.out.println(minSortRecursion("zwxuabfkafutbbbb"));
    }
    public static String minSortRecursion(String n) {
        if (n == null || n.length() <= 1) {
            return n;
        }

        char minChar = n.charAt(0);
        int minPos = 0;

        for (int i = 1; i < n.length(); i++) {
            if (n.charAt(i) < minChar) {
                minChar = n.charAt(i);
                minPos = i;
            }
        }

        char[] charArray = n.toCharArray();
        char temp = charArray[0];
        charArray[0] = minChar;
        charArray[minPos] = temp;

        String t = new String(charArray, 1, charArray.length - 1);
        String minSortRecursion = minSortRecursion(t);

        return minChar + minSortRecursion;
    }

}
