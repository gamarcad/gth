import model.*;

public class main {
    public static void main(String[] args) {
        Gamma gamme = new Gamma( Note.C, Interval.MAJOR );
        for ( Note note : gamme.getNotes() ) {
            System.out.println(note);
        }

        AccordFactory accordFactory = AccordFactory.buildFactory(gamme);
        System.out.println( accordFactory.getPowerChord() );
    }
}
