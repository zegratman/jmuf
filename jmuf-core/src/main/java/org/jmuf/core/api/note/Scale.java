package org.jmuf.core.api.note;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class for scale implementations.
 * @author zegratman
 * @version $Id
 */
public class Scale extends TreeSet<Note> {
	
	/**
     * Serial.
     */
    private static final long serialVersionUID = 1L;
	
	/**
	 * Scale name.
	 */
	private String scaleName;
	
	/**
	 * Set the name of the scale.
	 * @param name the name of the scale
	 */
	public void setName(final String name) {
		this.scaleName = name;
	}

	/**
	 * Get the name of the scale.
	 * @return the scale name
	 */
    public String getName() {
		return scaleName;
	}

	/**
	 * Get the note of scale according to its degree.
	 * @param degree the scale degree
	 * @return the corresponding note
	 */
    public Note getDegree(final Integer degree) {
		if (degree < 0) {
			throw new IllegalArgumentException("Degree of a scale must be a positive integer.");
		}
	    Iterator<Note> noteIter = this.iterator();
	    int nIter = 0;
	    while (noteIter.hasNext()) {
	        Note note = noteIter.next();
	        nIter++;
	        if (nIter == degree) {
	            return note;
	        }
	    }
		return null;
	}

	/**
	 * Get the available degrees of the scale.
	 * @return the set of available degrees in the scale
	 */
    public Set<Integer> getDegrees() {
		Set<Integer> degrees = new HashSet<>();
		Iterator<Note> noteIter = this.iterator();
		int nIter = 0;
		while (noteIter.hasNext()) {
			degrees.add(nIter + 1);
		}
		return degrees;
	}
	
}
