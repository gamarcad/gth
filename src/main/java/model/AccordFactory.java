package model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccordFactory {
    public static AccordFactory buildFactory(Gamma gamma) {
        return new AccordFactory(gamma);
    }

    private Gamma gamma;

    public Accord getPowerChord() {
        return new Accord(
                AccordType.POWERCHORD,
                this.gamma,
                this.gamma.getFundamental(),
                this.gamma.getQuinte()
        );
    }

    public Accord getMinor() {
        return new Accord(
                AccordType.MINOR,
                this.gamma,
                this.gamma.getFundamental(),
                this.gamma.getMinorTierce(),
                this.gamma.getQuinte()
        );
    }

    public Accord getMajor() {
        return new Accord(
                AccordType.MAJOR,
                this.gamma,
                this.gamma.getFundamental(),
                this.gamma.getMajorTierce(),
                this.gamma.getQuinte()
        );
    }

    public Accord getMinor7() {
        return new Accord(
                AccordType.MINOR_7,
                this.gamma,
                this.gamma.getFundamental(),
                this.gamma.getMinorTierce(),
                this.gamma.getQuinte(),
                this.gamma.getMinorSept()
        );
    }

    public Accord getMajor7() {
        return new Accord(
                AccordType.MAJOR_7,
                this.gamma,
                this.gamma.getFundamental(),
                this.gamma.getMajorTierce(),
                this.gamma.getQuinte(),
                this.gamma.getMinorSept()
        );
    }

    public Accord getFromAccordType(AccordType accordType) {
        return switch (accordType) {
            case MAJOR -> this.getMajor();
            case POWERCHORD -> this.getPowerChord();
            case MINOR -> this.getMinor();
            case MAJOR_7 -> this.getMajor7();
            case MINOR_7 -> this.getMinor7();
        };
    }
}
