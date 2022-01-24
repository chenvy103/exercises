
public class Department {
	private int partId; 	//Mã bộ phận
	private String partName;//Tên bộ phận
	private int numStaff;	//Số luong nhân viên hiện tại

	public Department(int id, String name, int num){
		this.partId=id;
		this.partName=name;
		this.numStaff=num;
	}
	public String toString() {
		return "Mã bộ phận:"+partId+ " Tên bộ phận:"+partName+ " Số nhân viên hiện tại:"+numStaff;

	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public int getNumStaff() {
		return numStaff;
	}

	public void setNumStaff(int numStaff) {
		this.numStaff = numStaff;
	}
}
