import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Algorithm {
	float [] a,b; int n;


 /** Writing the array read from input array arr to file
  * @param fileName The file name of file to write value
  * @param arr      The input float array
  * @param append   Overwrite or add new content at the end */
 public void writeFile(String fileName, float[] arr,boolean append) {
	 try {
		 FileWriter fw = new FileWriter(fileName,append);

	     for (int i=0; i<arr.length;i++) {
	    	 fw.write((int) arr[i]);
	     }

	        fw.close();
	     //System.out.println("write file successfully");

      } catch (IOException e) {
    	  System.out.println("write file failure");
      }

 }



 /** Reading the file then input to the array arr
  * @param fileName The file name of file to read
  * @param arr      The output float array that will contain value read from file */
 public void readFile(String fileName, float arr[]) {
	 try {
		 FileReader fr = new FileReader(fileName);
	     int i = 0;int j=0;
	        // Đọc lần lượt từng ký tự.
	        while ((i = fr.read()) != -1) {
	            //System.out.println( i);
	            arr[j]=i;
	            j++;}
	        fr.close();
	     System.out.print("Array a:");
	     display(arr);
	 } catch (IOException e) {
		 System.out.println("read file failure");
	 }
 }


//display the elements of the array arr
 public void display(float[] arr) {
	 int i;
	  for(i=0;i<arr.length;i++)
		  System.out.print("  " + arr[i]);
		  System.out.println();

}

 //change position i&k in array arr
 void swap(float[] arr, int i, int k) {
		float x; x=arr[i];arr[i]=arr[k];arr[k]=x;
	}


/** Sorting the input array arr using Bubble Sort algorithm.
  * @param arr  Input array using for sorting
  * @param show Whether or not to display the algorithms step-by-step sorting results
  * @return Returning a sorted array by using the Bubble Sort algorithm */
 public float[] bubbleSort(float arr[], boolean show) {
	 int i; boolean swapped;
	 boolean append=false;
		do{
			swapped=false;
			for(i=0;i<n-1;i++)
	        if ( arr[i]> arr[i+1] ){
	        	swap(arr,i,i+1);
	        	swapped=true;
	        }
			if (show) display(arr);
			writeFile("output1.txt",arr,append);
			append=true;
	     }while (swapped);
	return arr;

 }



 /**Sorting the input array arr using Selection Sort algorithm.
  * @param arr Input array using for sorting
  * @param show Whether or not to display the algorithms step-by-step sorting results
  * @return Returning a sorted array by using the Selection Sort algorithm */
 public float[] selectionSort(float arr[], boolean show) {
	 int i, j, k;
	 float min;boolean append=false;
	 for(i=0; i<n-1; i++){
		 min = arr[i]; k=i;
    	 for (j = i+1; j<n ; j++)
    		 if( arr[j] < min) {k =j;min=arr[j];}
    	 if(k != i) swap( arr,i, k );
    	 if (show) display(arr);
    	 writeFile("output2.txt",arr,append);append=true;
     }
	return arr;

 }



 /**Sorting the input array arr using Insertion Sort algorithm.
  * @param arr Input array using for searching
  * @param show Whether or not to display the algorithms step-by-step sorting results
  * @return Returning a sorted array by using the Insertion Sort algorithm */
 public float[] insertionSort(float arr[], boolean show) {
	 int  i, j; float x;
	 boolean append=false;
	    for( i=1; i < n; i++){
	    	x = arr[i];
	    	j=i;

	    	while ( j>0 && x < arr[j-1]){
	    		arr[j] = arr[j-1]; //pull forward
	        	j--;
	        };
	        arr[j]=x;
	        if (show) display(arr);
	        writeFile("output3.txt",arr,append);append=true;
	     }

	return arr;

 }



 /**Searching the indices of elements in array [arr] greater than value. Printing
  and writing all indices to the console screen and file OUTPUT4.TXT separated by space.
  * @param arr   Input array using for searching
  * @param value The value for searching */
public void search(float arr[], float value) {
	 boolean find=false;
	 int j=0;
	 float[] s=new float[n];
	 System.out.print("Chi so la:");
	 for(int i=0;i<arr.length;i++) {
		 if(arr[i]>value) {
			 System.out.print(" "+i);
			 s[j]=i;
			 j++;

			 find=true;
		 }
	 }
	 if(!find) System.out.print(" -1");
	 System.out.println();

	 writeFile("output4.txt", s,false);
 }



 /**Searching by using the Binary Search algorithm. Returning the first index of
  value if it is present in array arr, otherwise, return -1. The index also
  written to file OUTPUT5.TXT and shown on the console screen.
  * @param arr   Input array using for searching
  * @param left  The left index
  * @param right The right index
  * @param value The value for searching
  * @return The index of the element if found, otherwise, return -1 */
 public int binarySearch(float arr[], int left, int right,float value) {
	 int index = -1;
	  while (left <= right) {
		  index = left + (right - left) / 2; //==middle

	    if (arr[index] < value) {
	    	left = index + 1;
	    }
	    if (arr[index] > value) {
	    	right = index - 1;
	    }
	    if (arr[index] == value) {
	      return (index);
	    }
	  }
	  return index;

 }

}
