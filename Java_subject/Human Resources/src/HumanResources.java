import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HumanResources{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choose;
		ArrayList<Department> Dep= new ArrayList<Department>(); //create arrDepartmentList
		ArrayList<Staff> staffList = new ArrayList<Staff>(); 	//create arrStaffList
		System.out.println("Welcome");
		do {
			menu();
			System.out.print("Chọn Chức năng: ");
			choose=input.nextInt();

			switch (choose) {
				case 1:showStaff(staffList);break;
				case 2:showDep(Dep);break;
				case 3:sortDep(staffList, Dep);break;
				case 4:create(input, staffList, Dep);break;
				case 5:find(input, staffList);break;
				case 6:salary(input, staffList);break;
				case 7:
					Collections.sort(staffList, new SalaryUp());
					for (Staff st : staffList) {
						st.displayInformation();
						System.out.printf("Luong= %.1f",st.getSalary());
						System.out.println();
					};
					break;
				case 8:
					Collections.sort(staffList, new SalaryDown());
					for (Staff st : staffList) {
						st.displayInformation();
						System.out.printf("Luong= %.1f",st.getSalary());
						System.out.println();
					};
					break;
				case 9:System.out.println("End!");break;
				default:System.out.println("Invalid selection!");break;

			}
		}while(choose!=9);


	}

	public static void create(Scanner input, ArrayList<Staff> l, ArrayList<Department> d) {
		int type;
		do {
		System.out.print("1-Nhân viên thông thuong 2-Cấp quản lý");
		type=input.nextInt();
		if(type!=1&&type!=2) {System.out.println("Invalid selection!");}
		}while(type!=1&&type!=2);

		int id;
		boolean checkId; //Employee IDs are unique and cannot be duplicated
		do {
		checkId=true;
		System.out.print("Mã nhân viên: ");
		id=input.nextInt();
		if (l.size()>0){
			for(int i=0; i<l.size();i++) {
				if(id==(l.get(i).getId())) {
					checkId=false;
					System.out.println("Mã nhân viên này đã tồn tại!");
				}
			}
		}
		}while(checkId==false);

		System.out.print("Tên nhân viên: ");
		String name=input.next();
		System.out.print("Tuổi nhân viên: ");
		int age=input.nextInt();
		System.out.print("Hệ số lương: ");
		int factor=input.nextInt();
		System.out.print("Ngày vào làm: ");
		String datein=input.next();

		//Department
		int pNum;
		String part = "";
		do {
		System.out.print("Bộ phận làm việc: 1-Business, 2-Project, 3-Technical, 4-addOther");
		pNum=input.nextInt();
		if(pNum==1) {part="Business";}
		else if(pNum==2) {part="Project";}
		else if(pNum==3) {part="Technical";}
		else if(pNum==4){
			System.out.print("Nhập tên bộ phận: ");
			part=input.next();
		}
		else{System.out.println("Invalid selection!");}
		}while (pNum<0||pNum>4);

		if(d.size()==0) {d.add(d.size(),new Department(d.size()+1,part,d.size()+1));} //create new when not available
		else {addDep(d,part,false);}

		System.out.print("Số ngày nghỉ phép: ");
		int dayleave=input.nextInt();

		//createStaff
		if(type==2) {//isManager
			System.out.print("chức vụ: ");
			String title=input.next();
			l.add(l.size(),new Manager(id, name, age, factor, datein, part, dayleave, title));
			((Manager) l.get(l.size()-1)).calculateSalary();

		}else {//isEmployee
			System.out.print("Nhập số giờ làm thêm: ");
			double time=input.nextDouble();
			l.add(l.size(), new Employee(id, name, age, factor, datein, part, dayleave, time));
			((Employee) l.get(l.size()-1)).calculateSalary();
		}

		System.out.println("Added staff!");

	}

	//option1: Show list staff
	public static void showStaff(ArrayList<Staff> l) {
		if(l.size()==0) {System.out.println("No staff!");}
		else {
			for(int i=0;i<l.size();i++) {
				l.get(i).displayInformation();
			}
		}

	}

	//option2: Show list department
	public static void showDep(ArrayList<Department> d) {
		if(d.size()==0) {System.out.println("No department!");}
		else {
			for(int i=0;i<d.size();i++) {
				System.out.println(d.get(i).toString());
			}
		}

	}

	//option3: Show employees by department
	public static void sortDep(ArrayList<Staff> l,ArrayList<Department> d) {
		if(d.size()==0) {System.out.println("No data!");}
		for(int i=0;i<d.size();i++) {
			String dpart=d.get(i).getPartName();
			System.out.println("Bộ phận "+dpart+":");
			for(int j=0;j<l.size();j++) {
				String spart=l.get(j).getPart();
				if(spart.equalsIgnoreCase(dpart)) {
					l.get(j).displayInformation();
				}
			}
		}
	}

	//option5: Search for employee information
	public static void find(Scanner input, ArrayList<Staff> l) {
		System.out.print("Tìm kiếm nhân viên theo 1-Tên, 2-Mã : ");
		int pick=input.nextInt();
		if(pick==1) {
			System.out.print("Nhập tên nhân viên: ");
			String name=input.next();
			for(int i=0; i<l.size();i++) {
				if(name.equalsIgnoreCase(l.get(i).getName())==true) {
					l.get(i).displayInformation();
				}
			}
		}else {
			System.out.print("Nhập mã nhân viên: ");
			int id=input.nextInt();
			for(int i=0; i<l.size();i++) {
				if(id==(l.get(i).getId())) {
					l.get(i).displayInformation();
				}
			}
		}
	}

	//option6: Display payroll of employees throughout the company
	public static void salary(Scanner input, ArrayList<Staff> l) {
		for(int i=0; i<l.size();i++) {
			l.get(i).displayInformation();
			System.out.printf("Luong= %.1f",l.get(i).getSalary());
			System.out.println();

		}
	}

	//menu options
	public static void menu() {
		System.out.println("------------------");
		System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
		System.out.println("2. Hiển thị các bộ phận trong công ty");
		System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
		System.out.println("4. Thêm nhân viên mới vào công ty");
		System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
		System.out.println("6. Hiển thị bảng luong của nhân viên toàn công ty");
		System.out.println("7. Hiển thị bảng luong của nhân viên theo thứ tự tăng dần");
		System.out.println("8. Hiển thị bảng luong của nhân viên theo thứ tự giảm dần");
		System.out.println("9. Exit");
	}

	//create new | change department information
	public static boolean addDep(ArrayList<Department> d,String part,boolean e) {

		for(int i=0;i<d.size();i++) {
			if(part.equalsIgnoreCase(d.get(i).getPartName())==true) {
				d.get(i).setNumStaff(d.get(i).getNumStaff()+1); //change the number of employees
				return e=true;
			}
		}
		if(e!=true) {d.add(d.size(),new Department(d.size()+1,part,1));}//create new
		return e;
	}

}

//option7: Display employee payroll in ascending order
class SalaryUp implements Comparator<Staff> {
	public int compare(Staff s1, Staff s2) {
		if (s1.getSalary() == s2.getSalary())
			return 0;
		else if (s1.getSalary() > s2.getSalary())
			return 1;
		else
			return -1;
	}
}

//option8: Display employee payroll in descending order
class SalaryDown implements Comparator<Staff> {
	public int compare(Staff s1, Staff s2) {
		if (s1.getSalary() == s2.getSalary())
			return 0;
		else if (s1.getSalary() < s2.getSalary())
			return 1;
		else
			return -1;
	}
}