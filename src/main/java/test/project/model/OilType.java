package test.project.model;

public enum OilType {
	
	STANDARD("Standard"), 
	PREMIUM("Premium");

	String name;

	private OilType(String name) {
		this.name = name;
	}

}