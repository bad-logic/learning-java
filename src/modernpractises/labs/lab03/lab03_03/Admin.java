package modernpractises.labs.lab03.lab03_03;

import java.util.ArrayList;
import java.util.List;

public class Admin {
	private List<Property> properties;
	
	public Admin(Property p) {
		this.properties = new ArrayList<>();
		// landlord has at least one property
		this.properties.add(p);
	}
	
	public void addProperty(Property property) {
		this.properties.add(property);
	}

	public double computeTotalRent() {
		double totalRent = 0;
		for (Property o : this.properties) {
			totalRent += o.computeRent();	
		}
		return totalRent;
	}
}
