package my_project;

public class Majoor {
	
	int id;
	String name;
	float salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Majoor(int i, String name, float salary) {
		
		this.id = i;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Majoor [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	
	

}
