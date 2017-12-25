/**
 * 
 */
package org.jmuf.core.api.factory;

import java.util.Set;

import org.jmuf.core.api.note.Chord;
import org.jmuf.core.api.note.Scale;

/**
 * This factory allows to create a {@link Chord} with a single method.
 * @author zegratman
 * @version $Id
 */
public final class ChordFactory {

	/**
	 * Create a {@link Chord} instance.
	 * @param chordName the name of the {@link Chord} created.
	 * @param parentScale the parent {@link Scale} of the chord.
	 * @param parentDegrees the degrees to use to create the {@link Chord}
	 * @return the {@link Chord} instance
	 */
	public final Chord createChord(final String chordName, final Scale parentScale, final Set<Integer> parentDegrees) {
		Chord outChord = new Chord();
		outChord.setName(chordName);
		parentDegrees.forEach(degree -> outChord.add(parentScale.getDegree(degree)));
		return outChord;
	}

}
