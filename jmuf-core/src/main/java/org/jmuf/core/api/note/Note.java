package org.jmuf.core.api.note;

import org.jmuf.core.api.JmufCore;
import org.jmuf.core.api.exception.JmufCoreException;

/**
 * Class defining a music note. A {@link Note} gets
 * <ul>
 *   <li>A name</li>
 *   <li>A base frequency of the note</li>
 *   <li>A frequency level, representing the degree N as f = f0 * 2^N</li>
 * </ul>
 * As the lowest frequency that can be heard by a human being is 20 Hz,
 * the base frequency of the note (degree 0) is expected to be between 20 and 40 Hz (excluded).
 * The {@link Note} interface extends the {@link Comparable} interface as they can be sorted in term of frequency.
 * @author zegratman
 * @since 10/10/2017
 * @version 2.0
 */
public class Note implements Comparable<Note> {

	/**
	 * Name of the note.
	 */
	private String name;
	
	/**
	 * Base frequency of the note.
	 */
	private Double frequencyBase;
	
	/**
	 * Frequency level of the note.
	 */
	private Integer frequencyLevel;
	
	/**
	 * Get the name of the note.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the base frequency of the note
	 */
	public Double getFrequencyBase() {
		return frequencyBase;
	}

	/**
	 * Get the frequency level of the note
	 */
	public Integer getFrequencyLevel() {
		return frequencyLevel;
	}

	/**
	 * Set the note name.
	 * @param noteName the name to set
	 */
	public void setName(final String noteName) {
		this.name = noteName;
	}

	/**
	 * Set the base frequency.
	 * The base frequency should be always between 20.0 and 40.0 (excluded)
	 * @param fb the frequencyBase to set
	 * @throws JmufCoreException if frequency base is out of authorized bounds
	 */
	public void setFrequencyBase(final Double fb) throws JmufCoreException {
		if ((fb < JmufCore.getJmufCoreMinimalBaseFrequency()) || (fb >= JmufCore.getJmufCoreMaximalBaseFrequency())) {
			throw new JmufCoreException("The frequency base " + fb + " is out of authorized bounds");
		}
		this.frequencyBase = fb;
	}

	/**
	 * Set the frequency level.
	 * The frequency level is a positive integer.
	 * @param fl the frequencyLevel to set
	 * @throws JmufCoreException if frequency level is not greater or equal to 0.
	 */
	public void setFrequencyLevel(final Integer fl) throws JmufCoreException {
		if (fl < 0) {
			throw new JmufCoreException("The frequency level " + frequencyBase + " cannot be negative");
		}
		this.frequencyLevel = fl;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
    public int compareTo(final Note o) {
		if (this.frequencyLevel < o.getFrequencyLevel()) { 
		    return -1; 
		}
		if (this.frequencyLevel > o.getFrequencyLevel()) { 
		    return 1; 
		}
		if (this.frequencyBase < o.getFrequencyBase()) {
		    return -1;
		}
		if (this.frequencyBase > o.getFrequencyBase()) {
		    return 1;
		}
		return 0;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
    public boolean equals(final Object obj) {
		if (!(obj instanceof Note)) {
            return false;
        }
		Note otherNote = (Note) obj;
		return this.getName().equals(otherNote.getName()) && this.compareTo(otherNote) == 0;
	}
	
	/* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return super.hashCode();
    }

    /* (non-Javadoc)
	 * @see org.jmuf.base.Note#getRealFrequency()
	 */
	public Double getRealFrequency() {
		return this.getFrequencyBase() * Math.pow(2, this.getFrequencyLevel());
	}

}
