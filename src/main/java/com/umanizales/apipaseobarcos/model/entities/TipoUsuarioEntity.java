package com.umanizales.apipaseobarcos.model.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@Entity
@Table(name = "tipo_usuario", schema = "public", catalog = "batalla_naval")
public class TipoUsuarioEntity {
    private short codigo;
    private String descripcion;



    @Id
    @Column(name = "codigo", nullable = false)
    public short getCodigo() {
        return codigo;
    }

    public void setCodigo(short codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "descripcion", nullable = false)


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoUsuarioEntity that = (TipoUsuarioEntity) o;

        if (codigo != that.codigo) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = (int) codigo;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }
}
