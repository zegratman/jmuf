package org.jmuf.core.api.note;

/**
 * The {@link Interval} interface represents an interval in music,
 * i.e. a frequency ratio associated to a name
 * @author zegratman
 * @version 1.0
 * @since 20/03/2015
 */
public final class Interval {

	/**
	 * Internal name.
	 */
	private String name;

	/**
	 * Internal frequency ratio.
	 */
	private Double frequencyRatio;

	/**
	 * Get the name of the interval.
	 * @return the interval name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the frequency ratio that defines the interval.
	 * @return the frequency ratio
	 */
	public Double getFrequencyRatio() {
		return frequencyRatio;
	}

	/**
	 * @param intervalName the name to set
	 */
	public void setName(final String intervalName) {
		this.name = intervalName;
	}

	/**
	 * @param frequency the frequencyRatio to set
	 */
	public void setFrequencyRatio(final Double frequency) {
		this.frequencyRatio = frequency;
	}

}
