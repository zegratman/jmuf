package org.jmuf.core.test;

import org.jmuf.core.api.JmufCore;
import org.jmuf.core.api.exception.JmufCoreException;
import org.jmuf.core.api.note.Note;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Test for {@link Note} base class
 * 
 * @author zegratman
 * @since 29/09/2015
 * @version 1.0
 */
public class TestNote {

    private static final String TEST_NOTE_NAME = "Gb";
    private static final Double TEST_NOTE_BASEFREQ = 25.23456;
    private static final Double TEST_NOTE_LOW_BF = 20.14263;
    private static final Double TEST_NOTE_BAD_BF = 66.6666;
    private static final Integer TEST_NOTE_LEVEL = 4;
    private static final Integer TEST_NOTE_HIGH_LEVEL = 6;
    private static final Integer TEST_NOTE_BAD_LEVEL = -2;
    private static final Double TEST_NOTE_REALFREQUENCY = 403.75296;

    private Note testReferenceNote;

    private Note testLowerNote;

    private Note testHigherNote;

    @Before
    public void setUp() throws JmufCoreException {

        // init
        JmufCore.init();

        MockitoAnnotations.initMocks(this);

        testReferenceNote = new Note();
        testReferenceNote.setName(TEST_NOTE_NAME);
        testReferenceNote.setFrequencyBase(TEST_NOTE_BASEFREQ);
        testReferenceNote.setFrequencyLevel(TEST_NOTE_LEVEL);

        // mock lower note
        testLowerNote = new Note();
        testLowerNote.setName(TEST_NOTE_NAME);
        testLowerNote.setFrequencyBase(TEST_NOTE_LOW_BF);
        testLowerNote.setFrequencyLevel(TEST_NOTE_LEVEL);

        // mock higher note
        testHigherNote = new Note();
        testHigherNote.setName(TEST_NOTE_NAME);
        testHigherNote.setFrequencyBase(TEST_NOTE_BASEFREQ);
        testHigherNote.setFrequencyLevel(TEST_NOTE_HIGH_LEVEL);

    }

    /**
     * Test method for
     * {@link Note#setFrequencyBase(java.lang.Double)}
     * .
     */
    @Test
    public void testSetFrequencyBase() {
        // test that exception is thrown
        boolean exceptionThrown = false;
        try {
            testReferenceNote.setFrequencyBase(TEST_NOTE_BAD_BF);
        } catch (JmufCoreException e) {
            exceptionThrown = true;
        } finally {
            assertTrue(exceptionThrown);
        }
    }

    /**
     * Test method for
     * {@link Note#setFrequencyLevel(java.lang.Integer)}
     * .
     */
    @Test
    public void testSetFrequencyLevel() {
        // test that exception is thrown
        boolean exceptionThrown = false;
        try {
            testReferenceNote.setFrequencyLevel(TEST_NOTE_BAD_LEVEL);
        } catch (JmufCoreException e) {
            exceptionThrown = true;
        } finally {
            assertTrue(exceptionThrown);
        }
    }

    /**
     * Test method for
     * {@link Note#compareTo(org.jmuf.core.api.note.Note)}.
     */
    @Test
    public void testCompareTo() {

        // case 1 : note lower with frequency level
        assertEquals(-1, testReferenceNote.compareTo(testHigherNote));

        // case 2 : note higher in base frequency
        assertEquals(1, testReferenceNote.compareTo(testLowerNote));

    }

    /**
     * Test method for
     * {@link org.jmuf.core.api.note.Note#getRealFrequency()(org.jmuf.core.api.note.Note)}.
     */
    @Test
    public void testgetRealFrequency() {
        assertEquals(TEST_NOTE_REALFREQUENCY, testReferenceNote.getRealFrequency());
    }



}
