package org.jmuf.core.api;

import org.jmuf.core.api.exception.JmufCoreException;
import org.jmuf.core.api.note.Chord;
import org.jmuf.core.api.note.Note;
import org.jmuf.core.api.note.Scale;
import org.jmuf.core.api.factory.ChordFactory;
import org.jmuf.core.api.factory.IntervalFactory;
import org.jmuf.core.api.factory.NoteFactory;
import org.jmuf.core.api.factory.ScaleFactory;
import org.jmuf.core.api.note.Interval;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link Interval} base class
 * 
 * @author zegratman
 * @version 1.0
 * @since 24/10/2015
 */
public class TestChord {

	// api names
	private static final String TEST_CHORD_NAME = "Am";
	private static final String TEST_INTERVAL_HALFTONE_NAME = "half-tone";
	private static final String TEST_SCALE_NAME ="Chromatic";
	
	private static final Double TEST_INTERVAL_RATIO = Math.pow(2, 1.0 / 12.0);
	
	// api factories
	private static final NoteFactory NOTE_FACTORY = new NoteFactory();
	private static final IntervalFactory INTERVAL_FACTORY = new IntervalFactory();
	private static final ScaleFactory SCALE_FACTORY = new ScaleFactory();
	private static final ChordFactory CHORD_FACTORY = new ChordFactory();
	
	private Chord testChord;
	
	@Before
	public void setUp() {
		Interval halfToneInterval = INTERVAL_FACTORY.createInterval(TEST_INTERVAL_HALFTONE_NAME, TEST_INTERVAL_RATIO);
		SCALE_FACTORY.initScale(TEST_SCALE_NAME);
		Note baseNote;
		try {
			JmufCore.init();
			baseNote = NOTE_FACTORY.createNote("A", 440.0);
			SCALE_FACTORY.generateScale(TEST_SCALE_NAME, baseNote, halfToneInterval, 12);
			Scale testScale = SCALE_FACTORY.closeScale(TEST_SCALE_NAME);
			Set<Integer> parentDegrees = new HashSet<>();
			parentDegrees.add(1);
			parentDegrees.add(3);
			parentDegrees.add(4);
			parentDegrees.add(6);
			parentDegrees.add(8);
			parentDegrees.add(9);
			parentDegrees.add(11);
			testChord = CHORD_FACTORY.createChord(TEST_CHORD_NAME, testScale, parentDegrees);
		} catch (JmufCoreException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetFundamental() {
		Note fundamental = testChord.getFundamental();
		assertEquals("1", fundamental.getName());
		assertTrue(Math.abs(27.5e0 - fundamental.getFrequencyBase()) < 1e-6);
		assertTrue(4 == fundamental.getFrequencyLevel());
	}
	
	@Test
	public void testGetName() {
		String chordName = testChord.getName();
		assertEquals(TEST_CHORD_NAME, chordName);
	}

}
