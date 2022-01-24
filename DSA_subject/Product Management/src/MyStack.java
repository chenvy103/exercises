/**

* Generic version of the Stack class.

*

* @param <T> the type of the value

*/
public class MyStack<T> {
	 /**

	  * Head node contains front node in the stack

	  */

	 Node<T> head;

	// Hàm đẩy 1 phần tử vào stack
	void push(T item) {head=new Node<T>(item,head);}
	// Hàm lấy 1 phần tử ra khỏi stack
	T pop(){
		T item =head.info;
		head=head.next;
		return item;
	}

}
