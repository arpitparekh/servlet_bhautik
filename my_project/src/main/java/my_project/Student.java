package my_project;

public class Student {
	
	String name = null;
	String phone = null;
	int age = 0;
	
	public Student(String name, String phone, int age) {
		
		this.name = name;
		this.phone = phone;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}
	
	
	
	
	

}
