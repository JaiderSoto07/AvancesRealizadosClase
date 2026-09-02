package co.edu.uco.libreriauco.entidad;

import java.util.UUID;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class CiudadEntidad {

    private UUID id;
    private String nombre;
    private DepartamentoEntidad departamento;

    private CiudadEntidad(UUID id, String nombre, DepartamentoEntidad departamento) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    private CiudadEntidad(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.departamento = builder.departamento;
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public DepartamentoEntidad getDepartamento() {
        return departamento;
    }

    public static class Builder {

        private UUID id;
        private String nombre;
        private DepartamentoEntidad departamento;

        public Builder() {
            id = UtilUUID.obtenerValorDefecto(id);
            nombre = UtilTexto.VACIO;
            departamento = new DepartamentoEntidad.Builder().Build();
        }

        public Builder id(UUID id) {
            this.id = UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
            return this;
        }

        public Builder departamento(DepartamentoEntidad departamento) {
            this.departamento = UtilObjeto.obtenerValorDefectoSiNulo(
                    departamento, new DepartamentoEntidad.Builder().Build());
            return this;
        }

        public CiudadEntidad Build() {
            return new CiudadEntidad(this);
        }
    }
}