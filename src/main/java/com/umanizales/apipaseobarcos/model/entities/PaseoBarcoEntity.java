package com.umanizales.apipaseobarcos.model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "paseo_barco", schema = "public", catalog = "batalla_naval")
public class PaseoBarcoEntity {
    private int id;
    private Date fecha;
    private BarcoEntity barcoByBarco;
    private UsuarioEntity paseador;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fecha", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaseoBarcoEntity that = (PaseoBarcoEntity) o;

        if (id != that.id) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "barco", referencedColumnName = "codigo", nullable = false)
    public BarcoEntity getBarcoByBarco() {
        return barcoByBarco;
    }

    public void setBarcoByBarco(BarcoEntity barcoByBarco) {
        this.barcoByBarco = barcoByBarco;
    }

    @ManyToOne
    @JoinColumn(name = "jugador", referencedColumnName = "id", nullable = false)
    public UsuarioEntity getPaseador() {
        return paseador;
    }

    public void setPaseador(UsuarioEntity paseador) {
        this.paseador = paseador;
    }
}
