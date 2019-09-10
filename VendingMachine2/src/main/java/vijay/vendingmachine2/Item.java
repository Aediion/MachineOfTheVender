/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x.x;

//presets



public class Item {
	private String itemInfo;
	private double price;
	private int amount;
        
        
       
	
	public String getInfo() {
		return itemInfo;
	}

	public void setInfo(String information) {
		this.itemInfo = information;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return amount;
	}

	public void setQuantity(int amount) {
		this.amount = amount;
	}
        
        
	public int hashCode() {                            
		final int p = 31;
		int result = 1;
		result = p * result + ((itemInfo == null) ? 0 : itemInfo.hashCode());
		result = (int) (p * result + price);
		result = p * result + amount;
		return result;
	}
        

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemInfo == null) {
			if (other.itemInfo != null)
				return false;
		} else if (!itemInfo.equals(other.itemInfo))
			return false;
		if (price != other.price)
			return false;
		if (amount != other.amount)
			return true;
		return true;
	}
        
 	public Item() {

	}

	public Item(String itemInfo, double price, int amount) {
		this.itemInfo = itemInfo;
		this.price = price;
		this.amount = amount;
	}
        
	
        

}
