package org.jmuf.sample.classic.pythagorean.scale;

import org.jmuf.core.api.JmufCore;
import org.jmuf.core.api.JmufCoreHelper;
import org.jmuf.core.api.exception.JmufCoreException;
import org.jmuf.core.api.factory.IntervalFactory;
import org.jmuf.core.api.factory.NoteFactory;
import org.jmuf.core.api.factory.ScaleFactory;
import org.jmuf.core.api.note.Interval;
import org.jmuf.core.api.note.Note;
import org.jmuf.core.api.note.Scale;
import org.jmuf.sample.classic.pythagorean.PythagoreanConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Pythagorean scale is the full set of classic pythagorean notes.
 * The scale is generated from the JMUF core tools, then this class wraps
 * the {@link Scale} class.
 *
 * @author zegratman
 * @version $Id
 */
public class PythagoreanScale extends Scale {

    /** Scale name */
    private static final String SCALE_NAME = "CHROMATIC_PYTHAGOREAN_SCALE";

    /** Internal wrapped scale */
    private Scale internalScale;

    /**
     * Constructor
     */
    public PythagoreanScale() {
        super();
    }

    /**
     * Initialization of the internal scale
     */
    private void initInternalScale() {
        try {
            JmufCore.init();

            // creating intervals
            List<Interval> intervals = new ArrayList<>();
            IntervalFactory intervalFactory = JmufCoreHelper.getIntervalFactory();

            for (PythagoreanConstants.PythagoreanInterval inter : PythagoreanConstants.PythagoreanInterval.values()) {
                intervals.add(intervalFactory.createInterval(inter.name(), inter.getRatio()));
            }

            // Base note : A440
            NoteFactory noteFactory = JmufCoreHelper.getNoteFactory();
            Note baseNote = noteFactory.createNote("A", 440.0);

            ScaleFactory scaleFactory = JmufCoreHelper.getScaleFactory();
            scaleFactory.initScale(SCALE_NAME);
            scaleFactory.generateScale(SCALE_NAME, baseNote, intervals);

            // getting final scale
            internalScale = scaleFactory.closeScale(SCALE_NAME);
        } catch (JmufCoreException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Note getDegree(Integer degree) {
        if (internalScale == null) {
            initInternalScale();
        }
        return internalScale.getDegree(degree);
    }

    @Override
    public Set<Integer> getDegrees() {
        if (internalScale == null) {
            initInternalScale();
        }
        return internalScale.getDegrees();
    }
}
