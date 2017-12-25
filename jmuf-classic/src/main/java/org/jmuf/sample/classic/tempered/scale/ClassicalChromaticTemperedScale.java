/**
 * 
 */
package org.jmuf.sample.classic.tempered.scale;

import org.jmuf.core.api.JmufCore;
import org.jmuf.core.api.JmufCoreHelper;
import org.jmuf.core.api.exception.JmufCoreException;
import org.jmuf.core.api.factory.ScaleFactory;
import org.jmuf.core.api.note.Interval;
import org.jmuf.core.api.note.Note;
import org.jmuf.core.api.note.Scale;
import org.jmuf.sample.classic.tempered.ClassicalTemperedConstants;
import org.jmuf.sample.classic.tempered.alteration.ClassicalTemperedAlteration;
import org.jmuf.sample.classic.tempered.note.ChromaticTemperedNoteFactory;
import org.jmuf.sample.classic.tempered.note.ClassicalTemperedNote;

import java.util.Set;

/**
 * Chromatic tempered scale is the full set of classic tempered notes.
 * The scale is generated from the JMUF core tools, then this class wraps
 * the {@link Scale} class.
 * @author zegratman
 * @version $Id
 */
public class ClassicalChromaticTemperedScale extends Scale {

	/** Scale name */
	public static final String CHROMATIC_TEMPERED = "CHROMATIC TEMPERED";

	/** internal wrapping scale */
	private Scale internalScale = null;

	/**
	 * Constructor
	 */
	public ClassicalChromaticTemperedScale() {

		super.setName(CHROMATIC_TEMPERED);
		try {

		    /** Init scale factory */
            JmufCore.init();
			ScaleFactory factory = JmufCoreHelper.getScaleFactory();
			factory.initScale(CHROMATIC_TEMPERED);

			/** Using tempered note factory to get the A4 as base note */
			ChromaticTemperedNoteFactory noteFactory = new ChromaticTemperedNoteFactory();
			Note baseNote = noteFactory.getClassicalNote(ClassicalTemperedNote.A, ClassicalTemperedAlteration.FLAT, 4);

			/** Get the tempered interval */
			Interval interval = ClassicalTemperedConstants.getTemperedInterval();

			/** Generate the scale */
			factory.generateScale(CHROMATIC_TEMPERED, baseNote, interval, 12);
			internalScale = factory.closeScale(CHROMATIC_TEMPERED);

		} catch (JmufCoreException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Note getDegree(Integer degree) {
		return internalScale.getDegree(degree);
	}

	@Override
	public Set<Integer> getDegrees() {
		return internalScale.getDegrees();
	}
}
