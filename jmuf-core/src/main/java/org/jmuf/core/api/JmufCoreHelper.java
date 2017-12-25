package org.jmuf.core.api;

import org.jmuf.core.api.factory.ChordFactory;
import org.jmuf.core.api.factory.IntervalFactory;
import org.jmuf.core.api.factory.NoteFactory;
import org.jmuf.core.api.factory.ScaleFactory;
import org.jmuf.core.api.factory.SubScaleFactory;

/**
 * Helper to access all JMUF core factories.
 * 
 * @author zegratman
 * @version $Id
 */
public abstract class JmufCoreHelper {

	/** Note factory implementation. */
	private static final NoteFactory NOTE_FACTORY = new NoteFactory();

	/** Chord factory implementation. */
	private static final ChordFactory CHORD_FACTORY = new ChordFactory();

	/** Scale factory implementation. */
	private static final ScaleFactory SCALE_FACTORY = new ScaleFactory();

	/** Subscale factory implementation. */
	private static final SubScaleFactory SUBSCALE_FACTORY = new SubScaleFactory();

	/** Interval factory implementation. */
	private static final IntervalFactory INTERVAL_FACTORY = new IntervalFactory();

	/**
	 * Get the {@link org.jmuf.core.api.note.Note} factory.
	 * 
	 * @return the note factory
	 */
	public static NoteFactory getNoteFactory() {
		return NOTE_FACTORY;
	};

	/**
	 * Get the {@link org.jmuf.core.api.note.Chord} factory.
	 * 
	 * @return the chord factory
	 */
	public static ChordFactory getChordFactory() {
		return CHORD_FACTORY;
	};

	/**
	 * Get the {@link org.jmuf.core.api.note.Scale} factory.
	 * 
	 * @return the scale factory
	 */
	public static ScaleFactory getScaleFactory() {
		return SCALE_FACTORY;
	};

	/**
	 * Get the {@link org.jmuf.core.api.note.SubScale} factory.
	 * 
	 * @return the subscale factory
	 */
	public static SubScaleFactory getSubScaleFactory() {
		return SUBSCALE_FACTORY;
	};

	/**
	 * Get the {@link org.jmuf.core.api.note.Interval} factory.
	 * 
	 * @return the interval factory
	 */
	public static IntervalFactory getIntervalFactory() {
		return INTERVAL_FACTORY;
	};

}
