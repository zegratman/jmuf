package org.jmuf.sample.classic.tempered.note;

import org.jmuf.core.api.JmufCoreHelper;
import org.jmuf.core.api.exception.JmufCoreException;
import org.jmuf.core.api.note.Note;
import org.jmuf.sample.classic.tempered.alteration.TemperedAlteration;
import org.jmuf.sample.exception.JmufSampleException;

/**
 * Factory to access classical chromatic tempered note.
 * 
 * @author zegratman
 * @version $Id
 */
public final class ChromaticTemperedNoteFactory {

	/**
	 * Get a classical note instance from the factory.
	 *
	 * @param note
	 *            the classical note
	 * @param alteration
	 *            the classical alteration
	 * @param noteLevel
	 *            the note level
	 * @return the classical note
	 * @throws JmufSampleException if problem occurs during note creation.
	 */
	public Note getClassicalNote(final TemperedNote note, final TemperedAlteration alteration,
								 final Integer noteLevel) throws JmufSampleException {
		try {
			return alteration.getAlteration()
					.alterate(JmufCoreHelper.getNoteFactory().createNote(note.name(), note.getClassicalFrequency(), noteLevel));
		} catch (JmufCoreException e) {
			throw new JmufSampleException(
					"Error creating note : " + note.name() + " / " + note.getClassicalFrequency() + " / " + noteLevel,
					e);
		}
	}

}
