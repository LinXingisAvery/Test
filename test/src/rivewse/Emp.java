package rivewse;

import java.io.Serializable;

/**
 * @author: Avery
 * @description: emp类序列化Serializable
 * @date: 2017年6月6日
 */
public class Emp implements Serializable{
	
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	public Emp() {
		super();
	}
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}
	
}
