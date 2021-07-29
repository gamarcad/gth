package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
public class Gamma implements Iterable<Note> {
    private Note fundamental;
    private Interval interval;
    private Mode mode;

    public Gamma( Note fundamental, Interval interval ) {
        this( fundamental, interval, Mode.MODE_INITIAL );
    }

    public Gamma( Note fundamental, Interval interval, Mode mode ) {
        this.fundamental = fundamental;
        this.interval = interval;
        this.mode = mode;
    }

    public Note getFundamental() { return this.fundamental.offset(mode.getOffset()); }
    public Note getMinorSecond() { return this.fundamental.offset(mode.getOffset() + 1); }
    public Note getMajorSecond() { return this.fundamental.offset(mode.getOffset() + 2); }
    public Note getMinorTierce() { return this.fundamental.offset(mode.getOffset() + 3); }
    public Note getMajorTierce() { return this.fundamental.offset(mode.getOffset() + 4); }
    public Note getQuarte() { return this.fundamental.offset(mode.getOffset() + 5); }
    public Note getQuinte() { return this.fundamental.offset(mode.getOffset() + 7); }
    public Note getMinorSixte() { return this.fundamental.offset(mode.getOffset() + 8); }
    public Note getMajorSixte() { return this.fundamental.offset(mode.getOffset() + 9); }
    public Note getMinorSept() { return this.fundamental.offset(mode.getOffset() + 10); }
    public Note getMajorSept() { return this.fundamental.offset(mode.getOffset() + 11); }
    public Note getOctave() { return this.fundamental.offset(mode.getOffset() + 12); }
    public Note getNine() { return this.fundamental.offset(mode.getOffset() + 14); }

    @Override
    public Iterator<Note> iterator() {
        return this.getNotes().iterator();
    }

    public List<Note> getNotes() {
        final List<Note> notes = new ArrayList<>();
        Note currentNote = this.fundamental;

        // apply the offset defined by the given mode
        currentNote = currentNote.offset( this.mode.getOffset() );

        // yields notes included in the gamma
        for ( int interval : this.interval ) {
            notes.add(currentNote);
            currentNote = currentNote.offset( interval );
        }
        notes.add(currentNote);

        return notes;
    }

    public String toString() {
        return this.fundamental.getName() + " " + this.interval.name();
    }
}
