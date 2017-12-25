package org.jmuf.core.api.modulation;

import java.util.function.Function;

/**
 * This @{@link FunctionalInterface} describes how the phonic signal modulates during a single period T.
 * For instance, during a single period, the signal can vary following a square function.
 * Hence the @{@link NoteModulation} interface is a @{@link Function} assigning a double value to another one,
 * the first value being the time between -T/2 and T/2, and the returned value the signal intensity normalized to 1.
 */
@FunctionalInterface
public interface NoteModulation extends Function<Double, Double> {

}
