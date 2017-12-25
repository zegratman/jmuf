package org.jmuf.sample.classic.tempered.alteration;

import org.jmuf.core.api.alteration.NoteAlteration;
import org.jmuf.sample.classic.tempered.ClassicalTemperedConstants;

/**
 * Enumeration of note alterations in classical tempered music.
 * 
 * @author zegratman
 * @version $Id
 */
public enum ClassicalTemperedAlteration {

	/** Sharp alteration. */
	SHARP("#", ClassicalTemperedConstants.getTemperedInterval().getFrequencyRatio()),
	/** Flat alteration. */
	FLAT("b", 1.0 / ClassicalTemperedConstants.getTemperedInterval().getFrequencyRatio());

	/** Alteration Name. */
	private String alterationName;

	/** Frequency Alteration. */
	private Double frequencyAlteration;

	/** associated note alteration. */
	private NoteAlteration alteration;

	/**
	 * Private constructor.
	 * 
	 * @param alterName
	 *            the alteration name
	 * @param freqAlteration
	 *            the frequency alteration
	 */
	ClassicalTemperedAlteration(final String alterName, final Double freqAlteration) {
		this.alterationName = alterName;
		this.frequencyAlteration = freqAlteration;
		this.alteration = new ClassicalTemperedNoteAlteration(this);
	}

	/**
	 * @return the name of the alteration
	 */
	public String getName() {
		return this.alterationName;
	}

	/**
	 * @return the frequency alteration
	 */
	public Double getFrequencyAlteration() {
		return frequencyAlteration;
	}

	/**
	 * @return the alteration associated
	 */
	public NoteAlteration getAlteration() {
		return alteration;
	}

}
