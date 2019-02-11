import javax.swing.*;
import java.awt.GridLayout;
import java.io.File;
import java.util.Scanner;

public class DateGUI extends JFrame {

	public static void main(String[] args) throws Exception{
		JFrame date = new JFrame("Dates");
		date.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		date.setVisible(true);
		date.setSize(500, 500);
		GridLayout grid = new GridLayout(1, 2);
		date.setLayout(grid);
		
		Date212[] myDates = new Date212[100];
		Date212[] sortedDates = new Date212[100];
		int index = 0;
		
		//read input files using scanner class
		File file = new File("Text.txt"); //input .txt file here
		Scanner sc = new Scanner(file);
		
		
		/* This part of the project where I had to read the .txt file
		 * is where I spent ALOT of time on took me +12hrs to figure out why
		 * the String tokens of the .txt file were not properly put into strDates
		 * and then turned into Date212 objects. After hours of wrong fully rewriting
		 * blocks of code in various parts of my project I finally figured out, with a help from
		 * the tutoring center, that I need to create a "index" integer in my code that would
		 * hold the index size of the array and corresponded to the amount of token read in.
		 * If I hadn't spent so much time on this part I could have probably submitted this project
		 * earlier and it might have ran or looked better. Oh well.
		 * */
		
		while(sc.hasNext()) {
			String input = sc.nextLine();
			String[] strDates = input.split(",");
			
			for(int i = 0; i < strDates.length; i++) {
				//System.out.println("String: \t\t" + strDates[i]); 
				Date212 theDay = new Date212(strDates[i]);
				//System.out.println("Day: \t\t\t" +  theDay.toString());
				
				if (theDay.validDate() == true) {
					myDates[index] = theDay;
					//System.out.println("myDate(Array): \t\t" + myDates[i].toString());
					sortedDates[index] = theDay;
					//System.out.println("sortedDate(Array): \t" + sortedDates[i].toString());
					index++;
				}//end of if-statement
					
			}//end of for-loop
					
		} //end of while loop
		
		
		/* Creation of JTextAreas and their corresponding dates.
		 * 
		 * */
		JTextArea dates = new JTextArea();
		dates.setText("Dates Read:\n\n");
		for(int i = 0; i < myDates.length; i++) {
			if(myDates[i] == null) {break;}
			dates.append(myDates[i].toString() + "\n");
		}
		dates.setEditable(false);
		date.add(dates);
		
		JTextArea sorted = new JTextArea();
		selectionSort(sortedDates);
		sorted.setText("Sorted Dates:\n\n");
		for(int i = 0; i < sortedDates.length; i++) {
			if(sortedDates[i] == null) {break;}
			sorted.append(sortedDates[i].toString() + "\n");
		}
		sorted.setEditable(false);
		date.add(sorted);
		
		
		sc.close();
	}
	
	/*	In one of my earlier attempts of trying to solve
	 * the problem of reading an input text file, I thought it would 
	 * good to make a function that just copies every String element 
	 * of one array, creates a new Date212 out of them, and inputs them into
	 * a Date212 array of objects.  In the end I ended up not using it because 
	 * I thought this function was the reason the tokens weren't copying over.
	 * This function may be completely fine but by now I have finished the 
	 * project and don't want to go through the hassle of implementing.
	 * Oh Well
	 * */
	/*
	public static Date212[] copyDates(String[] arg1, Date212[] arg2) {
		for(int i = 0; i < arg1.length; i++) {
			Date212 theDay = new Date212(arg1[i]);
			if(theDay.validDate() == true) {
				arg2[i] = theDay;
			}
			else System.out.println(arg1[i] + " was not a valid date.");;
		}
		return arg2;
	}
	*/
	
	
	//This function works for the wrong reasons. Explanation in next function.
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
		//This sorting method sorts the data members of the array from 
		//latest date down to earliest date
		
		for(int i = 0; i < arg.length-1; i++) {
			//System.out.println(arg.length+ ",");
			int max = i;
				for(int j = i + 1; j < arg.length; j++) {
					//System.out.println(arg[j] + " and " +arg[i]);
					if(arg[j] == null) {break;}
					if(toCompare(arg[max], arg[j]) == false) {
						//originally I intended to sort from earliest date at the top,
						//to latest date at the bottom. This if statement originally checked
						//if toCompare() == false but the function ended up not putting the 
						//dates in order. For some reason, setting this if statement to check for false
						//puts the dates in order from latest at the top to earliest at the bottom.
						//I decided to leave it this way because the project document did not specify
						//the particular order the array needs to be; whether it's ascending or descending order.
						max = j;
					}
					if(arg[max] != arg[i]) {
						Date212 temp = arg[max];
						arg[max] = arg[i];
						arg[i] = temp;
					}
				}
			
		}
		return arg;
	}
	
	
}
