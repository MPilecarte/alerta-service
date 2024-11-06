package br.com.fiap.alertaDesastres.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


@Entity
@Table(name = "tbl_alertas")
public class Alerta {


    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ALERTAS_SEQ"
    )
    @SequenceGenerator(
            name = "ALERTAS_SEQ",
            sequenceName = "ALERTAS_SEQ",
            allocationSize = 50
    )
    private Long id;
    private LocalDate data;
    private LocalTime hora;

    @Column(name = "nivel_risco")
    private String nivelRisco;

    @Column(name = "sensor_id")
    private Long sensorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getNivelRisco() {
        return nivelRisco;
    }

    public void setNivelRisco(String nivelRisco) {
        this.nivelRisco = nivelRisco;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alerta alerta = (Alerta) o;
        return Objects.equals(id, alerta.id) && Objects.equals(data, alerta.data) && Objects.equals(hora, alerta.hora) && Objects.equals(nivelRisco, alerta.nivelRisco) && Objects.equals(sensorId, alerta.sensorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, hora, nivelRisco, sensorId);
    }
}
