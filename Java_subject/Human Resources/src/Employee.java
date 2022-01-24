
public class Employee extends Staff implements ICalculator{
	public Employee(int id, String name, int age, int factor, String datein, String part, int dayLeave, double overtime) {
		super(id, name, age, factor, datein, part, dayLeave);
		this.overTime = overtime;
	}
	private double overTime; //số giờ làm thêm



	@Override
	void displayInformation() {
		System.out.println("ID:"+super.getId()+" Name:"+super.getName()+" Age:"+super.getAge()+" Department:"+super.getPart()+" DateIn:"+super.getDateIn());

	}


	public double getOvertime() {
		return overTime;
	}
	public void setOvertime(double overtime) {
		this.overTime = overtime;
	}



	@Override
	public double calculateSalary() {
		super.setSalary(super.getFactor()*3000000+getOvertime()*200000);
		return super.getSalary();
	}



}

//interface chua ham tinh luong
interface ICalculator {
	public double calculateSalary();
}