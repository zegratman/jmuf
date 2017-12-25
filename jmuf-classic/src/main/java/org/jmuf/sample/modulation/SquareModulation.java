package org.jmuf.sample.modulation;

import org.jmuf.core.api.modulation.NoteModulation;

/**
 * Sample of @{@link NoteModulation} with a simple modulation modulation.
 */
public class SquareModulation implements NoteModulation {

    @Override
    public Double apply(Double aDouble) {
        return aDouble < 0 ? -1.0e0: 1.0e0;
    }

}
