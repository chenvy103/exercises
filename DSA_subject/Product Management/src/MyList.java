/**

* Generic version of the LinkedList class.

*

* @param <T> the type of the value

*/
public class MyList<T> {
	 /**

	  * Head node, default is null

	  */

	 Node<T> head;



	 /**

	  * Tail node, default is null

	  */

	 Node<T> tail;



	 /**

	  * Default constructor

	  */

	 public MyList() {
		 head=tail=null;
	 }



	 /**

	  * Constructor with head and tail

	  *

	  * @param head Head node of this list

	  * @param tail Tail node of this list

	  */

	 public MyList(Node<T> head, Node<T> tail) {
		 this.head=head;
		 this.tail=tail;
	 }



	 /**

	  * Checking if this list is empty

	  *

	  * @return true if list is empty

	  */

	 public boolean isEmpty() {
		return head==null;

	 }



	 /**

	  * Returning the length of this list

	  *

	  * @return The length of this list

	  */

	 public int length() {
		 int length=0;
		 Node<T> cur=this.head;
		 while(cur!=null) {
			 length++;
			 cur=cur.next;
		 }
		return length;

	 }



	 /**

	  * Insert an item to the head of this list

	  *

	  * @param item The item to be inserted

	  */

	 public void insertToHead(T item) {
		 Node<T> t= new Node<T>(item,null);
		 if(isEmpty()) {
			 this.head=t;
			 this.tail=t;
			 return;
		 }
		 t.next=this.head;
		 this.head=t;
	 }
	//Insert an item to the tail of this list
	 public void insertToTail(T item) {
		 Node<T> t= new Node<T>(item,null);
		 if(isEmpty()) {
			 this.head=t;
			 this.tail=t;
			 return;
		 }
		 this.tail.next= t;
		 this.tail=t;
	 }


	 /**

	  * Insert an item at position to this list

	  *

	  * @param position The position of new item

	  * @param item     The item to be inserted

	  */

	 public void insertAfterPosition(int position, T item) {
		 Node<T> t= new Node<T>(item,null);
		 Node<T> cur=this.head;
		 int i=1;
		 while(i<position) {
			 cur=cur.next;
			 i++;
		 }
		 t.next=cur.next;
		 cur.next=t;
	 }



	 /**

	  * Deleting the tail of this list

	  */

	 public void deleteTail() {
		 this.tail=null;
	 }



	 /**

	  * Deleting all items in the list

	  */

	 public void clear() {
		 head=tail=null;
	 }



	 /**

	  * Swaping two nodes [Node1] and [Node2]

	  *

	  * @param node1

	  * @param node2

	  */

	 public static void swap(Node<Product> node1, Node<Product> node2) {
			Product temp = new Product();
			 temp=node1.info;
			 node1.info=node2.info;
			 node2.info=temp;
	 }


	//Find last node of linked list
		public Node<T> last(){
			Node<T> cur = this.head;
			while (cur != null && cur.next != null)
				cur = cur.next;

			return cur;
		}

		//Set of given last node position to its proper position
		public Node<Product> parition(Node<Product> first, Node<Product> last){
			//Get first node of given linked list
			Node<Product> pivot = first;
			Node<Product> front = first;
			while (front != null && front != last){
				if ((front.info.bcode).compareTo(last.info.bcode)<0){
					pivot = first;
					swap(first,front); //Swap node value
					first = first.next;
				}
				front = front.next;
			}
			swap(first,last); //Change last node value to current node
			return pivot;
		}

		//Perform quick sort in given linked list
		public void quick_sort(Node<Product> first, Node<Product> last){
			if (first == last) return;

			//Find pivot node
			Node<Product> pivot = parition(first, last);

			if (pivot != null && pivot.next != null)
				quick_sort(pivot.next, last);

			if (pivot != null && first != pivot)
				quick_sort(first, pivot);
		}
}
