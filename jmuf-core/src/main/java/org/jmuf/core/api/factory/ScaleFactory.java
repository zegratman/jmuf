/**
 * 
 */
package org.jmuf.core.api.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.OperationNotSupportedException;

import org.jmuf.core.api.exception.JmufCoreException;
import org.jmuf.core.api.factory.NoteFactory;
import org.jmuf.core.api.note.Interval;
import org.jmuf.core.api.note.Note;
import org.jmuf.core.api.note.Scale;

/**
 * Scale factory to easily instanciate a {@link Scale}.
 *
 * @author zegratman
 * @version $Id
 */
public final class ScaleFactory {

    /** Scale Map. */
    private Map<String, Scale> scaleMap = new HashMap<>();

    /** Degree Map. */
    private Map<String, Integer> currentDegreeMap = new HashMap<>();

    /**
     * Initialize the scale creation, indicating a name. If this method is
     * called whereas a scale with the same name is being built, it has no
     * effect.
     *
     * @param scaleName
     *            the name of the scale being created.
     * @return true if a scale creation was initialized.
     */
    public Boolean initScale(final String scaleName) {
        if (scaleMap.containsKey(scaleName)) {
            return false;
        }
        Scale newScale = new Scale() {
            /** Serial */
            private static final long serialVersionUID = 1L;
        };
        newScale.setName(scaleName);

        scaleMap.put(scaleName, newScale);
        currentDegreeMap.put(scaleName, 0);
        return true;
    }

    /**
     * Add the note to the scale at the given degree.
     *
     * @param scaleName
     *            the name of the scale to complete
     * @param degree
     *            the degree of the note in the scale
     * @param note
     *            the note to be added in the scale
     * @return true if the degree did not exist before
     * @throws JmufCoreException
     *             if the note added gets a frequency that is not in accordance
     *             to degree in the scale.
     */
    public Boolean addNote(final String scaleName, final Integer degree, final Note note)
            throws JmufCoreException {
        // to add a note, the scale must be initialized
        if (!scaleMap.containsKey(scaleName) || !currentDegreeMap.containsKey(scaleName)) {
            return false;
        }
        // to add a note to a given degree, the previous degrees must exist
        Integer currentDegree = currentDegreeMap.get(scaleName);
        if (currentDegree != (degree - 1)) {
            return false;
        }
        // adding the note to the scale
        scaleMap.get(scaleName).add(note);
        currentDegreeMap.put(scaleName, degree);
        return true;
    }

    /**
     * Generate a {@link Scale} from a base {@link Note}, an {@link Interval}
     * and a number of degrees. The Scale is generated using the interval,
     * starting from the base note.
     *
     * @param scaleName
     *            the scale name
     * @param baseNote
     *            the base note
     * @param interval
     *            the interval
     * @param numOfDegrees
     *            the number of degrees
     * @throws JmufCoreException
     *             if number of degrees is < 1 or scale is being created by
     *             another process.
     * @return true if the Scale has been generated correctly.
     */
    public Boolean generateScale(final String scaleName, final Note baseNote, final Interval interval,
                                 final Integer numOfDegrees) throws JmufCoreException {
        boolean allAdded = true;
        Integer degree = 1;
        NoteFactory notefactory = new NoteFactory();

        while (degree <= numOfDegrees) {
            allAdded = allAdded && this.addNote(scaleName, degree, notefactory.createNote(degree.toString(),
                    baseNote.getRealFrequency() * Math.pow(interval.getFrequencyRatio(), degree - 1)));
            degree++;
        }

        return allAdded;
    }

    /**
     * Get the scale and close the build process.
     *
     * @param scaleName
     *            the scale name to get and close
     * @return the corresponding scale
     */
    public Scale closeScale(final String scaleName) {
        Scale outScale = scaleMap.get(scaleName);
        scaleMap.remove(scaleName);
        currentDegreeMap.remove(scaleName);
        return outScale;
    }

    /**
     * Generate a scale from a base note and a list of intervals.
     *
     * @param scaleName
     *            the name of the scale to generate
     * @param baseNote
     *            the base note
     * @param intervals
     *            the intervals
     * @return true if the scale was successfully generated. Then it can be
     *         retrieved with {@link #closeScale(String)} method.
     * @throws JmufCoreException if occurs
     */
	public Boolean generateScale(final String scaleName, final Note baseNote, final List<Interval> intervals)
			throws JmufCoreException {
		try {
			throw new OperationNotSupportedException("Not implemented yet");
		} catch (OperationNotSupportedException e) {
			throw new JmufCoreException(e);
		}
	}

}
