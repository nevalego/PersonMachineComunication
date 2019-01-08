package logic;

public class Item {

	
	private String code;
	private ItemCategory category;
	private String name;
	private String description;
	private double unitPrice;
	private double groupPrice;
	
	public Item(String code, ItemCategory category, String name, String description, double unitPrice,
			double groupPrice) {
		
		setCode(code);
		setCategory(category);
		setName(name);
		setDescription( description);
		setUnitPrice(unitPrice);
		setGroupPrice( groupPrice);
	}

	public String getCode() {
		return code;
	}

	public boolean isGroup() {
		return unitPrice==0 && groupPrice!= 0;
	}
	
	public double getPrice() {
		if(isGroup())
			return groupPrice;
		return unitPrice;
	}
	
	public void setCode(String code) {
		if(code.length() == 5)
			this.code = code;
	}

	public ItemCategory getCategory() {
		return category;
	}

	public void setCategory(ItemCategory category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getGroupPrice() {
		return groupPrice;
	}

	public void setGroupPrice(double groupPrice) {
		this.groupPrice = groupPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  name;
	}
	
	
	
	
}
