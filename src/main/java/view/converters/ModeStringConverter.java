package view.converters;

import javafx.util.StringConverter;
import model.Mode;

public class ModeStringConverter extends StringConverter<Mode> {
    @Override
    public String toString(Mode mode) {
        return switch (mode) {
            case MODE_INITIAL -> "--";
            case MODE_DORIEN -> "Dorien";
            case MODE_PHRYGIEN -> "Phrygien";
            case MODE_LYDIEN -> "Lydien";
            case MODE_MIXOLYDIEN -> "Mixolydien";
            case MODE_EOLIEN -> "Eolien";
            case MODE_LOCRIEN -> "Locrien";
        };
    }

    @Override
    public Mode fromString(String s) {
        return null;
    }
}
