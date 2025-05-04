package Assessment;

import java.util.ArrayList;
import java.util.Random;

public class FitnessFunction {
	
	
	public static int fitnessFunction(ArrayList<Integer> tour, int[][]distance)
	{
		if(tour==null||distance==null) {
			return 0;
		}
		if(tour.size()!=distance.length)
		{
			return 0;
		}
		
		 int fitness=0;
		 
		 int n=tour.size();
		 
		
		 
		
		
		for(int i=1;i<n;i++) {
			
	
			
			fitness= fitness+ distance[tour.get(i-1)][tour.get(i)];
			
			
			
			
		}
	
		return fitness;
		
	}
	
	public static void main(String[]args) {
		
		Random rand = new Random ();
		
		int no_cities=rand.nextInt(1000+1);
		
		ArrayList<Integer> tour= Initial_start.initial_start(no_cities);
		
		//System.out.println("no of cities"+ no_cities);
		
		 int [][] distance =new int [no_cities][no_cities];
		 
		 
		 for(int i=0;i<distance.length;i++){
			
			 for(int j=0;j<distance.length;j++){
				 
				 int cost=Math.abs(rand.nextInt(10+1));
				 
				 
				 if(i==j) {
					 distance[i][j]=0;
				 }
				 else {
					 distance[i][j]=cost;
					 distance[j][i]=cost;
				 }
		
			 }
		
		 }
		
		 
		 
		 System.out.println("--------------------- The distance matrix------------------");
		 for(int i=0;i<distance.length;i++){
			 
			 System.out.println();
			 
			 for(int j=0;j<distance.length;j++){
				 System.out.print(distance[i][j]+" ");
				
			 }}
		 System.out.println();
		 System.out.println("---------------------------------------------------------");
		 
		 
		 System.out.println(" The initial tour"+tour.toString());
		 
		 System.out.println("Fitness of the solution:"+fitnessFunction(tour,distance));
	
	
	
	
}}
