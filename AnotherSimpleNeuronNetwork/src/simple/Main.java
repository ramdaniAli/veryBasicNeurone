/**
 * 
 */
package simple;

import java.util.Random;

/**
 * @author liabe
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * INPUTS
		 */
		double x1 =  0.1 ;
		double x2 = 1 ;
		double b = 1 ; 
		
		double v1 = 1 ; 
		
		double w1 = new Random().nextDouble() ;
		double w2 = new Random().nextDouble() ;
		double w3 = new Random().nextDouble();
		
		boolean test = true ; 
		

		
		Neuron n = new Neuron(b, x1, x2 ,v1 , w1, w2, w3);
		
		while (test) 
		{
			
			for (int i = 0; i < 1001; i++) {
				
				 w1 =+ 0.3* n.err(v1-n.getY());
				 w2 =+ 0.3* n.err(v1 - n.getY()) * v1;
				 w3 =+ 0.3* n.err(v1- n.getY())*v1;
				 
					System.out.println("INPUT 1 : " + x1);
					System.out.println("INPUT 2 : " + x2);
					System.out.println("OUTPUT DEF : " + v1);
					System.out.println("OUTPUT : " + n.getY());
					System.out.println("OUTPUT Calcule d'erreur :" + n.err(v1));
					
					if ( i == 1000 ) {
						test = false ;
					}
			}
			
		
		}
		
	}

}
