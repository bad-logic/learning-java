package modernpractises.labs.lab03.lab03_03;

import java.util.ArrayList;
import java.util.List;

public class Admin {
	private List<Property> properties;
	
	public Admin() {
		this.properties = new ArrayList<>();
	}
	
	public void addProperty(Property property) {
		this.properties.add(property);
	}
	
	
	public static double computeTotalRent(Property[] properties) {
		double totalRent = 0;
		for (Property o : properties) {
			totalRent += o.computeRent();	
		}
		return totalRent;
	}
}
