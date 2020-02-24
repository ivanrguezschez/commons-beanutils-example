package com.irs.commonsbeanutilsexample.vo;

import java.util.Date;

/**
 * Clase VO que representa un usuario.
 * 
 * @author IRS
 * @version 1.0.0
 */
public class UsuarioVO {

    private Integer idUsuario;
    private String nif;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechaAlta;

    public UsuarioVO() {
        super();
        this.idUsuario = null;
        this.nif = null;
        this.nombre = null;
        this.apellido1 = null;
        this.apellido2 = null;
        this.fechaAlta = null;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("UsuarioVO{idUsuario=");
        sb.append(idUsuario);
        sb.append(", nif=");
        sb.append(nif);
        sb.append(", nombre=");
        sb.append(nombre);
        sb.append(", apellido1=");
        sb.append(apellido1);
        sb.append(", apellido2=");
        sb.append(apellido2);
        sb.append(", fechaAlta=");
        sb.append(fechaAlta);
        sb.append("}");
        
        return sb.toString();
    }
}
