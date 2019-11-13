package test.project.model;


public abstract class Oil {

	private String id;
	private OilType type;
	private Integer fixedRevenue;
	private int count;
	private double cost;
	
	public abstract double getRevenue(double price);
	
	public Integer getFixedRevenue() {
		return fixedRevenue;
	}

	public void setFixedRevenue(Integer fixedRevenue) {
		this.fixedRevenue = fixedRevenue;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OilType getType() {
		return type;
	}

	public void setType(OilType type) {
		this.type = type;
	}
	
	public double getPriceEarningsRatio(double price) {
		return price/getRevenue(price);
		
	}
}
