package Assessment;

import java.util.ArrayList;
import java.util.Random;

public class SmallChanageOperator {

	
	public static ArrayList<Integer> smallChange(ArrayList<Integer>currentTour){
	 if(currentTour==null) {
		 return null;
	 }
	 
	 int n=currentTour.size()-1;
	 
	  Random rand = new Random();
	  int position=rand.nextInt(n+1);
	  int position2=rand.nextInt(n+1);
	 
	  
	  // Value at the interested positions
	  
	  int val1=currentTour.get(position);
	  int val2=currentTour.get(position2);
	  
	  
	  System.out.println("Switched positions: "+position+"  "+position2);
	  currentTour.set(position,val2);
	  currentTour.set(position2, val1);

		return currentTour;
		
	}
	
	public static void main(String[]args) {
	
		 ArrayList<Integer> tour= Initial_start.initial_start(10);
		System.out.println("Initial tour"+ tour.toString());
		 
		 System.out.println(smallChange(tour));
		 
		 
		
	}
	
	
	
}
