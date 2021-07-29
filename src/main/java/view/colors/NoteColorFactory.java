package view.colors;

import javafx.scene.paint.Color;
import model.Note;

import java.util.HashMap;
import java.util.Map;

public class NoteColorFactory {
    private static final Map<Note, Color> noteColors;
    
    static {
        noteColors = new HashMap<>();
        noteColors.put(Note.C, Color.RED);
        noteColors.put(Note.C_DIESE, Color.DARKORANGE);
        noteColors.put(Note.D, Color.CHOCOLATE);
        noteColors.put(Note.D_DIESE, Color.DARKOLIVEGREEN);
        noteColors.put(Note.E, Color.GREEN);
        noteColors.put(Note.F, Color.GRAY);
        noteColors.put(Note.F_DIESE, Color.FIREBRICK);
        noteColors.put(Note.G, Color.STEELBLUE);
        noteColors.put(Note.G_DIESE, Color.YELLOWGREEN);
        noteColors.put(Note.A, Color.DARKSALMON);
        noteColors.put(Note.A_DIESE, Color.PERU);
        noteColors.put(Note.B, Color.VIOLET);
    }

    public static Color getColorOfNote( Note note ) {
        return noteColors.get(note);
    }
}
