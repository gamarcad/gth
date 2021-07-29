package model;

import lombok.Getter;

import java.util.Iterator;
import java.util.List;

@Getter
public enum Interval implements Iterable<Integer> {
    MAJOR( 2, 2, 1, 2, 2, 2, 1),
    HARMONIC_MINOR( 2, 1, 2, 2, 1, 3, 1),
    MELODOC_MINOR(  2, 1, 2, 2, 2, 2, 1),
    PENTATONIC_MAJOR(  2, 2, 3, 2, 3),
    PENTATONIC_MINOR( 3, 2, 2, 3, 2)
    ;

    private List<Integer> intervals;

    Interval( Integer... intervals) {
        this.intervals = List.of(intervals);
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.intervals.iterator();
    }
}
