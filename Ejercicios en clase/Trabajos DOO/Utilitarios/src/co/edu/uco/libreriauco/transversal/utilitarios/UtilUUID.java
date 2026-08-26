package co.edu.uco.libreriauco.transversal.utilitarios;

import java.util.UUID;

public class UtilUUID {
	
	public static UUID UUID_DEFECTO = new UUID(0L, 0L);

	public static UUID generar() {
        return UUID.randomUUID();
    }
	
	public static UUID obtenerValorDefecto(UUID id, UUID idDefecto){
		return UtilObjeto.obtenerValorDefectoSiNulo(id, idDefecto);
	}
	
	public static UUID obtenerValorDefecto(UUID id){
		return UtilObjeto.obtenerValorDefectoSiNulo(id, UUID_DEFECTO);
	}

    public static boolean esNulo(UUID identificador) {
        return identificador == null;
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
