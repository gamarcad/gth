package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Mode {
    MODE_INITIAL(  0 ),
    MODE_DORIEN( 1 ),
    MODE_PHRYGIEN(  2 ),
    MODE_LYDIEN(  3 ),
    MODE_MIXOLYDIEN( 4),
    MODE_EOLIEN(5),
    MODE_LOCRIEN( 6)
    ;

    private int offset;
}
