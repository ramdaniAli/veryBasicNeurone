/**
 * 
 */
package simple;

/**
 * @author liabe
 *
 */
public class Neuron {
	
	final double x1 ,x2 ,v1, b , w1 ,w2 ,w3 ;

	/**
	 * @param x1
	 * @param x2
	 * @param b
	 * @param w1
	 * @param w2
	 * @param w3
	 */
	public  Neuron(double x1, double x2, double v1 , double b, double w1, double w2, double w3) {
		this.x1 = x1;
		this.x2 = x2;
		this.v1 = v1 ; 
		this.b = b;
		this.w1 = w1;
		this.w2 = w2;
		this.w3 = w3;
	} 
	
	
	public double getY() 
	{
		double y = 1 ; 
		double wx ; 
		wx = (b*w3) + (x1 * w1) + (x2 * w2) ;
		
		if (wx < 0 ) 
		{
			y = 0 ; 
		}
		
		return y ; 
	}
	
	public double err(double var) 
	{ 
		double e ; 
		e = var - getY() ; 
		return e ; 
	}

	
}
