/**
 * 
 */
package org.jmuf.core.api.factory;

import java.util.Set;

import org.jmuf.core.api.note.Scale;
import org.jmuf.core.api.note.SubScale;

/**
 * This factory can be used to instantiate a SubScale from a scale.
 * @author zegratman
 * @version $Id
 */
public final class SubScaleFactory {

    /**
     * Create a subscale from a parent scale.
     * @param subScaleName the subscale name
     * @param parentScale the parent sclae
     * @param parentDegrees the parent degrees that will compose the subscale
     * @return the subscale
     */
    public SubScale createSubScale(final String subScaleName, final Scale parentScale,
            final Set<Integer> parentDegrees) {
        return new SubScale(subScaleName, parentScale, parentDegrees);
    }

}
