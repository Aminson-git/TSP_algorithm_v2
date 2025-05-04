package Assessment;

import java.util.*;

public class valid_tour {
	
	public static boolean valid_tour(ArrayList<Integer> tour, int[][]distance)
	{
		if(tour==null||distance==null) {
			return false;
		}
		if(tour.size()!=distance.length)
		{
			return false;
		}
		
		
		Set<Integer>citySet=new HashSet<>(tour);
		for(int i=0;i<tour.size();i++) {
			if(!citySet.contains(i)) {
				return false;
			}
			
		}
		
		return true;
		
	}
	
	public static void main(String[]args) {
		
		Random rand = new Random ();
		
		int no_cities=rand.nextInt(10+1);
		
		//System.out.println("no of cities"+ no_cities);
		
		 int [][] distance =new int [no_cities][no_cities];
		 
		 
		 for(int i=0;i<distance.length;i++){
			 
			
				
			
			 for(int j=0;j<distance.length;j++){
				 
				 int cost=Math.abs(rand.nextInt(100+1));
				 
				 
				 if(i==j) {
					 distance[i][j]=0;
				 }
				 else {
					 distance[i][j]=cost;
					 distance[j][i]=cost;
				 }
				
					 
					 
				 
			 }
			 
			 
			
			 
			 ArrayList<Integer> tour= Initial_start.initial_start(no_cities);
			 
			 
			 System.out.println(valid_tour(tour,distance));
			 
		 }
	}
}
