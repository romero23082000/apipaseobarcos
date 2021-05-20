package com.umanizales.apipaseobarcos.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "barco", schema = "public", catalog = "batalla_naval")
public class BarcoEntity {
    private String codigo;
    private String nombre;
    private short casillas;



    @Id
    @Column(name = "codigo", nullable = false, length = 10)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 20)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "casillas", nullable = false)
    public short getCasillas() {
        return casillas;
    }

    public void setCasillas(short casillas) {
        this.casillas = casillas;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof String){
            if (o.toString().equals(this.codigo)){
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = codigo != null ? codigo.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (int) casillas;
        return result;
    }

    @Override
    public String toString() {
        return "BarcoEntity{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", casillas=" + casillas +
                '}';
    }
}
