package testoracle;

/**
 * @author: Avery
 * @description: 商品类
 * @date: 2017年7月2日
 */
public class Goods {
    String id;
    String name;
    int amount;
    double price;
    /**无参构造方法*/
	public Goods() {
		super();
	}
	/**有参构造方法*/
	public Goods(String id, String name, int amount, double price) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", amount=" + amount + ", price=" + price + "]";
	}
	//geter and setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
    
}
