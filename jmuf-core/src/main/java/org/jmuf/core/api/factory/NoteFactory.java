package org.jmuf.core.api.factory;

import org.jmuf.core.api.JmufCore;
import org.jmuf.core.api.exception.JmufCoreException;
import org.jmuf.core.api.note.Note;

/**
 * A note factory allows JMUF user to create a music note.
 * @author zegratman
 * @version $Id
 */
public final class NoteFactory {

    /**
     * Create a note from parameters.
     * @param noteName the note name
     * @param frequency the note base frequency (see {@link Note} definition)
     * @param degree the frequency degree (see {@link Note} definition)
     * @return the note instance
     * @throws JmufCoreException if the base frequency is outside [20;40[ Hz
     */
    public Note createNote(final String noteName, final Double frequency, final Integer degree)
            throws JmufCoreException {
        Note aNote = new Note();
        aNote.setName(noteName);
        aNote.setFrequencyBase(frequency);
        aNote.setFrequencyLevel(degree);
        return aNote;
    }

    /**
     * Create a note from a real frequency.
     * @param noteName the note name
     * @param realFrequency the real frequency of the note
     * @return the note instance.
     * @throws JmufCoreException if error occurs during creation
     */
    public Note createNote(final String noteName, final Double realFrequency) throws JmufCoreException {

        // check that real frequency >= 20 Hz
        if (realFrequency < JmufCore.getJmufCoreMinimalBaseFrequency()) {
            throw new JmufCoreException(
                    "Real frequency " + realFrequency + "is not greater than " + JmufCore.getJmufCoreMinimalBaseFrequency() + "Hz");
        }

        Note aNote = new Note();
        aNote.setName(noteName);
        Double freq = realFrequency;
        Integer level = 0;
        while (freq >= JmufCore.getJmufCoreMaximalBaseFrequency()) {
            freq /= 2;
            level++;
        }
        aNote.setFrequencyBase(freq);
        aNote.setFrequencyLevel(level);
        return aNote;
    }

}