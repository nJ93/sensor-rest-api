package ru.chembaev.spring.SensorAPI.util.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.chembaev.spring.SensorAPI.models.Measurement;
import ru.chembaev.spring.SensorAPI.services.SensorService;

@Component
public class MeasurementsValidator implements Validator {
    private final SensorService sensorService;

    public MeasurementsValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Measurement.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Measurement measurement = (Measurement) o;

        if (sensorService.findByName(measurement.getSensor().getName()).isEmpty()) {
            errors.rejectValue("Sensor", "", "Sensor with this name was not found");
        }
    }
}
