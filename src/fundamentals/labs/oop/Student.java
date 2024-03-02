package fundamentals.labs.oop;

public class Student {
	private String[] courses = new String[2];
	private long id;
	private String name;
	private Program program;
	private int size = 0;
	
	public Student(long id,String name) {
		this.id = id;
		this.name = name;
	}
	
	private void resize() {
		int newLength = courses.length + 2;
		String[] tempCourses = new String[newLength];
		System.arraycopy(courses, 0, tempCourses, 0, courses.length);
		courses = tempCourses;
	}
	
	public void setProgram(Program program) {
		this.program = program;
	}
	
	public Program getProgram() {
		return this.program;
	}
	
	public void addCourse(String course) {
		if(course == null) return;
		if(size >= courses.length) {
			resize();
		}
		courses[size++] = course;
//		size++;
	}
	
	public String[] getCourses() {
		return this.courses;
	}
	
	public boolean removeCourse(int index) {
		if(index < 0 || index >= courses.length) return false;
		for(int i=0;i<courses.length;i++) {
			if(i == courses.length - 1) {
				courses[i] = null;
				continue;
			}
			
			if(i>=index ) {
				courses[i] = courses[i+1];
			}
		}
		size--;
		return true;
		
	}
	

	public String toString() {
		String output = "{\n \tid: "+this.id+",\n \tname: "+ this.name +"\n \tcourses: [";
		
		for(int i=0;i<size;i++) {
			output += courses[i];
			if(i<size-1) {
				output+=", ";
			}
		}
		
		output += "]\n}\n";
		
		return output;
	}
	
	public static void main(String[] args) {
		Student st = new Student(2324324,"Roshan");
		System.out.println("Adding FPP and MPP");
		st.addCourse("FPP");
		st.addCourse("MPP");
		System.out.println(st.toString());
		System.out.println("Adding WAP and DBMS");
		st.addCourse("WAP");
		st.addCourse("DBMS");
		System.out.println(st.toString());
		
		System.out.println("Removing 2nd index: "+st.removeCourse(2));
		System.out.println(st.toString());
		System.out.println("Adding SYSTEM DESIGN and SOFTWARE DEVELOPMENT");
		st.addCourse("SYSTEM DESIGN");
		st.addCourse("SOFTWARE DEVELOPMENT");
		System.out.println(st.toString());
		System.out.println("Removing 2nd index: "+ st.removeCourse(2));
		System.out.println(st.toString());
	}
	

}
