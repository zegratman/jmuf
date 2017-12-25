package org.jmuf.core.api.exception;

/**
 * Base class for JMUF exceptions.
 * @author zegratman
 * @version $Id
 */
public class JmufCoreException extends Exception {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 4270728792502403871L;

	/**
	 * Message line header.
	 */
	private static final String MESSAGE_HEADER = "JMUF_CORE >>> ";
	
	/**
	 * Base constructor.
	 */
	public JmufCoreException() {
		super();
	}

	/**
	 * Constructor.
	 * @param arg0 message
	 * @param arg1 exception
	 * @param arg2 flag
	 * @param arg3 flag
	 */
	public JmufCoreException(final String arg0, final Throwable arg1, final boolean arg2, final boolean arg3) {
		super(MESSAGE_HEADER + arg0, arg1, arg2, arg3);
	}

	/**
	 * Constructor.
	 * @param arg0 message
	 * @param arg1 exception
	 */
	public JmufCoreException(final String arg0, final Throwable arg1) {
		super(MESSAGE_HEADER + arg0, arg1);
	}

	/**
	 * Constructor.
	 * @param arg0 message
	 */
	public JmufCoreException(final String arg0) {
		super(MESSAGE_HEADER + arg0);
	}

	/**
	 * Constructor.
	 * @param arg0 exception
	 */
	public JmufCoreException(final Throwable arg0) {
		super(arg0);
	}

}
