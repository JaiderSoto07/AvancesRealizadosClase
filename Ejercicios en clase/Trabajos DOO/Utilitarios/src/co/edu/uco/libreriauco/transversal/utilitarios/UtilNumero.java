package co.edu.uco.libreriauco.transversal.utilitarios;

public class UtilNumero {
	
	public static int CERO = 0;
	
	public UtilNumero() {
		
	}
	
	public static <N extends Number > N obtenerValorDefecto (N valor, N valorDefecto){
		return UtilObjeto.obtenerValorDefectoSiNulo(valor, valorDefecto);
	}
	
	public static <N extends Number > Number obtenerValorDefecto (N valor){
		return UtilObjeto.obtenerValorDefectoSiNulo(valor, CERO );
	}
	
	public static <N extends Number > boolean mayorQue (N numeroUno,N numeroDos) {
		return obtenerValorDefecto(numeroUno).doubleValue() 
				> obtenerValorDefecto(numeroDos).doubleValue();
	}
	
	public static <N extends Number > boolean mayorIgualQue (N numeroUno,N numeroDos) {
		return obtenerValorDefecto(numeroUno).doubleValue() 
				>= obtenerValorDefecto(numeroDos).doubleValue();
	}
	
	public static <N extends Number > boolean menorQue (N numeroUno,N numeroDos) {
		return obtenerValorDefecto(numeroUno).doubleValue() 
				< obtenerValorDefecto(numeroDos).doubleValue();
	}
	
	public static <N extends Number > boolean menorIgualQue (N numeroUno,N numeroDos) {
		return obtenerValorDefecto(numeroUno).doubleValue() 
				<= obtenerValorDefecto(numeroDos).doubleValue();
	}
	
	public static <N extends Number > boolean Diferenteque (N numeroUno,N numeroDos) {
		return obtenerValorDefecto(numeroUno).doubleValue() 
				!= obtenerValorDefecto(numeroDos).doubleValue();
	}
	
	public static <N extends Number > boolean estaEntreIncluido (N numeroUno,N numeroDos, N valor) {
		return obtenerValorDefecto(numeroUno).doubleValue()>=valor.doubleValue() && obtenerValorDefecto(numeroDos).doubleValue()<=valor.doubleValue();
	}
	
	public static <N extends Number > boolean estaEntreNoIncluido (N numeroUno,N numeroDos, N valor) {
		return obtenerValorDefecto(numeroUno).doubleValue()>valor.doubleValue() && obtenerValorDefecto(numeroDos).doubleValue()<valor.doubleValue();
	}

}
