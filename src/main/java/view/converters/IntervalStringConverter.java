package view.converters;

import javafx.util.StringConverter;
import model.Interval;

public class IntervalStringConverter extends StringConverter<Interval> {
    @Override
    public String toString(Interval interval) {
        return switch (interval) {
            case MAJOR -> "Major";
            case HARMONIC_MINOR -> "Harmonic Minor";
            case MELODOC_MINOR -> "Melodic Minor";
            case PENTATONIC_MAJOR -> "Pentatonic Major";
            case PENTATONIC_MINOR -> "Pentatonic Minor";
        };
    }

    @Override
    public Interval fromString(String s) {
        return null;
    }
}
