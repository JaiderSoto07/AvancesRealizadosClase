package calculadorafracciones;

public class Calculadora {

	public static void main(String[] args) {
		
        Fraccion f1 = new Fraccion(2, 3);
        Fraccion f2 = new Fraccion(4, 5);

        Fraccion suma = f1.sumar(f2);

        System.out.println("Primera fracción: " + f1);
        System.out.println("Segunda fracción: " + f2);
        
        System.out.println("Resultado Suma");
        System.out.println("Resultado: " + suma);
        
        Fraccion resta = f1.restar(f2);
        
        System.out.println("Resultado Resta");
        System.out.println("Resultado: " + resta);
        
        Fraccion multiplicacion = f1.multiplicar(f2);
        
        System.out.println("Resultado Multiplicacion");
        System.out.println("Resultado: " + multiplicacion);
        
        Fraccion dividir = f1.dividir(f2);
        
        System.out.println("Resultado Division");
 
        System.out.println("Resultado: " + dividir);
        
        
  
	}

}
