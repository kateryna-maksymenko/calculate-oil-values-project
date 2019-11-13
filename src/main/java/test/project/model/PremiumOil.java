package test.project.model;


public class PremiumOil extends Oil {
	
	private double variableRevenue;

	public double getVariableRevenue() {
		return variableRevenue;
	}

	public void setVariableRevenue(double variableRevenue) {
		this.variableRevenue = variableRevenue;
	}

	@Override
	public double getRevenue(double price) {
		return (getCost()*getVariableRevenue()/100)/price;
	}
	

}
