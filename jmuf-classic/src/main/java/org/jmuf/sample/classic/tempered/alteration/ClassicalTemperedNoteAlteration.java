package org.jmuf.sample.classic.tempered.alteration;

import org.jmuf.core.api.JmufCoreHelper;
import org.jmuf.core.api.exception.JmufCoreException;
import org.jmuf.core.api.factory.NoteFactory;
import org.jmuf.core.api.note.Note;
import org.jmuf.core.api.alteration.NoteAlteration;

/**
 * Internal class for classical note alterations.
 * 
 * @author zegratman
 * @version $Id
 */
public class ClassicalTemperedNoteAlteration extends NoteAlteration {

	/** Internal alteration. */
	private ClassicalTemperedAlteration alteration;

	/**
	 * Constructor.
	 * @param alterationType
	 *            the alteration which is the base of the alteration
	 *            implementation.
	 */
	public ClassicalTemperedNoteAlteration(final ClassicalTemperedAlteration alterationType) {
		super(alterationType.getName());
		this.alteration = alterationType;
	}

	@Override
	public final Note alterate(final Note initNote) {
		try {
			final Note outNote = JmufCoreHelper.getNoteFactory().createNote(
					initNote.getName() + alteration.getName(),
					initNote.getFrequencyBase() * alteration.getFrequencyAlteration());
			return outNote;
		} catch (JmufCoreException e) {
			e.printStackTrace();
		}
		return null;
	}

}