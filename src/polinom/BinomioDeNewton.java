package polinom;

public class BinomioDeNewton
{
	int n;
	double a, b;
	
	public BinomioDeNewton (int n, double a, double b)
	{
		this.n = n;
		this.a = a;
		this.b = b;
	}
	
	private double obtenerCoeficiente (int k)
	{
		if (k > this.n + 1 || k < 1)
			throw new ArithmeticException("no se puede obtener el k-ésimo coeficiente: valor de k no válido");
		
		//k = this.n - k;
		int[] coeficientes = new int[k + 1];
		
		coeficientes[0] = 1;
		
		for (int i = 1; i <= this.n; i++)
		{
			for (int j = Math.min(i, k); j > 0; j--)
				coeficientes[j] += coeficientes[j - 1];
		}
		
		return coeficientes[k - 1] * Math.pow(this.a, n - k + 1) * Math.pow(this.b, k - 1);
	}
	
	public double evaluarBinomio (double x)
	{
		double[] coeficientes = new double[this.n + 1];
		
		for (int i = 1; i <= coeficientes.length; i++)
		{
			System.out.println("Coef " + i + ": " + obtenerCoeficiente(i));
			coeficientes[i - 1] = obtenerCoeficiente(i);
		}
		
		return new Polinomio(coeficientes).evaluarMejorada(x);
	}
}
