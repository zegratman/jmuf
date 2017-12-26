package org.jmuf.core.api;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.jmuf.core.api.exception.JmufCoreException;
import org.jmuf.core.api.note.Interval;
import org.jmuf.core.api.note.Note;
import org.jmuf.core.api.note.Scale;
import org.jmuf.core.api.factory.IntervalFactory;
import org.jmuf.core.api.factory.NoteFactory;
import org.jmuf.core.api.factory.ScaleFactory;
import org.jmuf.core.api.factory.SubScaleFactory;
import org.jmuf.core.api.note.SubScale;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for {@link SubScale} base class
 * @author zegratman
 * @version $Id
 * @since 25/10/2015
 */
public class TestSubScale {

	private static final String TEST_SCALE_NAME = "Chromatic A";
	private static final Integer TEST_NUM_DEGREES = 13;
	private static final String TEST_BASE_NOTE_NAME = "A";
	private static final Double TEST_BASE_NOTE_FREQ = 440.0e0;
	private static final String TEST_INTERVAL_NAME = "Half-Tone";
	private static final Double TEST_INTERVAL_RATIO = Math.pow(2, 1.0/12.0);
	private static final ScaleFactory SCALE_FACTORY = new ScaleFactory();
	private static final NoteFactory NOTE_FACTORY = new NoteFactory();
	private static final IntervalFactory INTERVAL_FACTORY = new IntervalFactory();

	private static final String TEST_SUBSCALE_NAME = "Pintatonic A";
	private static final SubScaleFactory SUBSCALE_FACTORY = new SubScaleFactory();
	private static final Collection<Integer> TEST_SUBSCALE_DEGREES = Arrays.asList(1, 4, 6, 8, 11);
	
	private Scale parentScale;
	private Set<Integer> parentDegrees;
	private SubScale testSubScale;

	@Before
	public void setUp() {
		// Create  a scale from a base note and an interval
		try {
			JmufCore.init();
			Note baseNote = NOTE_FACTORY.createNote(TEST_BASE_NOTE_NAME, TEST_BASE_NOTE_FREQ);
			Interval interval = INTERVAL_FACTORY.createInterval(TEST_INTERVAL_NAME, TEST_INTERVAL_RATIO);
			SCALE_FACTORY.initScale(TEST_SCALE_NAME);
			SCALE_FACTORY.generateScale(TEST_SCALE_NAME, baseNote, interval, TEST_NUM_DEGREES);
			parentScale = SCALE_FACTORY.closeScale(TEST_SCALE_NAME);
			parentDegrees = new HashSet<>();
			parentDegrees.addAll(TEST_SUBSCALE_DEGREES);
			testSubScale = SUBSCALE_FACTORY.createSubScale(TEST_SUBSCALE_NAME, parentScale, parentDegrees);
			
		} catch (JmufCoreException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetName() {
		assertEquals(TEST_SUBSCALE_NAME, testSubScale.getName());
	}
	
	@Test
	public void testGetParent() {
		assertEquals(parentScale, testSubScale.getParentScale());
	}
	
	@Test
	public void testGtParentDegrees() {
		assertEquals(parentDegrees, testSubScale.getParentDegrees());
	}
	
	@Test
	public void testGetFirstDegree() {
		
		// first degree
		Note firstDegree = testSubScale.getDegree(1);
		assertEquals("1", firstDegree.getName());
		assertEquals(new Double(27.5), firstDegree.getFrequencyBase());
		assertEquals(new Integer(4), firstDegree.getFrequencyLevel());
		
	}

	@Test
	public void testGetSecondDegree() {
		
		// second degree
		Note secondDegree = testSubScale.getDegree(2);
		Note secondDegreeInParent = parentScale.getDegree(4);
		
		// The name does not change
		assertEquals("4", secondDegree.getName());
		assertEquals(secondDegreeInParent.getFrequencyBase(), secondDegree.getFrequencyBase());
		assertEquals(secondDegreeInParent.getFrequencyLevel(), secondDegree.getFrequencyLevel());
		
	}

}
