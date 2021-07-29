package view.wrappers;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import lombok.AllArgsConstructor;
import model.Accord;
import model.Gamma;
import model.Note;
import view.colors.NoteColorFactory;
import view.converters.NoteStringConverter;
import view.utils.TextPlacementModifier;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class GammaDescriptionGroupWrapper {
    private Group group;

    private static final float NOTE_START_X = 0;
    private static final float NOTE_START_Y = 0;
    private static final float NOTE_OFFSET = 60;
    private static final float NOTE_CHORD_RADIUS = 17f;
    private static final float NOTE_PLACEMENT_OFFSET_Y = 40f;

    public void drawNotesPlacementInGamma(Gamma gamma, Optional<Accord> accord) {
        clear();
        AtomicInteger noteIndex = new AtomicInteger(0);
        List<Note> usedNotes = gamma.getNotes();
        if (accord.isPresent()) {
            usedNotes = accord.get().getNotes();
        }
        
        addNote( usedNotes, gamma.getFundamental(), noteIndex.getAndIncrement(), "F" );
        addNote( usedNotes, gamma.getMinorSecond(), noteIndex.getAndIncrement(), "2m" );
        addNote( usedNotes, gamma.getMajorSecond(), noteIndex.getAndIncrement(), "2M" );
        addNote( usedNotes, gamma.getMinorTierce(), noteIndex.getAndIncrement(), "3m" );
        addNote( usedNotes, gamma.getMajorTierce(), noteIndex.getAndIncrement(), "3M" );
        addNote( usedNotes, gamma.getQuarte(), noteIndex.getAndIncrement(), "4" );
        addNote( usedNotes, gamma.getQuinte(), noteIndex.getAndIncrement(), "5" );
        addNote( usedNotes, gamma.getMinorSixte(), noteIndex.getAndIncrement(), "6m" );
        addNote( usedNotes, gamma.getMajorSixte(), noteIndex.getAndIncrement(), "6M" );
        addNote( usedNotes, gamma.getMinorSept(), noteIndex.getAndIncrement(), "7m" );
        addNote( usedNotes, gamma.getMajorSept(), noteIndex.getAndIncrement(), "7M" );
        addNote( usedNotes, gamma.getNine(), noteIndex.getAndIncrement(), "9" );
        addNote( usedNotes, gamma.getOctave(), noteIndex.getAndIncrement(), "Oc" );

    }

    public void clear() {
        this.group.getChildren().clear();
    }

    private void addNote(List<Note> usedNotes, Note note, int noteIndex, String gammaPlacement ) {


        Circle circle = new Circle();
        circle.setCenterX( NOTE_START_X + NOTE_OFFSET * noteIndex );
        circle.setCenterY( NOTE_START_Y );
        circle.setRadius(NOTE_CHORD_RADIUS);
        group.getChildren().add(circle);
        final Color noteColor = NoteColorFactory.getColorOfNote(note);
        if (usedNotes.contains(note)) {
            circle.setFill(noteColor);
        } else {
            circle.setStroke(noteColor);
            circle.setFill(Color.WHITE);
        }

        NoteStringConverter noteStringConverter = new NoteStringConverter();
        Text noteName = new Text( noteStringConverter.toString(note) );
        noteName.setX( NOTE_START_X + NOTE_OFFSET * noteIndex );
        TextPlacementModifier.centerText(noteName);
        group.getChildren().add(noteName);
        if (usedNotes.contains(note)) {
            noteName.setFill(Color.WHITE);
        } else {
            noteName.setFill(noteColor);
        }

        Text gammaPlacementText = new Text( gammaPlacement );
        gammaPlacementText.setX( NOTE_START_X + NOTE_OFFSET * noteIndex );
        gammaPlacementText.setY(NOTE_PLACEMENT_OFFSET_Y);
        TextPlacementModifier.centerText(gammaPlacementText);
        group.getChildren().add(gammaPlacementText);
    }
}
