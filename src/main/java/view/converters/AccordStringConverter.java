package view.converters;

import javafx.util.StringConverter;
import model.AccordType;

import java.util.Objects;

public class AccordStringConverter extends StringConverter<AccordType> {
    @Override
    public String toString(AccordType accordType) {
        if (Objects.isNull(accordType) ) {
            return "--";
        } else {
            return switch (accordType) {
                case POWERCHORD -> "Powerchord";
                case MAJOR -> "Major";
                case MINOR -> "Minor";
                case MINOR_7 -> "Minor 7";
                case MAJOR_7 -> "Major 7";
            };
        }

    }

    @Override
    public AccordType fromString(String s) {
        return null;
    }
}
