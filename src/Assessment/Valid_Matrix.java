package Assessment;

import java.util.Random;

public class Valid_Matrix {
	
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
		
	
		
		

	
	public static void main (String []args) {
		
		Random rand = new Random ();
		
		int no_cities=rand.nextInt(10+1);
		
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
		 
		
		 
		 System.out.println(valid_matrix(distance));
	}

}
