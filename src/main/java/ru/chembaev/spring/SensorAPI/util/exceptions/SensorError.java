package ru.chembaev.spring.SensorAPI.util.exceptions;

public class SensorError extends RuntimeException {
    public SensorError(String message) {
        super(message);
    }
}
