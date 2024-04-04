package ru.chembaev.spring.SensorAPI.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "Measurement")
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Size(min = -100, max = 100, message = "Value must be between -100 and 100")
    @Column(name = "value")
    private double value;

    @NotEmpty
    @Column(name = "raining")
    private boolean isRaining;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    @NotEmpty
    private Sensor sensor;

    public Measurement() {
    }

    public Measurement(double value, boolean isRaining, LocalDateTime createdAt) {
        this.value = value;
        this.isRaining = isRaining;
        this.createdAt = createdAt;
    }

    public Measurement(double value, boolean isRaining, LocalDateTime createdAt, Sensor sensor) {
        this.value = value;
        this.isRaining = isRaining;
        this.createdAt = createdAt;
        this.sensor = sensor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return isRaining;
    }

    public void setRaining(boolean raining) {
        isRaining = raining;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }


}
