package org.jmuf.sample.classic.tempered;

import org.jmuf.core.api.exception.JmufCoreException;
import org.jmuf.core.api.factory.NoteFactory;
import org.jmuf.core.api.factory.ScaleFactory;
import org.jmuf.core.api.note.Interval;
import org.jmuf.core.api.note.Scale;
import org.jmuf.core.api.JmufCoreHelper;

/**
 * Interface containing the constants associated to classical music.
 * 
 * @author zegratman
 * @since 14/12/2015
 * @version 1.0
 */
public abstract class ClassicalTemperedConstants {

	/** Number of half-tones. */
	private static final int NUM_INTERVALS = 12;

	/** Tempered interval name. */
	private static final String TEMPERED_INTERVAL_NAME = "TEMPERED_INTERVAL";

	/** Tempered base tuning. */
	private static final Double TUNING_BASE_FREQUENCY = 27.50000e0;

	/** Tempered chromatic scale name. */
	private static final String TEMPEREDCHROM_SCALE = "Chromatic Tempered";

	/** Tempered interval. */
	private static Interval temperedInterval;

	/** Tempered chromatic scale. */
	private static Scale temperedChromaticScale;

	/**
	 * @return the number of intervals in an octave in classical music.
	 */
	public final int getClassicalNumberOfIntervals() {
		return NUM_INTERVALS;
	}

	/**
	 * @return the interval in classical tempered scale.
	 */
	public static Interval getTemperedInterval() {
		if (temperedInterval == null) {
			temperedInterval = JmufCoreHelper.getIntervalFactory().createInterval(TEMPERED_INTERVAL_NAME,
					Math.pow(2.0e0, 1.0e0 / NUM_INTERVALS));
		}
		return temperedInterval;
	}

	/**
	 * @return the tuning base frequency
	 */
	public static Double getTuningbasefrequency() {
		return TUNING_BASE_FREQUENCY;
	}

	/**
	 * @return the base chromatic tempered scale;
	 */
	public static Scale getBaseChromaticTemperedScale() {
		if (temperedChromaticScale == null) {
			try {
				ScaleFactory factory = JmufCoreHelper.getScaleFactory();
				NoteFactory noteFactory = JmufCoreHelper.getNoteFactory();
				factory.initScale(TEMPEREDCHROM_SCALE);
				factory.generateScale(TEMPEREDCHROM_SCALE, noteFactory.createNote("", TUNING_BASE_FREQUENCY),
						getTemperedInterval(), NUM_INTERVALS);
				temperedChromaticScale = factory.closeScale(TEMPEREDCHROM_SCALE);
			} catch (JmufCoreException e) {
				e.printStackTrace();
			}
		}
		return temperedChromaticScale;
	}

}
