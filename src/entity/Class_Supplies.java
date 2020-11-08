package entity;

public class Class_Supplies {
	
	private int supplies_id;
	private String supply_name;
	private int quantity;
	private int classID;
	
	public Class_Supplies(int supplies_id, String supply_name, int quantity, int classID) {
		this.setSupplies_id(supplies_id);
		this.setSupply_name(supply_name);;
		this.setQuantity(quantity);
		this.setClass_ID(classID);
	}

	public int getSupplies_id() {
		return supplies_id;
	}

	public void setSupplies_id(int supplies_id) {
		this.supplies_id = supplies_id;
	}

	public String getSupply_name() {
		return supply_name;
	}

	public void setSupply_name(String supply_name) {
		this.supply_name = supply_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getClass_ID() {
		return classID;
	}
	
	public void setClass_ID(int classID) {
		this.classID = classID;
	}
	

}