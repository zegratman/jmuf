package org.jmuf.sample.classic.pythagorean;

/**
 * Pythagorean scale constants
 */
public abstract class PythagoreanConstants {

    /** First degree : second flat */
    public static final Double SECOND_FLAT = 2187./2048.;

    /** Second degree : second */
    public static final Double SECOND = 9./8.;

    /** Third degree : third minor */
    public static final Double THIRD_MINOR = 19683./16384.;

    /** Fourth degree : third major */
    public static final Double THIRD_MAJOR = 81./64.;

    /** Fifth degree : fourth */
    public static final Double FOURTH = 177147./131072.;

    /** Sixth degree : flat fifth */
    public static final Double FIFTH_FLAT = 729./512.;

    /** Seventh degree : fifth */
    public static final Double FIFTH = 3./2.;

    /** Eighth degree : minor sixth */
    public static final Double SIXTH_FLAT = 6461./4096.;

    /** Ninth degree : major sixth */
    public static final Double SIXTH = 27./16.;

    /** Tenth degree : minor seventh */
    public static final Double SEVENTH_FLAT = 59049./32768.;

    /** Eleventh degree : major seventh */
    public static final Double SEVENTH = 243./128.;

    /** Twelfth degree : octave */
    public static final Double OCTAVE = 2.;

    /** Pythagorean comma */
    public static  final Double PYTHAGOREAN_COMMA = 531441./262144.;

    /** Enumeration of ratios */
    public static enum PythagoreanInterval {
        IIb(SECOND_FLAT),
        II(SECOND),
        IIIm(THIRD_MINOR),
        III(THIRD_MAJOR),
        IV(FOURTH),
        Vb(FIFTH_FLAT),
        V(FIFTH),
        VIm(SIXTH_FLAT),
        VI(SIXTH),
        VIIm(SEVENTH_FLAT),
        VII(SEVENTH);

        private final Double ratio;

        private PythagoreanInterval(Double ratio) {
            this.ratio = ratio;
        }

        public Double getRatio() {
            return ratio;
        }
    }

}
