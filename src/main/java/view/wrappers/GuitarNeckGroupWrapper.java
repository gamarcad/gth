package view.wrappers;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import model.Accord;
import model.Gamma;
import model.GuitarTuning;
import model.Note;
import view.colors.NoteColorFactory;

import java.util.List;

import static view.utils.TextPlacementModifier.centerText;

public class GuitarNeckGroupWrapper {

    private static final float CHORD_OFFSET = 50f;
    private static final float CHORD_START_X = 0f;
    private static final float CHORD_START_Y = 0f;
    private static final int NB_CHORD_CASES = 12;
    private static final float CASE_OFFSET = 60f;
    private static final float NOTE_CHORD_RADIUS = 17f;
    private static final float CASE_INDEX_Y_OFFSET = 30f;

    private Group group;
    private GuitarTuning guitarTuning;


    public GuitarNeckGroupWrapper( Group group, GuitarTuning guitarTuning){
        this.group = group;
        this.guitarTuning = guitarTuning;
    }

    public void drawGuitarNeck() {
        final int nbChords = guitarTuning.nbChords();
        final float chordLength = CASE_OFFSET * NB_CHORD_CASES;
        for ( int chordIndex = 0; chordIndex < nbChords; chordIndex++ ) {
            Line chordDrawing = new Line();
            chordDrawing.setStartX(CHORD_START_X);
            chordDrawing.setStartY(CHORD_START_Y + CHORD_OFFSET * chordIndex);
            chordDrawing.setEndX(chordDrawing.getStartX() + chordLength);
            chordDrawing.setEndY(chordDrawing.getStartY());
            this.group.getChildren().add(chordDrawing);
        }

        // draw cases number
        for ( int currentCase = 0; currentCase <= NB_CHORD_CASES; currentCase++ ) {
            Text text = new Text(String.valueOf(currentCase));
            text.setX( CHORD_START_X + currentCase * CASE_OFFSET );
            text.setY(CHORD_START_Y - CASE_INDEX_Y_OFFSET);
            centerText(text);
            this.group.getChildren().add(text);
        }
    }

    public void drawGamma(Gamma gamma) {
        // TODO optimize
        this.clear();
        this.drawGuitarNeck();
        this.drawNotesOnNeck(gamma.getNotes());
    }

    public void drawAccord(Accord accord) {
        // TODO optimize
        this.clear();
        this.drawGuitarNeck();
        this.drawNotesOnNeck(accord.getNotes());
    }

    public void drawNotesOnNeck( final List<Note> displayedNotes ){
        int chordIndex = 0;
        final List<Note> guitarTuningNotes = this.guitarTuning.getReversedChordsTuning();
        for (final Note chordTuning : guitarTuningNotes){
            int caseIndex = 0;
            List<Note> chordNotes = chordTuning.getNotesBetweenNoteAndOffset(NB_CHORD_CASES + 1);
            for ( Note currentNote : chordNotes ) {
                if ( displayedNotes.contains(currentNote) ) {
                    // draws circle corresponding to the current note
                    Circle circle = new Circle();
                    circle.setCenterX( caseIndex * CASE_OFFSET );
                    circle.setCenterY( chordIndex * CHORD_OFFSET );
                    circle.setRadius(NOTE_CHORD_RADIUS);
                    circle.setFill(this.getColorOfNote(currentNote));

                    Text text = new Text( currentNote.getName() );
                    text.setX( caseIndex * CASE_OFFSET);
                    text.setY( chordIndex * CHORD_OFFSET );
                    text.setFill(Color.WHITE);
                    centerText(text);
                    group.getChildren().add(circle);
                    group.getChildren().add(text);
                }

                caseIndex++;
            }

            chordIndex++;
        }
    }

    public void clear() {
        this.group.getChildren().clear();
    }


    private Color getColorOfNote( Note note ) {
        return NoteColorFactory.getColorOfNote(note);
    }

}
