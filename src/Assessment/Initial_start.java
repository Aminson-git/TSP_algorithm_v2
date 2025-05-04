package Assessment;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Random;

public class Initial_start {

	
	public static ArrayList<Integer> initial_start(int n){
		
		
	if (n==0) {
		  return new ArrayList<>(); 
	}
	
	 Random rand=new Random();
	 
	 ArrayList<Integer>start_val=new ArrayList<>();
	int city_num=0;
	for( int i=0;i<n;i++) {

	 // in a random palce i.e city_num place the value of i 
	 // which is going to be equal to the number of cities
		start_val.add(i);
	}
	Collections.shuffle(start_val);
	
	
		return start_val;
		
	}
	
	
	
	public static void main (String[]args) {
		ArrayList<Integer>start_val=initial_start(10);
		
		
		
		for(int i=0;i<10;i++) {
			System.out.print(start_val.get(i)+ " ");
		}
		
		
	}
}
