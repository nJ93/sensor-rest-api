package ru.chembaev.spring.SensorAPI.util.exceptions;

public class MeasurementError extends RuntimeException {
    public MeasurementError(String message) {
        super(message);
    }
}
