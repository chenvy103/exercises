/**

* Generic version of the Queue class.

*

* @param <T> the type of the value

*/
public class MyQueue<T> {
	 /**

	  * Head node contains front node in the queue

	  */

	 Node<T> head;



	 /**

	  * Tail node contains last node in the queue

	  */

	 Node<T> tail;

	//thêm 1 phần tử vào hàng đợi.
	void enqueue(T item) {
		Node<T> t= new Node<T>(item,null);
		if(head==null) {
			head = tail = t;
			return;
		}
		tail.next = t;
        tail = tail.next;
	}

	//xóa 1 phần tử khỏi hàng đợi.
	T dequeue(){
		T item = head.info;
	    head=head.next;
	    if(head==null) tail=null;
	        return item;
	}
}
