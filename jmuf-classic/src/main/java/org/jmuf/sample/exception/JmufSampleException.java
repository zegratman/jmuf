package org.jmuf.sample.exception;

import org.jmuf.core.api.exception.JmufCoreException;

/**
 * Exception for sample library.
 * @author zegratman
 * @since 21/12/2015
 * @version 1.0
 */
public class JmufSampleException extends JmufCoreException {

	/**
	 * serial ID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Message line header.
	 */
	private static final String MESSAGE_HEADER = "JMUF_SAMPLE >>> ";
	
	/**
	 * Base constructor.
	 */
	public JmufSampleException() {
		super();
	}

	/**
	 * Constructor.
	 * @param arg0 message
	 * @param arg1 exception
	 * @param arg2 flag
	 * @param arg3 flag
	 */
	public JmufSampleException(final String arg0, final Throwable arg1, final boolean arg2, final boolean arg3) {
		super(MESSAGE_HEADER + arg0, arg1, arg2, arg3);
	}

	/**
	 * Constructor.
	 * @param arg0 message
	 * @param arg1 exception
	 */
	public JmufSampleException(final String arg0, final Throwable arg1) {
		super(MESSAGE_HEADER + arg0, arg1);
	}

	/**
	 * Constructor.
	 * @param arg0 message
	 */
	public JmufSampleException(final String arg0) {
		super(MESSAGE_HEADER + arg0);
	}

	/**
	 * Constructor.
	 * @param arg0 exception
	 */
	public JmufSampleException(final Throwable arg0) {
		super(arg0);
	}

}
