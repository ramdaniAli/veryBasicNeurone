/**
 * 
 */
package perceptron;
import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;

/**
 * @author liabe
 * ==> on auras 3 variables x,y, z
 * ==> on auras 100 instances aleatoires ( 50 (0) et 50 (1) 
 * ==> on commance avec des poids et des seuils generer aleatoirement 
 * ==> on boucle les instances en ajustant les poids et les seuils , on continue la boucle jusqua la fin des iteration
 * 		ou jusqua a ce que les resultat soit satisfesant 
 *
 */
public class Demo {

	static int max_iter = 100 ; 
	static double apprenti = 0.1 ; 
	static int num_instance = 100 ; 
	static int theta = 0 ; 
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		/*
		 * variables 
		 */
		double [] x = new double [num_instance];
		double [] y = new double [num_instance];
		double [] z = new double [num_instance];
		int [] outputs = new int [num_instance];

		/*
		 * initialiser ceux qui ont comme valeur 1
		 */
		for (int i = 0; i < num_instance/2; i++) 
		{
			x [i] = randomNumber(5,10);
			y [i] = randomNumber(4,8);
			z [i] = randomNumber(2,9);
			outputs[i]=1;
			System.out.println(x[i]+"\t"+y[i]+"\t"+z[i]+"\t"+outputs[i]);
		}
		/*
		 * initialiser ceux qui ont comme valeur 0 
		 */
		for (int i = 50; i < num_instance; i++) 
		{
			x [i] = randomNumber(-1,3);
			y [i] = randomNumber(-4,2);
			z [i] = randomNumber(-3,5);
			outputs[i]=0;
			System.out.println(x[i]+"\t"+y[i]+"\t"+z[i]+"\t"+outputs[i]);
		}
		
		/*
		 * initialiser les poids et le seuil 
		 * 
		 */
		double [] weights = new double [4];
		double localError, globalError ; 
		int i , p, iteration , output ; 
		
		weights[0]=randomNumber(0,1); //w1 
		weights[1]=randomNumber(0,1); //w2
		weights[2]=randomNumber(0,1); //w3
		weights[3]=randomNumber(0,1); //valeur de seuil (bias) 
		
		iteration = 0 ; 
		
		do {
			iteration ++ ;
			globalError = 0 ; 
			for (p = 0; p < num_instance; p++) {
				/*
				 * calculer la prediction
				 */
				output = caluclateOutput(theta, weights, x[p], y[p],z[p]); 
				/*
				 * calcul d'erreur
				 */
				localError = outputs[p] - output ;
				/*
				 * ajustement
				 */
				weights[0] += apprenti * localError * x[p] ;
				weights[1] += apprenti * localError * y[p] ;
				weights[2] += apprenti * localError * z[p] ;
				weights[3] += apprenti * localError  ;
				
				globalError += (localError*localError);

			}
			
			System.out.println("itteration "+iteration+" : RMSE = "+Math.sqrt(globalError/num_instance));

		}while (globalError != 0 && iteration<=max_iter);
			
		System.out.println("\n========\nVecteur : ");
		System.out.println(weights[0] + "*X "+weights[1]+"*y "+weights[2]+"*z "+weights[3]+" = 0 ");
		
		for (int j = 0; j < 10; j++) 
		{
			double x1 = randomNumber(-10,10);
			double y1 = randomNumber(-10,10);
			double z1 = randomNumber(-10,10);
			output = caluclateOutput(theta, weights,x1,y1,z1);
			System.out.println("\n========\nNew Random point: ");
			System.out.println("x = "+x1+" ,y = "+y1+" ,z = "+z1);
			System.out.println("class = "+output);
		}
	}//end main 
	
	 static double randomNumber (int min , int max) {
		DecimalFormat df = new DecimalFormat("#.####");
		double d = min + Math.random()%-20+10;
		//String s = df.format(d); 
		//double x = Double.parseDouble(s);
		return d ; 
	}
	
	 static int caluclateOutput ( int theta , double weights[], double x, double y, double z ) {
		double sum = x * weights [0] + y * weights [1] + z * weights [2] + weights [3] ;
		return (sum >= theta) ? 1 : 0 ; 
	}

}
