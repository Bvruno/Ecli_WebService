package webservice;

public class Operaciones {
	public int suma (int a,int b) {
		return a+b;
	}
	public int resta (int a,int b) {
		return a-b;
	}
	public int division (int a,int b) {
		return a/b;
	}
	public int multiplicacion (int a,int b) {
		return a*b;
	}
	
	public String calcularPago(
			String nombre, 
			double precio, 
			double descuento, 
			int cantidad) 
	{
		final double IGV = 0.18;
		double pago = precio*cantidad - precio*descuento*cantidad*IGV;
		return "El pago de "+nombre+" es de "+pago+" Soles";
	}
	
}
