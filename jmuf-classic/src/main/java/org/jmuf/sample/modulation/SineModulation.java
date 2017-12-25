package org.jmuf.sample.modulation;

import org.jmuf.core.api.modulation.NoteModulation;

/**
 * Sample of @{@link NoteModulation} with a simple sine modulation.
 */
public class SineModulation implements NoteModulation {

    @Override
    public Double apply(Double aDouble) {
        return Math.sin(aDouble);
    }

}
