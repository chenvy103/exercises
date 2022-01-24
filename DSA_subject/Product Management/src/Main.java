import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Operation {

	 public static void showMenu() throws IOException {

		   newprint("Choose one of this options:");

		   newprint("Product list:");

		   newprint("1. Load data from file and display");

		   newprint("2. Input & add to the end.");

		   newprint("3. Display data");

		   newprint("4. Save product list to file.");

		   newprint("5. Search by ID");

		   newprint("6. Delete by ID");

		   newprint("7. Sort by ID.");

		   newprint("8. Convert to Binary");

		   newprint("9. Load to stack and display");

		   newprint("10. Load to queue and display.");

		   newprint("0. Exit");

		 }
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		new FileOutputStream("console_output.txt"); //file will be reset every time the program is run

		MyList<Product> list = new MyList<Product>();
		MyStack<Product> stack = new MyStack<Product>();
		MyQueue<Product> queue = new MyQueue<Product>();

		Scanner scan= new Scanner(System.in);
		int choose;
		do {
			showMenu();
			System.out.print("choice=");
			choose=scan.nextInt();
			switch(choose) {
			case 1:
				getAllItemsFromFile("data.txt",list);
				break;
			case 2:
				addLast(list);
				break;
			case 3:
				displayAll(list);
				break;
			case 4:
				writeAllItemsToFile("data.txt",list);
				break;
			case 5:
				searchByCode(list);
				break;
			case 6:
				deleteByCode(list);
				break;
			case 7:
				sortByCode(list);
				break;
			case 8:
				newprint("Quantity="+list.head.info.quantity+"=>");
				convertToBinary(list.head.info.quantity);
				break;
			case 9:
				getAllItemsFromFile("data.txt",stack);
				break;
			case 10:
				getAllItemsFromFile("data.txt",queue);
				break;
			case 0:break;
			default:newprint("Invalid choice!");break;
			}
			newprint("");
		}while(choose!=0);

	}

}
