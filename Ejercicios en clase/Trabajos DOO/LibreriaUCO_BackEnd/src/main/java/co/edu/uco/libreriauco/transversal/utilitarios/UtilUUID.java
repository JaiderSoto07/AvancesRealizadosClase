package co.edu.uco.libreriauco.transversal.utilitarios;

import java.time.Instant;
import java.util.UUID;

public class UtilUUID {
	
	public static UUID UUID_DEFECTO = new UUID(0L, 0L);
	
	public static UUID obtenerValorDefecto(UUID id, UUID idDefecto){
		return UtilObjeto.obtenerValorDefectoSiNulo(id, idDefecto);
	}
	
	public static UUID obtenerValorDefecto(UUID id){
		return UtilObjeto.obtenerValorDefectoSiNulo(id, UUID_DEFECTO);
	}

    public static boolean esNulo(UUID identificador) {
        return identificador == null;
    }
    
    public static UUID generar() {
        return UUID.ofEpochMillis(Instant.now().toEpochMilli());
    }
    
    public static String generarComoTexto() {
        return UUID.randomUUID().toString();
    }
    

    public static boolean esValido(String identificador) {

        if (identificador == null || identificador.isBlank()) {
            return false;
        }

        try {
            UUID.fromString(identificador);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
