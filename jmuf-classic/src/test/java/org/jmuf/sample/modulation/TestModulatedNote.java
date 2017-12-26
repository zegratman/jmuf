package org.jmuf.sample.modulation;

import org.jmuf.core.api.JmufCore;
import org.jmuf.core.api.exception.JmufCoreException;
import org.jmuf.core.api.modulation.ModulatedNote;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link ModulatedNote} base class
 * 
 * @author zegratman
 * @since 29/09/2015
 * @version 1.0
 */
public class TestModulatedNote {

    private static final String TEST_NOTE_NAME = "Gb";
    private static final Double TEST_NOTE_BASEFREQ = 25.23456;
    private static final Integer TEST_NOTE_LEVEL = 4;

    private ModulatedNote testReferenceNote;

    @Before
    public void setUp() throws JmufCoreException {

        // init
        JmufCore.init();

        testReferenceNote = new ModulatedNote(t -> t);
        testReferenceNote.setName(TEST_NOTE_NAME);
        testReferenceNote.setFrequencyBase(TEST_NOTE_BASEFREQ);
        testReferenceNote.setFrequencyLevel(TEST_NOTE_LEVEL);

    }

    /**
     * Test method for
     * {@link SineModulation}
     */
    @Test
    public void testSineModulation() {
        final Double initDouble = (new Random()).nextDouble();
        final Double testDouble = Math.sin(initDouble);
        testReferenceNote.setNoteModulation(new SineModulation());
        assertEquals(testDouble, testReferenceNote.getNoteModulation().apply(initDouble));
    }

    /**
     * Test method for
     * {@link SineModulation}
     */
    @Test
    public void testSquareModulation() {
        final Double initDouble = (new Random()).nextDouble();
        final Double testDouble = initDouble < 0 ? -1.0e0 : 1.0e0;
        testReferenceNote.setNoteModulation(new SquareModulation());
        assertEquals(testDouble, testReferenceNote.getNoteModulation().apply(initDouble));
    }


  }
