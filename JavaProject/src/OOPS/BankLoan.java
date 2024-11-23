package OOPS;

public class BankLoan {
	
	private String name;
	private int age;
	private int amount;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		if(age>= 18 || age<= 50) {
		this.age = age;
		} else {
			System.out.println("Please enter the valid Age");
		}
	}
	
	public void setAmount(int amount) {
		if(amount>=1000 || amount<=10000000) {
		this.amount = amount;
		} else {
			System.out.println("Please enter the valid amount");
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getAmount() {
		return amount;
	}

}
