
public class Date212Node {
	
	protected Date212 data;
	protected Date212Node next;
	
	public Date212Node() {
		this.data = null;
		this.next = null;
	}
	
	public Date212Node(Date212 d) {
		this.data = d;
		this.next = null;
	}
	
	public Date212Node(Date212 d, Date212Node n) {
		this.data = d;
		this.next = n;
	}

}
