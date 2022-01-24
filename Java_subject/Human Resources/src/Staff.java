
public abstract class Staff {
	private int id;
	private String name;
	private int age;
	private int factor; 	//hệ số lương
	private String dateIn; 	//ngày vào làm
	private String part; 	//DepartmentName
	private int dayLeave; 	//số ngày nghỉ phép
	private double salary;
	abstract void displayInformation();

	public String toString() {
		return id+name+age+factor+dateIn+part+dayLeave;

	}
	public Staff(int id, String name, int age, int factor, String datein, String part, int dayLeave) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.factor = factor;
		this.dateIn = datein;
		this.part = part;
		this.dayLeave = dayLeave;
	}

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

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getFactor() {
		return factor;
	}
	public void setFactor(int factor) {
		this.factor = factor;
	}

	public String getDateIn() {
		return dateIn;
	}
	public void setDateIn(String datein) {
		this.dateIn = datein;
	}

	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}

	public int getDayLeave() {
		return dayLeave;
	}
	public void setDayLeave(int dayleave) {
		this.dayLeave = dayleave;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
