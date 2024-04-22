package modernpractises.labs.lab10.lab10_01;

import java.util.ArrayList;
import java.util.List;

public class Group<T> {
    private T specialElement;
	private List<T> elements = new ArrayList<>();
	public Group(T special, List<T> elements) {
		this.specialElement = special;
		this.elements = elements;
	}
	public T getSpecialElement() {
		return specialElement;
	}
	public List<T> getElements() {
		return elements;
	}
	@Override
	public String toString() {
		return "[special : " + specialElement.toString() 
		    + ", elements :\n   " + elements.toString() + "]";
	}
}
