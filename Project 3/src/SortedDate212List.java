
public class SortedDate212List extends Date212List{
	
	public SortedDate212List() {}
	
	public void add(Date212 arg) throws Exception {
		Date212Node n = new Date212Node(arg);
		
		Date212Node i = head;
		
		while(i.next != null && arg.toCompare(i.next.data) == true) {
			i = i.next;
		}
		
		n.next = i.next;
		i.next = n;
		this.length++;
		
		if (i == head || i == this.tail) this.tail = n;
		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Date212Node i = head.next; i != null; i = i.next) {
			sb.append(i.toString() + "\n");
		}
		
		sb.append("null");
		
		return sb.toString();
	}
	
}
