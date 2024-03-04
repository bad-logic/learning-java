package fundamentals.labs.lab03.lab03_03;

public class MyStringList {
	private String[] strArray;
	private int size;
	
	public MyStringList(int... args) {
		int arraySize = args.length == 0 ? 50 : args[0];
		strArray = new String[arraySize];
		size = 0;
	}
	
	private void resize() {
		System.out.println("Resizing...");
		int newLength = strArray.length * 2;
		String[] temp = new String[newLength];
		System.arraycopy(strArray, 0, temp, 0, strArray.length);
		strArray = temp;
	}
	
	public String get(int i) {
		if(i<0 || i>= size) return null;
		return strArray[i];
	}
	
	public boolean find(String s) {
		if(s == null) return false;
		for(int i=0;i<size;i++) {
			if(strArray[i].equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	public void add(String s) {
		if(size >= strArray.length) {
			resize();
		}
		strArray[size++] = s;
	}
	
	public boolean remove(String s) {
		if(s == null) return false;
		int searchIndex = -1;
		
		for(int i=0;i<size;i++) {
			if(strArray[i].equals(s)) {
				searchIndex = i;
			}
		}
		
		if(searchIndex < 0) return false;
		
		for(int i=searchIndex;i<size;i++) {
			if(i==size-1) {
				strArray[i] = null;
				break;
			}
			strArray[i] = strArray[i+1];
		}
		size--;
		return true;
	}
	
	public String toString() {
		String output = "[";
		
		for(int i=0;i<size;i++) {
			output += strArray[i];
			if(i<size-1) {
				output += ", ";
			}
		}
		output += "]";
		return output;
	}
	
	public int size() {
		return this.size;
	}
	
	public static void main(String[] args) {
		MyStringList l = new MyStringList(2);
		l.add("Bob");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Steve");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Susan");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Mark");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Dave");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.remove("Mark");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.remove("Bob");
		System.out.println("The list of size " + l.size() + " is " + l);
	}

}
