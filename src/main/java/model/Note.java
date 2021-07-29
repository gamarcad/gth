package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public enum Note {
    C( "C" ),
    C_DIESE( "C#" ),
    D( "D" ),
    D_DIESE( "D#" ),
    E( "E" ),
    F( "F" ),
    F_DIESE( "F#" ),
    G( "G" ),
    G_DIESE( "G#" ),
    A( "A" ),
    A_DIESE( "A#" ),
    B( "B" );

    private String name;

    public List<Note> getNotesBetweenNoteAndOffset( int numberOfhalfTons ) {
        Note currentNote = this;
        ArrayList<Note> result = new ArrayList<>();
        for ( int currentOffset = 1; currentOffset <= numberOfhalfTons; currentOffset++ ) {
            result.add(currentNote);
            currentNote = currentNote.offset(1);
        }
        return result;
    }

    public Note offset( int halfTonNumber ) {
        Note currentNote = this;
        for ( int currentOffset = 1; currentOffset <= halfTonNumber; currentOffset++ ) {
            currentNote = currentNote.nextNote();
        }
        return currentNote;
    }

    public Note nextNote() {
        switch (this) {
            case C: return C_DIESE;
            case C_DIESE: return D;
            case D: return D_DIESE;
            case D_DIESE: return E;
            case E: return F;
            case F: return F_DIESE;
            case F_DIESE: return G;
            case G: return G_DIESE;
            case G_DIESE: return A;
            case A: return A_DIESE;
            case A_DIESE: return B;
            case B: return C;
            default: throw new IllegalStateException("Note not found");
        }
    }
}
