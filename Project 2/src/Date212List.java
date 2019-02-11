
public class Date212List {

	protected Date212Node head;
	protected Date212Node tail;
	
	public int length;
	
	public Date212List() {
		this.head = new Date212Node(null);
		this.tail = this.head;
		this.length = 0;
	}
	
	public void append(Date212 arg) {
		Date212Node newNode = new Date212Node(arg);
		this.tail.next = newNode;
		this.tail = newNode;
		this.length++;
	}
	
	public int getLength() {return length;}
	
}