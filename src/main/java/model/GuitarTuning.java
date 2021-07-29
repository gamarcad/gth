package model;

import java.util.*;

public class GuitarTuning implements Iterable<Note> {

    public List<Note> chordsTuning;


    public GuitarTuning( Note... notes ) {
        this.chordsTuning = Arrays.asList(notes.clone());
    }

    public int nbChords() {
        return this.chordsTuning.size();
    }

    @Override
    public Iterator<Note> iterator() {
        return chordsTuning.iterator();
    }

    public List<Note> getChordsTuning() {
        return this.chordsTuning;
    }

    public List<Note> getReversedChordsTuning() {
        ArrayList<Note> chordsTuning = new ArrayList<>(this.chordsTuning);
        Collections.reverse(chordsTuning);
        return chordsTuning;
    }
}
