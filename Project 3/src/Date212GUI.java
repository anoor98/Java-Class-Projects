import javax.swing.*;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Date212GUI extends JFrame {

	public Date212GUI() throws Exception{
		super("Date");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		GridLayout grid = new GridLayout(1, 2);
		this.setLayout(grid);
		this.setVisible(true);
		createMenu();
		this.setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem item;
		FileMenu fmh = new FileMenu(this);
		
		item = new JMenuItem("Open"); 
		item.addActionListener(fmh);
		fileMenu.add(item);
		fileMenu.addSeparator(); 
		item = new JMenuItem("Quit"); 
		item.addActionListener(fmh);
		fileMenu.add(item);
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
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
	
	public void readFile(File file) throws Exception {
		UnsortedDate212List myDates = new UnsortedDate212List();
		SortedDate212List sortedDates = new SortedDate212List();
		
		Scanner sc = new Scanner(file);
		
		while(sc.hasNext()) {
			String input = sc.nextLine();
			String[] strDates = input.split(",");
			
			for(int i = 0; i < strDates.length; i++) {
				Date212 theDay = new Date212(strDates[i]);
				
				if (theDay.validDate() == true) {
					myDates.add(theDay);
					sortedDates.add(theDay);
				}//end of if-statement
					
			}//end of for-loop
					
		} //end of while loop
		
		JTextArea unSorted = new JTextArea();
		unSorted.setText("Dates Read: \n");
		for (Date212Node i = myDates.head.next; i != null; i = i.next) {
			unSorted.append(i.data.toString() + "\n");
		}
		unSorted.setVisible(true);
		unSorted.setEditable(false);
		this.add(unSorted);

		
		JTextArea Sorted = new JTextArea();
		Sorted.setText("Dates Sorted: \n");
		for (Date212Node i = sortedDates.head.next; i != null; i = i.next) {
			Sorted.append(i.data.toString() + "\n");
		}
		Sorted.setVisible(true);
		Sorted.setEditable(false);
		this.add(Sorted);
		this.setVisible(true);
		
		sc.close();
		
	}
	
	public static void main(String[] args) throws Exception{ 
		new Date212GUI();
	}

}
