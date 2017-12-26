package org.jmuf.core.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jmuf.core.api.exception.JmufCoreException;
import org.jmuf.core.api.note.Interval;
import org.jmuf.core.api.note.Note;
import org.jmuf.core.api.factory.IntervalFactory;
import org.jmuf.core.api.factory.NoteFactory;
import org.jmuf.core.api.factory.ScaleFactory;
import org.jmuf.core.api.note.Scale;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for {@link Scale} base class
 * @author zegratman
 * @version $Id
 * @since 28/09/2015
 */
public class TestScale {

	private static final String TEST_SCALE_NAME = "Chromatic A";
	private static final Integer TEST_NUM_DEGREES = 13;
	private static final String TEST_BASE_NOTE_NAME = "A";
	private static final Double TEST_BASE_NOTE_FREQ = 440.0e0;
	private static final String TEST_INTERVAL_NAME = "Half-Tone";
	private static final Double TEST_INTERVAL_RATIO = Math.pow(2, 1.0/12.0);
	private static final ScaleFactory SCALE_FACTORY = new ScaleFactory();
	private static final NoteFactory NOTE_FACTORY = new NoteFactory();
	private static final IntervalFactory INTERVAL_FACTORY = new IntervalFactory();

	private Scale testScale;

	@Before
	public void setUp() {
		// Create  a scale from a base note and an interval
		try {
			JmufCore.init();
			Note baseNote = NOTE_FACTORY.createNote(TEST_BASE_NOTE_NAME, TEST_BASE_NOTE_FREQ);
			Interval interval = INTERVAL_FACTORY.createInterval(TEST_INTERVAL_NAME, TEST_INTERVAL_RATIO);
			SCALE_FACTORY.initScale(TEST_SCALE_NAME);
			SCALE_FACTORY.generateScale(TEST_SCALE_NAME, baseNote, interval, TEST_NUM_DEGREES);
			testScale = SCALE_FACTORY.closeScale(TEST_SCALE_NAME);
		} catch (JmufCoreException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetName() {
		assertEquals(TEST_SCALE_NAME, testScale.getName());
	}
	
	@Test
	public void testGetFirstDegree() {
		
		// first degree
		Note firstDegree = testScale.getDegree(1);
		assertEquals("1", firstDegree.getName());
		assertEquals(new Double(27.5), firstDegree.getFrequencyBase());
		assertEquals(new Integer(4), firstDegree.getFrequencyLevel());
		
	}

	@Test
	public void testGetSecondDegree() {
		
		// second degree
		Note secondDegree = testScale.getDegree(2);
		assertEquals("2", secondDegree.getName());
		assertEquals(new Double(29.13523509488062), secondDegree.getFrequencyBase());
		assertEquals(new Integer(4), secondDegree.getFrequencyLevel());
		
	}
	
	@Test
	public void testGetLastDegree() {
		
		// last degree
		Note lastDegree = testScale.getDegree(13);
		assertEquals("13", lastDegree.getName());
		assertTrue((27.5 - lastDegree.getFrequencyBase()) < 1.0e-9);
		assertEquals(new Integer(5), lastDegree.getFrequencyLevel());
		
	}

}
