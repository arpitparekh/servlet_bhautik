package my_project;

public class Majoor {
	
	int id;
	String name;
	float salary;
	String image_path;
	byte[] image;
	
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
	
	
	
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Majoor(int i, String name, float salary,byte[] image,String image_path) {
		
		this.id = i;
		this.name = name;
		this.salary = salary;
		this.image = image;
		this.image_path = image_path;
	}
	@Override
	public String toString() {
		return "Majoor [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	public Majoor() {
		
	}
	
	

}
