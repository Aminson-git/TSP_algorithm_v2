package Assessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Final_soln {
	
	
	
		public static void main (String[]args) {
			
			Random rand = new Random ();
			
			//int no_cities=rand.nextInt(20+1);
			 int no_cities= 200;
			System.out.println("no of cities"+ no_cities);
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
			 }
			 
			 
			 
			 for(int i=0;i<distance.length;i++){
				 
				 System.out.println();
				 
				 for(int j=0;j<distance.length;j++){
					 System.out.print(distance[i][j]+" ");
					
				 }}
			 System.out.println();
			 
			 
			 
			// System.out.println(" Final tour "+Final_soln(10,distance,no_cities));
			
			
		}
	
	
	public static  int Final_soln(int ITER,int[][]distance,int no_cities) {
		
		
		// Checking the  given values for the algorithm
//		if((ITER<1)||no_cities<1) {
//			return null;
//		}
//		
//		if(valid_matrix(distance)==false) {
//			return null;
//		}
		
		
		 ArrayList<Integer> tour= initial_start(no_cities);
		 
		 int curr_fitness=fitnessFunction(tour, distance);
	
		 for (int i=0;i<ITER;i++) {
			 ArrayList<Integer> new_tour=smallChange(tour);
			 int new_fitness=fitnessFunction(new_tour,distance);
			 
			 if(new_fitness<curr_fitness) {
				 
				 //System.out.println("  is this"+new_fitness+" "+" was this"+curr_fitness);
				 curr_fitness=new_fitness;
				 
				 tour.containsAll(new_tour);
			 }

		 }
		 
		 
		 //System.out.println(curr_fitness);
		 
		

		return curr_fitness;
		
	}
	
	
	// Test the validity of the distance matrix given to us 
	public static  boolean valid_matrix(int [][]distance){
		
		if(distance ==null) {
			
			//System.out.println("1");
			return false;
		}
		
		for(int i=0;i<distance.length;i++) {
			// If the matrix is square i.e i==j
			
						// Taking length of the matrix  and then the
						//length of the row of the matrix
						
						if(distance.length != distance[i].length) {
							//System.out.println("2");
							return false;
						}
						// If the diagonal is 0 or not 
						
						// When ever i==i i.e i =1 , j= 1
						// Check for the value of distane[i][j]
						
							if(distance[i][i]!=0)
							{
								//System.out.println("3");
								return false;
							}				
		}
	
		
		for(int i=0;i<distance.length;i++) {
			for(int j =0; j<distance[i].length;j++) {

			
					// if the matrix is symmetric  and has only poritive value
					
					// checks if the values in distance[i][j] are same
					// as distance[j][i]
					
					// Also check if  the values are less than 0 which means  they
					// are negative
					
					if((distance[i][j]!=distance[j][i])||(distance[i][j]<0)) {
						//System.out.println("4");
						return false;
					}
				}
		
			}
		return true;
		}
	
	
	// Initial start to the  distance matrix
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
	
	
	//System.out.println("Initial start value "+start_val.toString());
	
		return start_val;
		
	}
		
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
		
		
		
		public static ArrayList<Integer> smallChange(ArrayList<Integer>currentTour){
			 if(currentTour==null) {
				 return null;
			 }
			 
			 
			 ArrayList<Integer>new_Tour=currentTour;
			 int n=currentTour.size()-1;
			 
			  Random rand = new Random();
			  int pos1=rand.nextInt(n+1);
			  int pos2=rand.nextInt(n+1);
			
	
			  //System.out.println("Switched positions: "+position+"  "+position2);
			  int temp = new_Tour.get(pos1);
			    new_Tour.set(pos1, new_Tour.get(pos2));
			    new_Tour.set(pos2, temp);

			  
			  
			  
			  //System.out.println("The changes made"+ currentTour);

				return new_Tour;
				
			}
	
	
	
	

}
