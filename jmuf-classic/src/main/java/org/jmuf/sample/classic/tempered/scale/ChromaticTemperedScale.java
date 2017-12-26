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
import org.jmuf.sample.classic.tempered.TemperedConstants;
import org.jmuf.sample.classic.tempered.alteration.TemperedAlteration;
import org.jmuf.sample.classic.tempered.note.ChromaticTemperedNoteFactory;
import org.jmuf.sample.classic.tempered.note.TemperedNote;

import java.util.Set;

/**
 * Chromatic tempered scale is the full set of classic tempered notes.
 * The scale is generated from the JMUF core tools, then this class wraps
 * the {@link Scale} class.
 * @author zegratman
 * @version $Id
 */
public class ChromaticTemperedScale extends Scale {

	/** Scale name */
	public static final String CHROMATIC_TEMPERED = "CHROMATIC TEMPERED";

	/** internal wrapping scale */
	private Scale internalScale = null;

	/**
	 * Constructor
	 */
	public ChromaticTemperedScale() {
	    super();
		super.setName(CHROMATIC_TEMPERED);
	}

	/**
	 * Method to initialize internal wrapped scale.
	 */
	private void initScale() {
		try {

			/** Init scale factory */
			JmufCore.init();
			ScaleFactory factory = JmufCoreHelper.getScaleFactory();
			factory.initScale(CHROMATIC_TEMPERED);

			/** Using tempered note factory to get the A4 as base note */
			ChromaticTemperedNoteFactory noteFactory = new ChromaticTemperedNoteFactory();
			Note baseNote = noteFactory.getClassicalNote(TemperedNote.A, TemperedAlteration.NONE, 4);

			/** Get the tempered interval */
			Interval interval = TemperedConstants.getTemperedInterval();

			/** Generate the scale */
			factory.generateScale(CHROMATIC_TEMPERED, baseNote, interval, 12);
			internalScale = factory.closeScale(CHROMATIC_TEMPERED);

		} catch (JmufCoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Note getDegree(Integer degree) {
		if (internalScale == null) {
			initScale();
		}
		return internalScale.getDegree(degree);
	}

	@Override
	public Set<Integer> getDegrees() {
		if (internalScale == null) {
			initScale();
		}
		return internalScale.getDegrees();
	}
}
