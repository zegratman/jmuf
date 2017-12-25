package org.jmuf.core.api.alteration;

import org.jmuf.core.api.note.Note;

/**
 * Interface describing the alteration of a music note.
 * @author zegratman
 * @version $Id
 */
public abstract class NoteAlteration {

	/** Alteration name. */
	private String alterationName;
	
	/**
	 * Contructor.
	 * @param name the alteration name
	 */
	protected NoteAlteration(final String name) {
		this.alterationName = name;
	}

	/**
	 * @return the alteration name
	 */
	public final String getName() {
		return alterationName;
	}

	/**
	 * Alteration of an initial note to create another one.
	 * @param initialNote the initial note.
	 * @return the note as alteration of the initial one.
	 */
	public abstract Note alterate(Note initialNote);

}
