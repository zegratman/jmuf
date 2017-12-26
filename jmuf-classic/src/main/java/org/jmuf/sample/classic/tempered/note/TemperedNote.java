/**
 * 
 */
package org.jmuf.sample.classic.tempered.note;

import org.jmuf.core.api.note.Note;
import org.jmuf.core.api.note.Scale;
import org.jmuf.sample.classic.ClassicalNoteDefinition;
import org.jmuf.sample.classic.tempered.TemperedConstants;

/**
 * Enumeration of classical note names.
 * @author zegratman
 * @version $Id
 */
public enum TemperedNote {
    /** A, or La. */
    A(ClassicalNoteDefinition.A),
    /** B, or Si. */
    B(ClassicalNoteDefinition.B),
    /** C, or Do/Ut. */
    C(ClassicalNoteDefinition.C),
    /** D, or Re. */
    D(ClassicalNoteDefinition.D),
    /** E, or Mi. */
    E(ClassicalNoteDefinition.E),
    /** F, or Fa. */
    F(ClassicalNoteDefinition.F),
    /** G, or Sol. */
    G(ClassicalNoteDefinition.G);
    
    /** European version of the name. */
    private String europeName;
    
    /** Private base note. */
    private Note baseNote;
    
    /**
     * Private constructor.
     * @param classicalNote the classical note name to which the tempered version applies
     */
    TemperedNote(final ClassicalNoteDefinition classicalNote) {
        this.europeName = classicalNote.getEuropeanName();
        final Scale temperedScale =  TemperedConstants.getBaseChromaticTemperedScale();
        this.baseNote = temperedScale.getDegree(classicalNote.getDegree());
    }
    
    /**
     * @return get the european name.
     */
    public String getEuropeanName() {
        return this.europeName;
    }
    
    /**
     * @return get the classical frequency associated.
     */
    public Double getClassicalFrequency() {
    	return this.baseNote.getFrequencyBase();
    }

	/**
	 * @return the baseNote
	 */
	public Note getBaseNote() {
		return baseNote;
	}
    
}
