/**
 * 
 */
package org.jmuf.sample.classic;

/**
 * Enumeration of classical note names.
 * @author zegratman
 * @since 06/12/2015
 * @version 1.0
 */
public enum ClassicalNoteDefinition {
    /** A, or La. */
    A("La", 0),
    /** B, or Si. */
    B("Si", 2),
    /** C, or Do/Ut. */
    C("Do", 3),
    /** D, or Re. */
    D("Re", 5),
    /** E, or Mi. */
    E("Mi", 7),
    /** F, or Fa. */
    F("Fa", 8),
    /** G, or Sol. */
    G("Sol", 10);
    
    /** European version of the name. */
    private String europeName;
    
    /** Private base note. */
    private Integer degree;
    
    /**
     * Private constructor.
     * @param europeanName the alternative European name.
     * @param scaleDegree the degree in the tempered chromatic scale;.
     */
    ClassicalNoteDefinition(final String europeanName, final Integer scaleDegree) {
        this.europeName = europeanName;
        this.degree = scaleDegree;
    }
    
    /**
     * @return get the european name.
     */
    public String getEuropeanName() {
        return this.europeName;
    }
    
	/**
	 * @return the baseNote
	 */
	public Integer getDegree() {
		return degree;
	}
    
}
