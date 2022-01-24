import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Operation {

	//save all output printed to the screen to a file
	static void newprint(String str) throws IOException {

		FileOutputStream fout = new FileOutputStream("console_output.txt",true); //append
	    PrintStream pout = new PrintStream(fout);

	    pout.println(str);
	    System.out.println(str);
        pout.close();
        fout.close();
	}

	 static Scanner input= new Scanner(System.in);

	 //headings
	static void displaySubItem() throws IOException {
			newprint("ID | Title | Quantity | Price");
			newprint("-----------------------------");
	}
	 /**

	  * Searching and returning the index of product p in the list. If not found

	  * return -1.

	  *

	  * @param p    Product for searching

	  * @param list The Linked List

	  * @return The index of product p in the list

	  */

	 public int index(Product p, MyList<Product> list) {
		Node<Product> cur=list.head;
		int i=0;
		while(cur!=null) {
			if(cur.info==p) {
				return i;
			}
			i++;
			cur=cur.next;
		};
		return -1;

	 }



	 /**

	  * Creating and returning a product with info input from keyboard.

	  *

	  * @return The product
	 * @throws IOException

	  */

	public static Product createProduct() throws IOException {
		 newprint("Input new ID: ");
		 String bcode=input.next();
		 newprint("Input Product's Name: ");
		 String title=input.next();
		 newprint("Input Product's quantity: ");
		 int quantity= input.nextInt();
		 newprint("Input Product's price: ");
		 double price= input.nextDouble();

		return new Product(bcode,title,quantity,price);

	 }



	 /**

	  * Reading all products from the file and insert them to the list at tail.

	  *

	  * @param fileName The file name of the file

	  * @param list     The Linked List contains all products that read from file
	 * @throws IOException

	  */

	@SuppressWarnings("resource")
	public static void getAllItemsFromFile(String fileName, MyList<Product> list) throws IOException {
		try {
			FileInputStream file = new FileInputStream(fileName);
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				String[] data = scan.nextLine().split(" \\| "); //tách
				list.insertToTail(new Product(data[0],data[1],Integer.parseInt(data[2]) ,Double.parseDouble(data[3])));
			}
			file.close();
			displayAll(list);
			newprint("Successfully!");

		}catch (IOException e) {
			 newprint("read file failure");
		}
	 }



	 /**

	  * Reading all products from the file and insert them to the stack.

	  *

	  * @param fileName The file name of the file

	  * @param stack     The Stack contains all products that read from file
	 * @throws IOException

	  */

	 @SuppressWarnings("resource")
	public static void getAllItemsFromFile(String fileName, MyStack<Product> stack) throws IOException {
		 try {
			FileInputStream file = new FileInputStream(fileName);
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				String[] data = scan.nextLine().split(" \\| ");
				stack.push(new Product(data[0],data[1],Integer.parseInt(data[2]) ,Double.parseDouble(data[3])));
			}
			file.close();
			while (stack.head!=null){newprint(stack.pop().toString());}//display
			newprint("Successfully!");

		}catch (IOException e) {
			 newprint("read file failure");
		}
	 }



	 /**

	  * Reading all products from the file and insert them to the queue.

	  *

	  * @param fileName The file name of the file

	  * @param queue     The Queue contains all products that read from file
	 * @throws IOException

	  */

	 @SuppressWarnings("resource")
	public static void getAllItemsFromFile(String fileName, MyQueue<Product> queue) throws IOException {
		 try {
			FileInputStream file = new FileInputStream(fileName);
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				String[] data = scan.nextLine().split(" \\| ");
				queue.enqueue(new Product(data[0],data[1],Integer.parseInt(data[2]) ,Double.parseDouble(data[3])));
			}
			file.close();
			while (queue.head!=null){newprint(queue.dequeue().toString());}//display
			newprint("Successfully!");

		}catch (IOException e) {
			 newprint("read file failure");
		}
	 }



	 /**

	  * Adding a product to the list, info of the product input from keyboard.

	  *

	  * @param list The Linked list
	 * @throws IOException

	  */

	 public static void addLast(MyList<Product> list) throws IOException {
		 list.insertToTail(createProduct());
		 newprint("Added!");
	 }



	 /**

	  * Printing all products of the list to console screen

	  *

	  * @param list
	 * @throws IOException

	  */

	 public static void displayAll(MyList<Product> list) throws IOException {
		 displaySubItem();
		 Node<Product> cur=list.head;
		 while(cur!=null) {
			 newprint(cur.toString());
			 cur=cur.next;
		 }
	 }



	 /**

	  * Writing all products from the list to the file

	  *

	  * @param fileName Input file name

	  * @param list     Input Linked list
	 * @throws IOException

	  */

	 public static void writeAllItemsToFile(String fileName, MyList<Product> list) throws IOException {
		 try {
			 FileWriter fw = new FileWriter(fileName);
			 Node<Product> cur=list.head;
		     while(cur!=null) {
		    	 fw.write(cur.toString());
		    	 cur=cur.next;
		     }

		     fw.close();
		     newprint("Successfully!");

	      } catch (IOException e) {
	    	  newprint("write file failure");
	      }
	 }



	 /**

	  * Searching product by ID input from keyboard.

	  *

	  * @param list
	 * @throws IOException

	  */

	 public static void searchByCode(MyList<Product> list) throws IOException {
		newprint("Input the ID to search=");
		String id =input.next();
		Node<Product> cur=list.head;
		while(cur!=null) {
			if(cur.info.bcode.equalsIgnoreCase(id)) {
				newprint("Result: "+cur.toString());
				return;
			}
			cur=cur.next;
		}
		newprint("Result: -1");
	 }



	 /**

	  * Deleting first product that has the ID input from keyboard from the list.

	  *

	  * @param list
	 * @throws IOException

	  */

	 public static void deleteByCode(MyList<Product> list) throws IOException {
		newprint("Input the bcode to delete=");
		String id =input.next();
		Node<Product> cur=list.head;
		Node<Product> prev = null;
		if (cur != null && cur.info.bcode.equalsIgnoreCase(id)){
			 list.head = cur.next; // Changed head
			 newprint("Deleted!");
			 return;
		}
		while(cur!=null && cur.info.bcode.equals(id)==false) {
			prev = cur;
			cur = cur.next;
		}
		if (cur == null) return;
		prev.next = cur.next;
		newprint("Deleted!");

	 }



	 /**

	  * Sorting products in linked list by ID

	  *

	  * @param list The Linked list
	 * @throws IOException

	  */

	 public static void sortByCode(MyList<Product> list) throws IOException {
		 list.quick_sort(list.head,list.last());
		 newprint("Successfully!");
	 }



	 /**

	  * Adding new product to head of Linked List. The info input from keyboard.

	  *

	  * @param list The linked list
	 * @throws IOException

	  */

	 public void addFirst(MyList<Product> list) throws IOException {
		 list.insertToHead(createProduct());
	 }



	 /**

	  * Convert a decimal to an array of binary. Example: input x = 18 -> Output =

	  * {0, 1, 0, 0, 0, 1}

	  *

	  * @param x Input decimal number

	  * @return Array of binary numbers
	 * @throws IOException

	  */

	 public static int[] convertToBinary(int x) throws IOException {
		 int[] bin = new int[20];
		 int i=0;
		 String result="";
		 while(x!=0) {
			bin[i]=(x%2);
			x=x/2;
			i++;
		}
		 for(int j=i-1;j>=0;j--) {
			 result+=bin[j];
		 }
		 newprint("("+result+")");
		return bin;

	 }


}
