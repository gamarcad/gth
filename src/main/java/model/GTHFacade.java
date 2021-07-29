package model;

public class GTHFacade {
    public static GuitarTuning standardGuitarTuning() {
        return new GuitarTuning( Note.E, Note.A, Note.D, Note.G, Note.B, Note.E );
    }
}
