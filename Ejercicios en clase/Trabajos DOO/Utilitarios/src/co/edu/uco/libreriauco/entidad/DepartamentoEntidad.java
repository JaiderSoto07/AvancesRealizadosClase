package co.edu.uco.libreriauco.entidad;

import java.util.UUID;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class DepartamentoEntidad {

    private UUID id;
    private String nombre;
    private PaisEntidad pais;

    private DepartamentoEntidad(UUID id, String nombre, PaisEntidad pais) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
    }

    private DepartamentoEntidad(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.pais = builder.pais;
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public PaisEntidad getPais() {
        return pais;
    }

    public static class Builder {

        private UUID id;
        private String nombre;
        private PaisEntidad pais;

        public Builder() {
            id = UtilUUID.obtenerValorDefecto(id);
            nombre = UtilTexto.VACIO;
            pais = new PaisEntidad.Builder().Build();
        }

        public Builder id(UUID id) {
            this.id = UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
            return this;
        }

        public Builder pais(PaisEntidad pais) {
            this.pais = UtilObjeto.obtenerValorDefectoSiNulo(
                    pais, new PaisEntidad.Builder().Build());
            return this;
        }

        public DepartamentoEntidad Build() {
            return new DepartamentoEntidad(this);
        }
    }
}