
public class Manager extends Staff implements ICalculator{

	public Manager(int id, String name, int age, int factor, String datein, String part, int dayLeave, String title) {
		super(id, name, age, factor, datein, part, dayLeave);
		this.title = title;
	}

	private String title; //Chức vụ

	@Override
	void displayInformation() {
		System.out.println("ID:"+super.getId()+" Name:"+super.getName()+" Age:"+super.getAge()+" Department:"+super.getPart()+" Date of work:"+super.getDateIn()+" Chức vụ:"+getTitle());

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public double calculateSalary() {
		//nếu là leader ++bonus luong trách nhiệm
		if("leader".equalsIgnoreCase(getTitle())==true) {
			if("business".equalsIgnoreCase(super.getPart())==true) {
				super.setSalary(super.getFactor()*5000000+8000000);
			}
			else if("project".equalsIgnoreCase(super.getPart())==true) {
				super.setSalary(super.getFactor()*5000000+5000000);
			}
			else if("technical".equalsIgnoreCase(super.getPart())==true) {
				super.setSalary(super.getFactor()*5000000+6000000);
			}
		}
		else {super.setSalary(super.getFactor()*5000000);}
		return super.getSalary();

	}



}
