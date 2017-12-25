package org.jmuf.core.api;

import org.jmuf.core.api.exception.JmufCoreException;

import java.io.IOException;
import java.util.Properties;

/**
 * Utility class to initialize the library.
 * The init() method should be called prior to any usage.
 * @author zegratman
 * @version $Id
 */
public abstract class JmufCore {

    /** Initialization flag */
    private static boolean INITIALIZED = false;

    /** JMUF properties */
    private static Properties JMUF_CORE_PROPS = new Properties();

    /** Path to property file */
    private static final String JMUF_CORE_PROPS_FILE = "/jmuf-core.properties";

    /** Lowest note frequency setting key */
    private static final String JMUF_CORE_MINIMAL_FREQUENCY_KEY = "jmuf.lowest.note.frequency";

    /**
     * Method to initialize the library
     * @throws JmufCoreException if a problem occurs reading properties
     */
    public static void init() throws JmufCoreException {
        try {
            JMUF_CORE_PROPS.load(JmufCore.class.getResourceAsStream(JMUF_CORE_PROPS_FILE));
        } catch (IOException e) {
            throw new JmufCoreException("Unable to load properties.", e);
        }
        INITIALIZED = true;
    }

    /**
     * Get the lowest note frequency available.
     * @return the frequency as a double
     * @throws JmufCoreException if library was not initialized.
     */
    public static Double getJmufCoreMinimalBaseFrequency() throws JmufCoreException {
        if (INITIALIZED) {
            return Double.valueOf(JMUF_CORE_PROPS.getProperty(JMUF_CORE_MINIMAL_FREQUENCY_KEY));
        } else {
            throw new JmufCoreException("JMUF is not initialized. Please call JmufCore.init() prior to anything.");
        }
    }

    /**
     * Get the highest base frequency.
     * @return the frequency as a double.
     * @throws JmufCoreException if library was not initialized.
     */
    public static Double getJmufCoreMaximalBaseFrequency() throws JmufCoreException {
        return getJmufCoreMinimalBaseFrequency() * 2;
    }

}
