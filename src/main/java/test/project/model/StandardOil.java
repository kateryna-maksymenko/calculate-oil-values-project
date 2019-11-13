package test.project.model;

public class StandardOil extends Oil {

	
	@Override
	public double getRevenue(double price) {
		return getFixedRevenue()/price;
	}

}
