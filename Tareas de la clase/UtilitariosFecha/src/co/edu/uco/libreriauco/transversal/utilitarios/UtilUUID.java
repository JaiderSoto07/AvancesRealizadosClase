package co.edu.uco.libreriauco.transversal.utilitarios;

import java.util.UUID;

public class UtilUUID {
	

    public static UUID generar() {
        return UUID.randomUUID();
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
