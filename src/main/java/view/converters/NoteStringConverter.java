package view.converters;

import javafx.util.StringConverter;
import model.Note;

public class NoteStringConverter extends StringConverter<Note> {
    @Override
    public String toString(Note note) {
        return note.getName();
    }

    @Override
    public Note fromString(String s) {
        return null;
    }
}
