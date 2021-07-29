package model;

import java.util.List;


public class Accord {
    private AccordType accordType;
    private Gamma gamma;
    private List<Note> notes;

    public Accord( final AccordType accordType, final Gamma gamma, final Note... notes ) {
        this.accordType = accordType;
        this.gamma = gamma;
        this.notes = List.of(notes);
    }

    public List<Note> getNotes() {
        return this.notes;
    }

    public String toString() {
        final Note fundamental = this.gamma.getFundamental();
        return switch (accordType) {
            case POWERCHORD -> "{}5".formatted(fundamental.getName());
            case MAJOR -> "{}".formatted(fundamental.getName());
            case MINOR -> "m{}".formatted(fundamental.getName());
            case MAJOR_7 -> "{}7".formatted(fundamental.getName());
            case MINOR_7 -> "m{}7".formatted(fundamental);
        };
    }
}
