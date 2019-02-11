import java.io.*; 
import java.util.*; 

public class Project3 {

	public static void main(String[] args) throws Exception{
		//new FileMenu(new Date212GUI());
		//FileMenu menuDates = new FileMenu(Dates);
		
		/*Practically all this code is copied and pasted 
		 * into DateGUI.java. I just tested out the outputs
		 * on the terminal here.
		 * */
		

		Date212[] myDates = new Date212[100];
		Date212[] sortedDates = new Date212[100];
		int index = 0;
		
		//read input files using scanner class
		File file = new File("Text.txt"); //input .txt file here
		Scanner sc = new Scanner(file);
		
		while(sc.hasNext()) {
			String input = sc.nextLine();
			String[] strDates = input.split(",");
			
			for(int i = 0; i < strDates.length; i++) { 
				Date212 theDay = new Date212(strDates[i]);
				
				if (theDay.validDate() == true) {
					myDates[index] = theDay;
					sortedDates[index] = theDay;
					index++;
				}//end of if-statement
				
			}//end of for-loop
			
		} //end of while loop
		
		System.out.println("Dates Read: ");
		for(int i = 0; i < myDates.length; i++) {
			if(myDates[i] == null) {break;}
			else
				System.out.println("myDate(Array): \t\t" + myDates[i].toString());
		}
		
		
		System.out.println("\nDates Sorted: ");
		selectionSort(sortedDates);
		for(int i = 0; i < sortedDates.length; i++) {
			if(sortedDates[i] == null) {break;}
			else
				System.out.println("myDate(Array): \t\t" + sortedDates[i].toString());
		}
		
		sc.close();
			
	}
	
	private static boolean toCompare(Date212 arg1, Date212 arg2) throws Exception {
		if(arg1.getYear() == arg2.getYear()) {
			if(arg1.getMonth() == arg2.getMonth()) {
				if(arg1.getDay() > arg2.getDay()) {
					return true;
				} 
				else return false;
			}
			else if(arg1.getMonth() > arg2.getMonth()) {
				return true;
			}
			else return false;
		}
		else if(arg1.getYear() > arg2.getYear()) {
			return true;
		}
		else return false;
	}
	
	public static Date212[] selectionSort(Date212[] arg) throws Exception {
		for(int i = 0; i < arg.length-1; i++) {
			int lowest = i;
				for(int j = i + 1; j < arg.length; j++) {
					if(arg[j] == null) {break;}
					if(toCompare(arg[lowest], arg[j]) == false) {
						lowest = j;
					}
					if(arg[lowest] != arg[i]) {
						Date212 temp = arg[lowest];
						arg[lowest] = arg[i];
						arg[i] = temp;
					}
				}
			
		}
		return arg;
	}
}
