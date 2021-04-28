package com.umanizales.apipaseobarcos.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "barco", schema = "public", catalog = "batalla_naval")
public class BarcoEntity {
    private String codigo;
    private String nombre;
    private short casillas;
    private List<PaseoBarcoEntity> paseos;

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BarcoEntity that = (BarcoEntity) o;

        if (casillas != that.casillas) return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo != null ? codigo.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (int) casillas;
        return result;
    }

    @OneToMany(mappedBy = "barcoByBarco")
    public List<PaseoBarcoEntity> getPaseos() {
        return paseos;
    }

    public void setPaseos(List<PaseoBarcoEntity> paseos) {
        this.paseos = paseos;
    }
}
