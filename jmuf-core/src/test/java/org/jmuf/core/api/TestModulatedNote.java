package org.jmuf.core.api;

import org.jmuf.core.api.exception.JmufCoreException;
import org.jmuf.core.api.modulation.ModulatedNote;
import org.jmuf.core.api.modulation.NoteModulation;
import org.jmuf.core.api.note.Note;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link Note} base class
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
     * {@link ModulatedNote#getNoteModulation()}
     */
    @Test
    public void testGetNodeModulation() {
        final Double testDouble = (new Random()).nextDouble();
        assertEquals(testDouble, testReferenceNote.getNoteModulation().apply(testDouble));
    }

    /**
     * Test method for
     * {@link ModulatedNote#setNoteModulation(NoteModulation)}
     */
    @Test
    public void testSetNodeModulation() {
        final Double testDouble = (new Random()).nextDouble();
        testReferenceNote.setNoteModulation(t -> t*t);
        assertEquals(new Double(testDouble * testDouble), testReferenceNote.getNoteModulation().apply(testDouble));
    }

    /**
     * Test method for
     * {@link ModulatedNote#composeModulation(NoteModulation)}
     */
    @Test
    public void testComposeModulation() {
        final Double testDouble = (new Random()).nextDouble();
        testReferenceNote.composeModulation(t -> t*t);
        assertEquals(new Double(testDouble * testDouble), testReferenceNote.getNoteModulation().apply(testDouble));
    }

  }
