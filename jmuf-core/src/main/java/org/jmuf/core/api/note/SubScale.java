package org.jmuf.core.api.note;

import java.util.Set;

/**
 * Base class for {@link SubScale} implementations.
 * @author zegratman
 * @since 24/10/2015
 * @version 1.0
 */
public final class SubScale extends Scale {

	/**
     * Serial.
     */
    private static final long serialVersionUID = -1690727931368941198L;

    /**
	 * Parent scale.
	 */
	private Scale parentScale;
	
	/**
	 * Parent degrees.
	 */
	private Set<Integer> parentDegrees;
	
	/**
	 * Abstract constructor that sub-classes should use.
	 * @param subScaleName the sub-scale name
	 * @param parent the parent scale instance
	 * @param parentDegs the degrees to extract from parent scale
	 */
	public SubScale(final String subScaleName, final Scale parent, final Set<Integer> parentDegs) {
		this.parentScale = parent;
		this.parentDegrees = parentDegs;
		setName(subScaleName);
		for (Integer degree : parentDegs) {
			this.add(parent.getDegree(degree));
		}
	}

	/**
	 * Get the parent {@link Scale} if this {@link SubScale}.
	 * @return the parent scale
	 */
    public Scale getParentScale() {
		return parentScale;
	}

	/**
	 * Get the degrees of the parent scale from which this scale is originating from.
	 * @return the set of degrees
	 */
    public Set<Integer> getParentDegrees() {
		return parentDegrees;
	}

}
