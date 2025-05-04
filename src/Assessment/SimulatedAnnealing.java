import java.util.ArrayList;
import java.util.Random;
import Assessment.Final_soln;
public class SimulatedAnnealing {

	
	//Starting temperature
	
	//No of iteration// given by the user
	
	//Acceptance method
	
	
	
	public static double finalSoln(int ITER) {
		
		double T_o=1003; //Initial temperature
		double T_final = 0.001; //final temperature set to be as low as possible
		
		int iter = ITER; //no of iteration given to us as parameter
		double col_rate=Math.pow(T_final/T_o,1.0/iter); //  cooling rate 
		
		System.out.println("Cooling rate of the algo:"+ col_rate);
		
		int n_cities=10000;
		
		System.out.println("Cities-->" + n_cities);
		
		ArrayList<Integer> tour=initial_start(n_cities);//intial tour for the solution
		
		int [][] distance =new int [n_cities][n_cities];// distance matrix
			
		 for(int i=0;i<distance.length;i++){
	
			 for(int j=0;j<distance.length;j++){
				 
				 int cost=rand(100);//distance is anywhere between 0-100
				 
				 
				 if(i==j) {
					 distance[i][j]=0;
				 }
				 else {
					 distance[i][j]=cost;
					 distance[j][i]=cost;
				 }
			 } 
		 }
		double fitness =fitnessfunction(distance,tour);//initial fitness
		 double T_curr = T_o;

		for(int i =0; i<iter; i++) {
			 T_curr *=  col_rate;//Current temp changes as per the iteration	
			//System.out.println(i+" "+T_curr);
			ArrayList<Integer> new_arr=smallChange(tour);
			double new_fitness =fitnessfunction(distance,new_arr);	
			
			if(acceptor(fitness,new_fitness,T_curr)== true) {
				tour=new_arr;
				fitness =new_fitness;
			}
		}
		
		System.out.println(" RMHC-->"+Final_soln.Final_soln(iter, distance, n_cities));
		
		return fitness;
	}
	
	public static int rand(int x) {
		
		//Class to generate random number for cities, cost/ distance
		// Takes in a upper bound to generate number between 0 upto that upper bound
		Random rand = new Random();
		
		
		int val=Math.abs(rand.nextInt(x+1)); // so for everything get value x
		return val;
	}
	
	
	public static ArrayList<Integer> initial_start(int n) {
		
		// Done using Fisher Yate's swap
		
		
		int []tour = new int[n];
		
		for(int i=0;i<n;i++) tour[i]=i; // This is silly way of permutaion as i is also 
										// repeated and the value of the cities must me unrepeated
		
		for(int i=n-1;i>0;i--) { //?? why is this -2 
			int j=rand(n-1);
			int temp=tour[i];
			tour[i]=tour[j];
			tour[j]=temp;
			
			
		}
		// There is a chance the we must need array list
		ArrayList<Integer> tour_fin= new ArrayList <>();
		for(int i=0;i<n;i++) {
			
			tour_fin.add(tour[i]);  
		}
		
		//return tour;
		return tour_fin;
	}
	
	public static double fitnessfunction(int [][]distance, ArrayList<Integer> tour) {
		//Because we get a integer array well convert it to arrayist 
		// just for convinienve though
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
		 
		 int n=currentTour.size()-1;
		 
		  Random rand = new Random();
		  int position=rand.nextInt(n+1);
		  int position2=rand.nextInt(n+1);
		 
		  
		  // Value at the interested positions
		  
		  int val1=currentTour.get(position);
		  int val2=currentTour.get(position2);
		  
		  
		 // System.out.println("Switched positions: "+position+"  "+position2);
		  currentTour.set(position,val2);
		  currentTour.set(position2, val1);

			return currentTour;
			
		}
	
	
	private static Boolean acceptor(double x, double y,double z) {
		
		
		double fitness1=x;
		double fitness2=y;
		
		double curr_temp=z;
		
		
		Boolean result = true;
		double acceptance=Math.exp((fitness2-fitness1)/curr_temp) ;	
		if(fitness2<fitness1 || (Math.random()<acceptance)) {
			result = true;
		}
		
		return result;
		
	}
	
	public static void main(String[]args) {
		
		System.out.println("SimulatedAnnealing-->"+finalSoln(1000));
		 
		
	}
	}

