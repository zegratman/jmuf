package org.jmuf.core.api.factory;

import org.jmuf.core.api.note.Interval;
import org.jmuf.core.api.note.Note;

/**
 * The {@link IntervalFactory} permits to instanciate an {@link Interval}.
 * @author zegratman
 * @version $Id
 */
public final class IntervalFactory {

    /**
     * Create an Interval from basic attributes.
     * @param name the interval name
     * @param freqRatio the frequency ratio
     * @return the corresponding interval
     */
    public Interval createInterval(final String name, final Double freqRatio) {
        Interval interval = new Interval();
        interval.setName(name);
        interval.setFrequencyRatio(freqRatio);
        return interval;
    }

    /**
     * Create an interval by comparison of two notes.
     * @param name the interval name
     * @param baseNote the base note
     * @param otherNote the other note
     * @return the corresponding interval
     */
    public Interval createInterval(final String name, final Note baseNote, final Note otherNote) {
        return createInterval(name, otherNote.getRealFrequency() / baseNote.getRealFrequency());
    }

}
