
public class UnsortedDate212List extends Date212List {

	public UnsortedDate212List() {}
	
	public void add(Date212 arg) {append(arg);}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Date212Node i = head.next; i != null; i = i.next) {
			sb.append(i.toString() + "\n");
		}
		
		sb.append("null");
		
		return sb.toString();
	}
	
}
