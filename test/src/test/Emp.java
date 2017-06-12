package test;

public class Emp {
	String name;
	int age;
	String sex;
	double salary;
	public Emp(){}
	public Emp(String name,int age,String sex,double salary){
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.salary=salary;
	}
	@Override
	public String toString() {
		return "[姓名 "+ name +"年龄" + age + "性别" + sex + " 工资 " + salary + "]";
	}
	
}
