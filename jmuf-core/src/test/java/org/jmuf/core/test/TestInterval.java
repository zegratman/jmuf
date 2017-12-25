package org.jmuf.core.test;

import static org.junit.Assert.assertEquals;

import org.jmuf.core.api.factory.IntervalFactory;
import org.jmuf.core.api.note.Interval;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for {@link Interval} base class
 * 
 * @author zegratman
 * @version 1.0
 * @since 24/10/2015
 */
public class TestInterval {

	private static final String TEST_INTERVAL_NAME = "Tempered Half-Tone";
	private static final Double TEST_INTERVAL_RATIO = Math.pow(2, 1.0 / 12.0);
	private static final IntervalFactory INTERVAL_FACTORY = new IntervalFactory();

	private Interval testInterval;

	@Before
	public void setUp() {
		testInterval = INTERVAL_FACTORY.createInterval(TEST_INTERVAL_NAME, TEST_INTERVAL_RATIO);
	}

	@Test
	public void testGetName() {
		assertEquals(TEST_INTERVAL_NAME, testInterval.getName());
	}

	@Test
	public void testGetRatio() {
		assertEquals(TEST_INTERVAL_RATIO, testInterval.getFrequencyRatio());
	}

}
