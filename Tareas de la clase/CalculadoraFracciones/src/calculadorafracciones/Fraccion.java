package calculadorafracciones;

public class Fraccion {
	
	private int numerador;
	private int denominador;
	
	public Fraccion(int numerador, int denominador) {
		 if (denominador == 0) {
	            throw new IllegalArgumentException("El denominador no puede ser cero.");
	        }
		
	    this.numerador = numerador;
	    this.denominador = denominador;
	}
	
	
	public Fraccion sumar(Fraccion otra) {

	    int nuevoNumerador = this.numerador * otra.denominador
	                       + otra.numerador * this.denominador;

	    int nuevoDenominador = this.denominador * otra.denominador;

	    Fraccion resultado = new Fraccion(
	        nuevoNumerador,
	        nuevoDenominador
	    );

	    resultado.simplificar();

	    return resultado;
	}
	
	public Fraccion restar(Fraccion otra) {
	    int nuevoNumerador = this.numerador * otra.denominador
	                       - otra.numerador * this.denominador;

	    int nuevoDenominador = this.denominador * otra.denominador;

	    Fraccion resultado = new Fraccion(
	            nuevoNumerador,
	            nuevoDenominador
	        );

	        resultado.simplificar();
	    
	        return resultado;
	    
	    
	    
	}
	
	public Fraccion multiplicar(Fraccion otra) {
	    int nuevoNumerador = this.numerador * otra.numerador;
	    int nuevoDenominador = this.denominador * otra.denominador;

	    Fraccion resultado = new Fraccion(
	            nuevoNumerador,
	            nuevoDenominador
	        );

	        resultado.simplificar();

	        return resultado;
	}
	
	public Fraccion dividir(Fraccion otra) {

	    if (otra.numerador == 0) {
	        throw new ArithmeticException(
	            "No se puede dividir entre cero."
	        );
	    }

	    int nuevoNumerador = this.numerador * otra.denominador;
	    int nuevoDenominador = this.denominador * otra.numerador;

	    Fraccion resultado = new Fraccion(
	        nuevoNumerador,
	        nuevoDenominador
	    );

	    resultado.simplificar();

	    return resultado;
	}
	
	
	private int mcd(int a, int b) {

	    a = Math.abs(a);
	    b = Math.abs(b);

	    while (b != 0) {
	        int temporal = b;
	        b = a % b;
	        a = temporal;
	    }

	    return a;
	}
	
	public void simplificar() {

	    if (numerador == 0) {
	        denominador = 1;
	        return;
	    }

	    int divisor = mcd(numerador, denominador);

	    numerador = numerador / divisor;
	    denominador = denominador / divisor;

	    if (denominador < 0) {
	        numerador = -numerador;
	        denominador = -denominador;
	    }
	}
	
	@Override
	public String toString() {
	    return numerador + "/" + denominador;
	}

}
