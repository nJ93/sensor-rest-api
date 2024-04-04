package ru.chembaev.spring.SensorAPI.dto;

import ru.chembaev.spring.SensorAPI.models.Sensor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MeasurementDTO {
    @NotEmpty
    @Size(min = -100, max = 100, message = "Value must be between -100 and 100")
    private double value;

    @NotEmpty
    private boolean isRaining;

    @NotEmpty
    private Sensor sensor;

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

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
