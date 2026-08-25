package co.edu.uco.libreriauco.transversal.utilitarios;

import java.util.UUID;


public class PruebaUtilUUID {

	public static void main(String[] args) {

        UUID identificador = UtilUUID.generar();

        System.out.println("UUID generado:");
        System.out.println(identificador);

        System.out.println();

        System.out.println("¿El UUID es nulo?");
        System.out.println(UtilUUID.esNulo(identificador));

        System.out.println();

        String uuidTexto = identificador.toString();

        System.out.println("UUID como texto:");
        System.out.println(uuidTexto);

        System.out.println();

        System.out.println("¿El texto es un UUID válido?");
        System.out.println(UtilUUID.esValido(uuidTexto));

        System.out.println();

        System.out.println("¿12345 es un UUID válido?");
        System.out.println(UtilUUID.esValido("12345"));
    }
}
