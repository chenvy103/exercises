import java.util.Scanner;

public class MainSort {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Algorithm sample=new Algorithm ();
		int choice;
		float[]b;float value;
		do {
			menu();
			do {
				System.out.print("Choice: ");
				choice=sc.nextInt();
				switch (choice) {
				case 1:
					System.out.print("Input number of elements: ");
				    sample.n=sc.nextInt();
				    float[] a=new float[sample.n];
				    System.out.print("Input elements: ");
				    for(int i=0;i<a.length;i++) {
				    	a[i]=sc.nextFloat();
				    }
					sample.writeFile("input.txt",a,false);break;

				case 2:
					System.out.println("Read from file");
					sample.a=new float[sample.n];sample.readFile("input.txt", sample.a);break;

				case 3:
					System.out.println("Bubble sort");
					b=new float[sample.n];
					copy(sample.a,b);
					sample.b=sample.bubbleSort(b,true);
					break;

				case 4:
					System.out.println("Selection sort");
					b=new float[sample.n];
					copy(sample.a,b);
					sample.b=sample.selectionSort(b,true);
					break;

				case 5:
					System.out.println("Insertion sort");
					b=new float[sample.n];
					copy(sample.a,b);
					sample.b=sample.insertionSort(b,true);
					break;

				case 6:
					System.out.println("Linear Search");
					System.out.print("Input value: ");
					value=sc.nextFloat();
					sample.search(sample.a, value);
					break;

				case 7:
					System.out.println("Binary Search");
					System.out.print("Input value: ");
					value=sc.nextFloat();
					b=new float[sample.n];
					copy(sample.a,b);
					int i=sample.binarySearch(sample.bubbleSort(b,false), 0, b.length-1, value);
					System.out.println("Indext of fist element: "+i);
					float[] s= {i};
					sample.writeFile("output5.txt",s,false);
					break;

				case 0: System.out.println("Thanks!!!");break;
				default: System.out.println("Invalid selection!");
				}
			}while(choice<0||choice>7);
		}while(choice!=0);

	}

	public static void menu() {
		System.out.println("+-------------------Menu------------------+");
		System.out.println("|      1.Input                            |");
		System.out.println("|      2.Output                           |");;
		System.out.println("|      3.Bubble sort                      |");;
		System.out.println("|      4.Selection sort                   |");;
		System.out.println("|      5.Insertion sort                   |");;
		System.out.println("|      6.Search > value                   |");;
		System.out.println("|      7.Search = value                   |");;
		System.out.println("|      0.Exit                             |");
		System.out.println("+-----------------------------------------+");
		System.out.println();

	}
	public static float[] copy(float[] a, float[] b) {
		for(int i=0;i<a.length;i++) {
			b[i]=a[i];

		}
		return b;
	}

}
