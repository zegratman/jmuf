package org.jmuf.core.api.note;

/**
 * The {@link Chord} is a specific {@link Scale} originating from a parent
 * {@link Scale} and keeping the original description of degrees (contrary to
 * {@link SubScale}). A Chord also defines a fundamental {@link Note}.
 * @author zegratman
 * @version 1.0
 * @since 15/03/2015
 */
public final class Chord extends Scale {

	/**
     * Serial.
     */
    private static final long serialVersionUID = -7907014132612198771L;

	/**
	 * Get the fundamental note of the {@link Chord}.
	 * @return a {@link Note} which is the base note of the {@link Chord}.
	 */
    public Note getFundamental() {
		return this.first();
	}

}
