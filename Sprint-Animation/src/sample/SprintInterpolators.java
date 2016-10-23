package sample;

import javafx.animation.Interpolator;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * List of interpolators:
 * BackInterpolator
 * BounceInterpolator
 * CircularInterpolator
 * CubicInterpolator
 * ElasticInterpolator
 * ExponentialInterpolator
 * QuadraticInterpolator
 * QuarticInterpolator
 * QuinticInterpolator
 * SineInterpolator
 */

public class SprintInterpolators {

    // Interpolator Constants
    final static Interpolator BACK = new BackInterpolator();
    final static Interpolator BOUNCE = new BounceInterpolator();
    final static Interpolator CIRCULAR = new CircularInterpolator();
    final static Interpolator CUBIC = new CubicInterpolator();
    final static Interpolator ELASTIC = new ElasticInterpolator();
    final static Interpolator EXPONENTIAL = new ExponentialInterpolator();
    final static Interpolator QUADRATIC = new QuadraticInterpolator();
    final static Interpolator QUINTIC = new QuinticInterpolator();
    final static Interpolator SINE = new SineInterpolator();

}

/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013, Christian Schudt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


/**
 * Defines the three easing modes, ease-in, ease-out and ease-both.
 *
 * @author Christian Schudt
 */
enum EasingMode {
    /**
     *
     */
    EASE_IN,
    /**
     *
     */
    EASE_OUT,
    /**
     *
     */
    EASE_BOTH
}

/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013, Christian Schudt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * The abstract base class for all easing interpolators.
 *
 * @author Christian Schudt
 */
abstract class EasingInterpolator extends Interpolator {

    /**
     * The easing mode.
     */
    private ObjectProperty<EasingMode> easingMode = new SimpleObjectProperty<>(EasingMode.EASE_OUT);

    /**
     * Constructs the interpolator with a specific easing mode.
     *
     * @param easingMode The easing mode.
     */
    public EasingInterpolator(EasingMode easingMode) {
        this.easingMode.set(easingMode);
    }

    /**
     * The easing mode property.
     *
     * @return The property.
     * @see #getEasingMode()
     * @see #setEasingMode(EasingMode)
     */
    public ObjectProperty<EasingMode> easingModeProperty() {
        return easingMode;
    }

    /**
     * Gets the easing mode.
     *
     * @return The easing mode.
     * @see #easingModeProperty()
     */
    public EasingMode getEasingMode() {
        return easingMode.get();
    }

    /**
     * Sets the easing mode.
     *
     * @param easingMode The easing mode.
     * @see #easingModeProperty()
     */
    public void setEasingMode(EasingMode easingMode) {
        this.easingMode.set(easingMode);
    }

    /**
     * Defines the base curve for the interpolator.
     * The base curve is then transformed into an easing-in, easing-out easing-both curve.
     *
     * @param v The normalized value/time/progress of the interpolation (between 0 and 1).
     * @return The resulting value of the function, should return a value between 0 and 1.
     * @see Interpolator#curve(double)
     */
    protected abstract double baseCurve(final double v);

    /**
     * Curves the function depending on the easing mode.
     *
     * @param v The normalized value (between 0 and 1).
     * @return The resulting value of the function.
     */
    @Override
    protected final double curve(final double v) {
        switch (easingMode.get()) {
            case EASE_IN:
                return baseCurve(v);
            case EASE_OUT:
                return 1 - baseCurve(1 - v);
            case EASE_BOTH:
                if (v <= 0.5) {
                    return baseCurve(2 * v) / 2;
                } else {
                    return (2 - baseCurve(2 * (1 - v))) / 2;
                }

        }
        return baseCurve(v);
    }
}


/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013, Christian Schudt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * This interpolator simulates an elastic behavior.
 * <p/>
 * The following curve illustrates the interpolation.
 * </p>
 * <svg style="width:300px;" xmlns="http://www.w3.org/2000/svg" viewBox="-2 -40 124 140">
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="0" x2="0" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="6" x="2">x</text>
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="60" x2="120" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="57" x="115">t</text>
 * <path style="fill: rgba(255, 255, 255, 0);stroke: black;stroke-width: 2px;"
 * d="M0,60 L1.2,54.8 2.4,47.7 3.6,39.4 4.8,30.4 6.0,21.2 7.2,12.2 8.4,3.9 9.6,-3.6 10.8,-9.9 12.0,-15.0 13.2,-18.7 14.4,-21.1 15.6,-22.3 16.8,-22.2 18.0,-21.2 19.2,-19.4 20.4,-16.9 21.6,-13.9 22.8,-10.8 24.0,-7.5 25.2,-4.3 26.4,-1.4 27.6,1.3 28.8,3.5 30.0,5.3 31.2,6.6 32.4,7.5 33.6,7.9 34.8,7.9 36.0,7.5 37.2,6.8 38.4,6.0 39.6,4.9 40.8,3.8 42.0,2.7 43.2,1.5 44.4,0.5 45.6,-0.5 46.8,-1.2 48.0,-1.9 49.2,-2.3 50.4,-2.6 51.6,-2.8 52.8,-2.8 54.0,-2.7 55.2,-2.4 56.4,-2.1 57.6,-1.7 58.8,-1.3 60.0,-0.9 61.2,-0.5 62.4,-0.2 63.6,0.2 64.8,0.4 66.0,0.7 67.2,0.8 68.4,0.9 69.6,1.0 70.8,1.0 72.0,0.9 73.2,0.9 74.4,0.7 75.6,0.6 76.8,0.5 78.0,0.3 79.2,0.2 80.4,0.1 81.6,-0.1 82.8,-0.2 84.0,-0.2 85.2,-0.3 86.4,-0.3 87.6,-0.3 88.8,-0.3 90.0,-0.3 91.2,-0.3 92.4,-0.3 93.6,-0.2 94.8,-0.2 96.0,-0.1 97.2,-0.1 98.4,-0.0 99.6,0.0 100.8,0.1 102.0,0.1 103.2,0.1 104.4,0.1 105.6,0.1 106.8,0.1 108.0,0.1 109.2,0.1 110.4,0.1 111.6,0.1 112.8,0.1 114.0,0.0 115.2,0.0 116.4,0.0 117.6,-0.0 118.8,-0.0 120.0,0.0"/>
 * </svg>
 * <p/>
 * The math in this class is taken from
 * <a href="http://www.robertpenner.com/easing/">http://www.robertpenner.com/easing/</a>.
 *
 * @author Christian Schudt
 */
class ElasticInterpolator extends EasingInterpolator {

    /**
     * The amplitude.
     */
    private DoubleProperty amplitude = new SimpleDoubleProperty(this, "amplitude", 1);

    /**
     * The number of oscillations.
     */
    private DoubleProperty oscillations = new SimpleDoubleProperty(this, "oscillations", 3);

    /**
     * Default constructor. Initializes the interpolator with ease out mode.
     */
    public ElasticInterpolator() {
        this(EasingMode.EASE_OUT);
    }

    /**
     * Constructs the interpolator with a specific easing mode.
     *
     * @param easingMode The easing mode.
     */
    public ElasticInterpolator(EasingMode easingMode) {
        super(easingMode);
    }

    /**
     * Sets the easing mode.
     *
     * @param easingMode The easing mode.
     * @see #easingModeProperty()
     */
    public ElasticInterpolator(EasingMode easingMode, double amplitude, double oscillations) {
        super(easingMode);
        this.amplitude.set(amplitude);
        this.oscillations.set(oscillations);
    }

    /**
     * The oscillations property. Defines number of oscillations.
     *
     * @return The property.
     * @see #getOscillations()
     * @see #setOscillations(double)
     */
    public DoubleProperty oscillationsProperty() {
        return oscillations;
    }

    /**
     * The amplitude. The minimum value is 1. If this value is < 1 it will be set to 1 during animation.
     *
     * @return The property.
     * @see #getAmplitude()
     * @see #setAmplitude(double)
     */
    public DoubleProperty amplitudeProperty() {
        return amplitude;
    }

    /**
     * Gets the amplitude.
     *
     * @return The amplitude.
     * @see #amplitudeProperty()
     */
    public double getAmplitude() {
        return amplitude.get();
    }

    /**
     * Sets the amplitude.
     *
     * @param amplitude The amplitude.
     * @see #amplitudeProperty()
     */
    public void setAmplitude(final double amplitude) {
        this.amplitude.set(amplitude);
    }

    /**
     * Gets the number of oscillations.
     *
     * @return The oscillations.
     * @see #oscillationsProperty()
     */
    public double getOscillations() {
        return oscillations.get();
    }

    /**
     * Sets the number of oscillations.
     *
     * @param oscillations The oscillations.
     * @see #oscillationsProperty()
     */
    public void setOscillations(final double oscillations) {
        this.oscillations.set(oscillations);
    }

    @Override
    protected double baseCurve(double v) {
        if (v == 0) {
            return 0;
        }
        if (v == 1) {
            return 1;
        }
        double p = 1.0 / oscillations.get();
        double a = amplitude.get();
        double s;
        if (a < Math.abs(1)) {
            a = 1;
            s = p / 4;
        } else {
            s = p / (2 * Math.PI) * Math.asin(1 / a);
        }
        return -(a * Math.pow(2, 10 * (v -= 1)) * Math.sin((v - s) * (2 * Math.PI) / p));
    }
}


/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013, Christian Schudt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


/**
 * An exponential interpolator.
 * <p/>
 * This interpolator accelerates very fast and decelerates very late.
 * <p/>
 * The following curve illustrates the interpolation.
 * </p>
 * <svg style="width:300px;" xmlns="http://www.w3.org/2000/svg" viewBox="-2 -40 124 140">
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="0" x2="0" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="6" x="2">x</text>
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="60" x2="120" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="57" x="115">t</text>
 * <path style="fill: rgba(255, 255, 255, 0);stroke: black;stroke-width: 2px;"
 * d="M0,60 L1.2,56.0 2.4,52.2 3.6,48.7 4.8,45.5 6.0,42.4 7.2,39.6 8.4,36.9 9.6,34.5 10.8,32.2 12.0,30.0 13.2,28.0 14.4,26.1 15.6,24.4 16.8,22.7 18.0,21.2 19.2,19.8 20.4,18.5 21.6,17.2 22.8,16.1 24.0,15.0 25.2,14.0 26.4,13.1 27.6,12.2 28.8,11.4 30.0,10.6 31.2,9.9 32.4,9.2 33.6,8.6 34.8,8.0 36.0,7.5 37.2,7.0 38.4,6.5 39.6,6.1 40.8,5.7 42.0,5.3 43.2,4.9 44.4,4.6 45.6,4.3 46.8,4.0 48.0,3.8 49.2,3.5 50.4,3.3 51.6,3.0 52.8,2.8 54.0,2.7 55.2,2.5 56.4,2.3 57.6,2.2 58.8,2.0 60.0,1.9 61.2,1.7 62.4,1.6 63.6,1.5 64.8,1.4 66.0,1.3 67.2,1.2 68.4,1.2 69.6,1.1 70.8,1.0 72.0,0.9 73.2,0.9 74.4,0.8 75.6,0.8 76.8,0.7 78.0,0.7 79.2,0.6 80.4,0.6 81.6,0.5 82.8,0.5 84.0,0.5 85.2,0.4 86.4,0.4 87.6,0.4 88.8,0.4 90.0,0.3 91.2,0.3 92.4,0.3 93.6,0.3 94.8,0.3 96.0,0.2 97.2,0.2 98.4,0.2 99.6,0.2 100.8,0.2 102.0,0.2 103.2,0.2 104.4,0.1 105.6,0.1 106.8,0.1 108.0,0.1 109.2,0.1 110.4,0.1 111.6,0.1 112.8,0.1 114.0,0.1 115.2,0.1 116.4,0.1 117.6,0.1 118.8,0.1 120.0,0.0"/>
 * </svg>
 * <p/>
 * The math in this class is taken from
 * <a href="http://www.robertpenner.com/easing/">http://www.robertpenner.com/easing/</a>.
 *
 * @author Christian Schudt
 */
class ExponentialInterpolator extends EasingInterpolator {

    /**
     * Default constructor. Initializes the interpolator with ease out mode.
     */
    public ExponentialInterpolator() {
        this(EasingMode.EASE_OUT);
    }

    /**
     * Constructs the interpolator with a specific easing mode.
     *
     * @param easingMode The easing mode.
     */
    public ExponentialInterpolator(EasingMode easingMode) {
        super(easingMode);
    }

    @Override
    protected double baseCurve(double v) {
        return Math.pow(2, 10 * (v - 1));
    }
}

/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013, Christian Schudt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


/**
 * A quadratic interpolator, simply defined by <code>f(x) = x<sup>2</sup></code>.
 * <p/>
 * The following curve illustrates the interpolation.
 * </p>
 * <svg style="width:300px;" xmlns="http://www.w3.org/2000/svg" viewBox="-2 -40 124 140">
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="0" x2="0" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="6" x="2">x</text>
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="60" x2="120" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="57" x="115">t</text>
 * <path style="fill: rgba(255, 255, 255, 0);stroke: black;stroke-width: 2px;"
 * d="M0,60 L1.2,58.8 2.4,57.6 3.6,56.5 4.8,55.3 6.0,54.2 7.2,53.0 8.4,51.9 9.6,50.8 10.8,49.7 12.0,48.6 13.2,47.5 14.4,46.5 15.6,45.4 16.8,44.4 18.0,43.3 19.2,42.3 20.4,41.3 21.6,40.3 22.8,39.4 24.0,38.4 25.2,37.4 26.4,36.5 27.6,35.6 28.8,34.7 30.0,33.8 31.2,32.9 32.4,32.0 33.6,31.1 34.8,30.2 36.0,29.4 37.2,28.6 38.4,27.7 39.6,26.9 40.8,26.1 42.0,25.4 43.2,24.6 44.4,23.8 45.6,23.1 46.8,22.3 48.0,21.6 49.2,20.9 50.4,20.2 51.6,19.5 52.8,18.8 54.0,18.2 55.2,17.5 56.4,16.9 57.6,16.2 58.8,15.6 60.0,15.0 61.2,14.4 62.4,13.8 63.6,13.3 64.8,12.7 66.0,12.1 67.2,11.6 68.4,11.1 69.6,10.6 70.8,10.1 72.0,9.6 73.2,9.1 74.4,8.7 75.6,8.2 76.8,7.8 78.0,7.3 79.2,6.9 80.4,6.5 81.6,6.1 82.8,5.8 84.0,5.4 85.2,5.0 86.4,4.7 87.6,4.4 88.8,4.1 90.0,3.8 91.2,3.5 92.4,3.2 93.6,2.9 94.8,2.6 96.0,2.4 97.2,2.2 98.4,1.9 99.6,1.7 100.8,1.5 102.0,1.4 103.2,1.2 104.4,1.0 105.6,0.9 106.8,0.7 108.0,0.6 109.2,0.5 110.4,0.4 111.6,0.3 112.8,0.2 114.0,0.2 115.2,0.1 116.4,0.1 117.6,0.0 118.8,0.0 120.0,0.0"/>
 * </svg>
 * <p/>
 * The math in this class is taken from
 * <a href="http://www.robertpenner.com/easing/">http://www.robertpenner.com/easing/</a>.
 *
 * @author Christian Schudt
 */
class QuadraticInterpolator extends EasingInterpolator {

    /**
     * Default constructor. Initializes the interpolator with ease out mode.
     */
    public QuadraticInterpolator() {
        this(EasingMode.EASE_OUT);
    }

    /**
     * Constructs the interpolator with a specific easing mode.
     *
     * @param easingMode The easing mode.
     */
    public QuadraticInterpolator(EasingMode easingMode) {
        super(easingMode);
    }

    @Override
    protected double baseCurve(double v) {
        return Math.pow(v, 2);
    }
}


/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013, Christian Schudt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


/**
 * A quadratic interpolator, simply defined by <code>f(x) = x<sup>4</sup></code>.
 * <p/>
 * This interpolator accelerates faster than the {@link CubicInterpolator} and decelerates later.
 * <p/>
 * The following curve illustrates the interpolation.
 * </p>
 * <svg style="width:300px;" xmlns="http://www.w3.org/2000/svg" viewBox="-2 -40 124 140">
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="0" x2="0" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="6" x="2">x</text>
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="60" x2="120" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="57" x="115">t</text>
 * <path style="fill: rgba(255, 255, 255, 0);stroke: black;stroke-width: 2px;"
 * d="M0,60 L1.2,57.6 2.4,55.3 3.6,53.1 4.8,51.0 6.0,48.9 7.2,46.8 8.4,44.9 9.6,43.0 10.8,41.1 12.0,39.4 13.2,37.6 14.4,36.0 15.6,34.4 16.8,32.8 18.0,31.3 19.2,29.9 20.4,28.5 21.6,27.1 22.8,25.8 24.0,24.6 25.2,23.4 26.4,22.2 27.6,21.1 28.8,20.0 30.0,19.0 31.2,18.0 32.4,17.0 33.6,16.1 34.8,15.2 36.0,14.4 37.2,13.6 38.4,12.8 39.6,12.1 40.8,11.4 42.0,10.7 43.2,10.1 44.4,9.5 45.6,8.9 46.8,8.3 48.0,7.8 49.2,7.3 50.4,6.8 51.6,6.3 52.8,5.9 54.0,5.5 55.2,5.1 56.4,4.7 57.6,4.4 58.8,4.1 60.0,3.8 61.2,3.5 62.4,3.2 63.6,2.9 64.8,2.7 66.0,2.5 67.2,2.2 68.4,2.1 69.6,1.9 70.8,1.7 72.0,1.5 73.2,1.4 74.4,1.3 75.6,1.1 76.8,1.0 78.0,0.9 79.2,0.8 80.4,0.7 81.6,0.6 82.8,0.6 84.0,0.5 85.2,0.4 86.4,0.4 87.6,0.3 88.8,0.3 90.0,0.2 91.2,0.2 92.4,0.2 93.6,0.1 94.8,0.1 96.0,0.1 97.2,0.1 98.4,0.1 99.6,0.1 100.8,0.0 102.0,0.0 103.2,0.0 104.4,0.0 105.6,0.0 106.8,0.0 108.0,0.0 109.2,0.0 110.4,0.0 111.6,0.0 112.8,0.0 114.0,0.0 115.2,0.0 116.4,0.0 117.6,0.0 118.8,0.0 120.0,0.0"/>
 * </svg>
 * <p/>
 * The math in this class is taken from
 * <a href="http://www.robertpenner.com/easing/">http://www.robertpenner.com/easing/</a>.
 *
 * @author Christian Schudt
 */
class QuarticInterpolator extends EasingInterpolator {

    /**
     * Default constructor. Initializes the interpolator with ease out mode.
     */
    public QuarticInterpolator() {
        this(EasingMode.EASE_OUT);
    }

    /**
     * Constructs the interpolator with a specific easing mode.
     *
     * @param easingMode The easing mode.
     */
    public QuarticInterpolator(EasingMode easingMode) {
        super(easingMode);
    }

    @Override
    protected double baseCurve(double v) {
        return Math.pow(v, 4);
    }
}


/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013, Christian Schudt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


/**
 * A cubic interpolator, simply defined by <code>f(x) = x<sup>5</sup></code>.
 * <p/>
 * This interpolator accelerates faster than the {@link QuarticInterpolator} and decelerates later.
 * <p/>
 * The following curve illustrates the interpolation.
 * </p>
 * <svg style="width:300px;" xmlns="http://www.w3.org/2000/svg" viewBox="-2 -40 124 140">
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="0" x2="0" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="6" x="2">x</text>
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="60" x2="120" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="57" x="115">t</text>
 * <path style="fill: rgba(255, 255, 255, 0);stroke: black;stroke-width: 2px;"
 * d="M0,60 L1.2,57.1 2.4,54.2 3.6,51.5 4.8,48.9 6.0,46.4 7.2,44.0 8.4,41.7 9.6,39.5 10.8,37.4 12.0,35.4 13.2,33.5 14.4,31.7 15.6,29.9 16.8,28.2 18.0,26.6 19.2,25.1 20.4,23.6 21.6,22.2 22.8,20.9 24.0,19.7 25.2,18.5 26.4,17.3 27.6,16.2 28.8,15.2 30.0,14.2 31.2,13.3 32.4,12.4 33.6,11.6 34.8,10.8 36.0,10.1 37.2,9.4 38.4,8.7 39.6,8.1 40.8,7.5 42.0,7.0 43.2,6.4 44.4,6.0 45.6,5.5 46.8,5.1 48.0,4.7 49.2,4.3 50.4,3.9 51.6,3.6 52.8,3.3 54.0,3.0 55.2,2.8 56.4,2.5 57.6,2.3 58.8,2.1 60.0,1.9 61.2,1.7 62.4,1.5 63.6,1.4 64.8,1.2 66.0,1.1 67.2,1.0 68.4,0.9 69.6,0.8 70.8,0.7 72.0,0.6 73.2,0.5 74.4,0.5 75.6,0.4 76.8,0.4 78.0,0.3 79.2,0.3 80.4,0.2 81.6,0.2 82.8,0.2 84.0,0.1 85.2,0.1 86.4,0.1 87.6,0.1 88.8,0.1 90.0,0.1 91.2,0.0 92.4,0.0 93.6,0.0 94.8,0.0 96.0,0.0 97.2,0.0 98.4,0.0 99.6,0.0 100.8,0.0 102.0,0.0 103.2,0.0 104.4,0.0 105.6,0.0 106.8,0.0 108.0,0.0 109.2,0.0 110.4,0.0 111.6,0.0 112.8,0.0 114.0,0.0 115.2,0.0 116.4,0.0 117.6,0.0 118.8,0.0 120.0,0.0"/>
 * </svg>
 * <p/>
 * The math in this class is taken from
 * <a href="http://www.robertpenner.com/easing/">http://www.robertpenner.com/easing/</a>.
 *
 * @author Christian Schudt
 */
class QuinticInterpolator extends EasingInterpolator {

    /**
     * Default constructor. Initializes the interpolator with ease out mode.
     */
    public QuinticInterpolator() {
        this(EasingMode.EASE_OUT);
    }

    /**
     * Constructs the interpolator with a specific easing mode.
     *
     * @param easingMode The easing mode.
     */
    public QuinticInterpolator(EasingMode easingMode) {
        super(easingMode);
    }

    @Override
    protected double baseCurve(double v) {
        return Math.pow(v, 5);
    }
}

/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013, Christian Schudt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


/**
 * A sinus based interpolator.
 * <p/>
 * The following curve illustrates the interpolation.
 * </p>
 * <svg style="width:300px;" xmlns="http://www.w3.org/2000/svg" viewBox="-2 -40 124 140">
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="0" x2="0" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="6" x="2">x</text>
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="60" x2="120" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="57" x="115">t</text>
 * <path style="fill: rgba(255, 255, 255, 0);stroke: black;stroke-width: 2px;"
 * d="M0,60 L1.2,59.1 2.4,58.1 3.6,57.2 4.8,56.2 6.0,55.3 7.2,54.4 8.4,53.4 9.6,52.5 10.8,51.5 12.0,50.6 13.2,49.7 14.4,48.8 15.6,47.8 16.8,46.9 18.0,46.0 19.2,45.1 20.4,44.2 21.6,43.3 22.8,42.4 24.0,41.5 25.2,40.6 26.4,39.7 27.6,38.8 28.8,37.9 30.0,37.0 31.2,36.2 32.4,35.3 33.6,34.5 34.8,33.6 36.0,32.8 37.2,31.9 38.4,31.1 39.6,30.3 40.8,29.5 42.0,28.7 43.2,27.9 44.4,27.1 45.6,26.3 46.8,25.5 48.0,24.7 49.2,24.0 50.4,23.2 51.6,22.5 52.8,21.8 54.0,21.0 55.2,20.3 56.4,19.6 57.6,18.9 58.8,18.2 60.0,17.6 61.2,16.9 62.4,16.3 63.6,15.6 64.8,15.0 66.0,14.4 67.2,13.8 68.4,13.2 69.6,12.6 70.8,12.0 72.0,11.5 73.2,10.9 74.4,10.4 75.6,9.9 76.8,9.3 78.0,8.8 79.2,8.4 80.4,7.9 81.6,7.4 82.8,7.0 84.0,6.5 85.2,6.1 86.4,5.7 87.6,5.3 88.8,4.9 90.0,4.6 91.2,4.2 92.4,3.9 93.6,3.5 94.8,3.2 96.0,2.9 97.2,2.7 98.4,2.4 99.6,2.1 100.8,1.9 102.0,1.7 103.2,1.4 104.4,1.2 105.6,1.1 106.8,0.9 108.0,0.7 109.2,0.6 110.4,0.5 111.6,0.4 112.8,0.3 114.0,0.2 115.2,0.1 116.4,0.1 117.6,0.0 118.8,0.0 120.0,0.0"/>
 * </svg>
 * <p/>
 * The math in this class is taken from
 * <a href="http://www.robertpenner.com/easing/">http://www.robertpenner.com/easing/</a>.
 *
 * @author Christian Schudt
 */
class SineInterpolator extends EasingInterpolator {

    /**
     * Default constructor. Initializes the interpolator with ease out mode.
     */
    public SineInterpolator() {
        this(EasingMode.EASE_OUT);
    }

    /**
     * Constructs the interpolator with a specific easing mode.
     *
     * @param easingMode The easing mode.
     */
    public SineInterpolator(EasingMode easingMode) {
        super(easingMode);
    }

    @Override
    protected double baseCurve(double v) {
        return -Math.cos(v * (Math.PI / 2)) + 1;
    }
}

/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013, Christian Schudt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


/**
 * A cubic interpolator, simply defined by <code>f(x) = x<sup>3</sup></code>.
 * <p/>
 * This interpolator accelerates faster than the {@link QuadraticInterpolator} and decelerates later.
 * <p/>
 * The following curve illustrates the interpolation.
 * </p>
 * <svg style="width:300px;" xmlns="http://www.w3.org/2000/svg" viewBox="-2 -40 124 140">
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="0" x2="0" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="6" x="2">x</text>
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="60" x2="120" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="57" x="115">t</text>
 * <path style="fill: rgba(255, 255, 255, 0);stroke: black;stroke-width: 2px;"
 * d="M0,60 L1.2,58.2 2.4,56.5 3.6,54.8 4.8,53.1 6.0,51.4 7.2,49.8 8.4,48.3 9.6,46.7 10.8,45.2 12.0,43.7 13.2,42.3 14.4,40.9 15.6,39.5 16.8,38.2 18.0,36.8 19.2,35.6 20.4,34.3 21.6,33.1 22.8,31.9 24.0,30.7 25.2,29.6 26.4,28.5 27.6,27.4 28.8,26.3 30.0,25.3 31.2,24.3 32.4,23.3 33.6,22.4 34.8,21.5 36.0,20.6 37.2,19.7 38.4,18.9 39.6,18.0 40.8,17.2 42.0,16.5 43.2,15.7 44.4,15.0 45.6,14.3 46.8,13.6 48.0,13.0 49.2,12.3 50.4,11.7 51.6,11.1 52.8,10.5 54.0,10.0 55.2,9.4 56.4,8.9 57.6,8.4 58.8,8.0 60.0,7.5 61.2,7.1 62.4,6.6 63.6,6.2 64.8,5.8 66.0,5.5 67.2,5.1 68.4,4.8 69.6,4.4 70.8,4.1 72.0,3.8 73.2,3.6 74.4,3.3 75.6,3.0 76.8,2.8 78.0,2.6 79.2,2.4 80.4,2.2 81.6,2.0 82.8,1.8 84.0,1.6 85.2,1.5 86.4,1.3 87.6,1.2 88.8,1.1 90.0,0.9 91.2,0.8 92.4,0.7 93.6,0.6 94.8,0.6 96.0,0.5 97.2,0.4 98.4,0.3 99.6,0.3 100.8,0.2 102.0,0.2 103.2,0.2 104.4,0.1 105.6,0.1 106.8,0.1 108.0,0.1 109.2,0.0 110.4,0.0 111.6,0.0 112.8,0.0 114.0,0.0 115.2,0.0 116.4,0.0 117.6,0.0 118.8,0.0 120.0,0.0"/>
 * </svg>
 * <p/>
 * The math in this class is taken from
 * <a href="http://www.robertpenner.com/easing/">http://www.robertpenner.com/easing/</a>.
 *
 * @author Christian Schudt
 */
class CubicInterpolator extends EasingInterpolator {

    /**
     * Default constructor. Initializes the interpolator with ease out mode.
     */
    public CubicInterpolator() {
        this(EasingMode.EASE_OUT);
    }

    /**
     * Constructs the interpolator with a specific easing mode.
     *
     * @param easingMode The easing mode.
     */
    public CubicInterpolator(EasingMode easingMode) {
        super(easingMode);
    }

    @Override
    protected double baseCurve(double v) {
        return Math.pow(v, 3);
    }
}

/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013, Christian Schudt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


/**
 * A circular interpolator.
 * <p/>
 * The following curve illustrates the interpolation.
 * </p>
 * <svg style="width:300px;" xmlns="http://www.w3.org/2000/svg" viewBox="-2 -40 124 140">
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="0" x2="0" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="6" x="2">x</text>
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="60" x2="120" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="57" x="115">t</text>
 * <path style="fill: rgba(255, 255, 255, 0);stroke: black;stroke-width: 2px;"
 * d="M0,60 L1.2,51.5 2.4,48.1 3.6,45.4 4.8,43.2 6.0,41.3 7.2,39.5 8.4,37.9 9.6,36.5 10.8,35.1 12.0,33.8 13.2,32.6 14.4,31.5 15.6,30.4 16.8,29.4 18.0,28.4 19.2,27.4 20.4,26.5 21.6,25.7 22.8,24.8 24.0,24.0 25.2,23.2 26.4,22.5 27.6,21.7 28.8,21.0 30.0,20.3 31.2,19.6 32.4,19.0 33.6,18.4 34.8,17.7 36.0,17.2 37.2,16.6 38.4,16.0 39.6,15.5 40.8,14.9 42.0,14.4 43.2,13.9 44.4,13.4 45.6,12.9 46.8,12.5 48.0,12.0 49.2,11.6 50.4,11.1 51.6,10.7 52.8,10.3 54.0,9.9 55.2,9.5 56.4,9.1 57.6,8.8 58.8,8.4 60.0,8.0 61.2,7.7 62.4,7.4 63.6,7.0 64.8,6.7 66.0,6.4 67.2,6.1 68.4,5.8 69.6,5.5 70.8,5.3 72.0,5.0 73.2,4.8 74.4,4.5 75.6,4.3 76.8,4.0 78.0,3.8 79.2,3.6 80.4,3.4 81.6,3.2 82.8,3.0 84.0,2.8 85.2,2.6 86.4,2.4 87.6,2.2 88.8,2.1 90.0,1.9 91.2,1.8 92.4,1.6 93.6,1.5 94.8,1.3 96.0,1.2 97.2,1.1 98.4,1.0 99.6,0.9 100.8,0.8 102.0,0.7 103.2,0.6 104.4,0.5 105.6,0.4 106.8,0.4 108.0,0.3 109.2,0.2 110.4,0.2 111.6,0.1 112.8,0.1 114.0,0.1 115.2,0.0 116.4,0.0 117.6,0.0 118.8,0.0 120.0,0.0"/>
 * </svg>
 * <p/>
 * The math in this class is taken from
 * <a href="http://www.robertpenner.com/easing/">http://www.robertpenner.com/easing/</a>.
 *
 * @author Christian Schudt
 */
class CircularInterpolator extends EasingInterpolator {

    /**
     * Default constructor. Initializes the interpolator with ease out mode.
     */
    public CircularInterpolator() {
        this(EasingMode.EASE_OUT);
    }

    /**
     * Constructs the interpolator with a specific easing mode.
     *
     * @param easingMode The easing mode.
     */
    public CircularInterpolator(EasingMode easingMode) {
        super(easingMode);
    }

    @Override
    protected double baseCurve(double v) {
        return -(Math.sqrt(1 - (v * v)) - 1);
    }
}

/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013, Christian Schudt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


/**
 * This interpolator simulates a bouncing behavior.
 * <p/>
 * The following curve illustrates the interpolation.
 * </p>
 * <svg style="width:300px;" xmlns="http://www.w3.org/2000/svg" viewBox="-2 -40 124 140">
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="0" x2="0" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="6" x="2">x</text>
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="60" x2="120" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="57" x="115">t</text>
 * <path style="fill: rgba(255, 255, 255, 0);stroke: black;stroke-width: 2px;"
 * d="M0,60 L1.2,60.0 2.4,59.8 3.6,59.6 4.8,59.3 6.0,58.9 7.2,58.4 8.4,57.8 9.6,57.1 10.8,56.3 12.0,55.5 13.2,54.5 14.4,53.5 15.6,52.3 16.8,51.1 18.0,49.8 19.2,48.4 20.4,46.9 21.6,45.3 22.8,43.6 24.0,41.8 25.2,40.0 26.4,38.0 27.6,36.0 28.8,33.9 30.0,31.6 31.2,29.3 32.4,26.9 33.6,24.4 34.8,21.8 36.0,19.2 37.2,16.4 38.4,13.5 39.6,10.6 40.8,7.5 42.0,4.4 43.2,1.2 44.4,1.0 45.6,2.6 46.8,4.0 48.0,5.4 49.2,6.7 50.4,7.9 51.6,9.0 52.8,10.0 54.0,10.9 55.2,11.7 56.4,12.4 57.6,13.1 58.8,13.6 60.0,14.1 61.2,14.4 62.4,14.7 63.6,14.9 64.8,15.0 66.0,15.0 67.2,14.9 68.4,14.7 69.6,14.5 70.8,14.1 72.0,13.7 73.2,13.1 74.4,12.5 75.6,11.8 76.8,10.9 78.0,10.0 79.2,9.0 80.4,8.0 81.6,6.8 82.8,5.5 84.0,4.2 85.2,2.7 86.4,1.2 87.6,0.2 88.8,1.0 90.0,1.6 91.2,2.2 92.4,2.7 93.6,3.1 94.8,3.4 96.0,3.6 97.2,3.7 98.4,3.7 99.6,3.7 100.8,3.5 102.0,3.3 103.2,3.0 104.4,2.5 105.6,2.0 106.8,1.4 108.0,0.7 109.2,0.0 110.4,0.4 111.6,0.7 112.8,0.8 114.0,0.9 115.2,0.9 116.4,0.8 117.6,0.6 118.8,0.4 120.0,0.0"/>
 * </svg>
 * <p/>
 * The math in this class is taken from
 * <a href="http://www.robertpenner.com/easing/">http://www.robertpenner.com/easing/</a>.
 *
 * @author Christian Schudt
 */
class BounceInterpolator extends EasingInterpolator {

    /**
     * Default constructor. Initializes the interpolator with ease out mode.
     */
    public BounceInterpolator() {
        this(EasingMode.EASE_OUT);
    }

    /**
     * Constructs the interpolator with a specific easing mode.
     *
     * @param easingMode The easing mode.
     */
    public BounceInterpolator(final EasingMode easingMode) {
        super(easingMode);
    }

    @Override
    protected double baseCurve(final double v) {
        for (double a = 0, b = 1; true; a += b, b /= 2) {
            if (v >= (7 - 4 * a) / 11) {
                return -Math.pow((11 - 6 * a - 11 * v) / 4, 2) + Math.pow(b, 2);
            }
        }
    }
}

/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013, Christian Schudt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * An interpolator which is also known as the "bow" function. It interpolates shortly below 0 or above 1 and then bows back.
 * <p/>
 * The following curve illustrates the interpolation.
 * </p>
 * <svg style="width:300px;" xmlns="http://www.w3.org/2000/svg" viewBox="-2 -40 124 140">
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="0" x2="0" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="6" x="2">x</text>
 * <line style="stroke: rgb(187, 187, 187); stroke-width: 1px;" y2="60" y1="60" x2="120" x1="0"/>
 * <text style="font-size: 12px; fill: rgb(187, 187, 187);" y="57" x="115">t</text>
 * <path style="fill: rgba(255, 255, 255, 0);stroke: black;stroke-width: 2px;"
 * d="M0,60 L1.2,57.2 2.4,54.5 3.6,51.9 4.8,49.3 6.0,46.8 7.2,44.4 8.4,42.1 9.6,39.8 10.8,37.6 12.0,35.5 13.2,33.4 14.4,31.4 15.6,29.5 16.8,27.6 18.0,25.8 19.2,24.0 20.4,22.4 21.6,20.7 22.8,19.2 24.0,17.7 25.2,16.2 26.4,14.8 27.6,13.5 28.8,12.2 30.0,11.0 31.2,9.8 32.4,8.7 33.6,7.6 34.8,6.5 36.0,5.6 37.2,4.6 38.4,3.8 39.6,2.9 40.8,2.1 42.0,1.4 43.2,0.7 44.4,0.0 45.6,-0.6 46.8,-1.2 48.0,-1.7 49.2,-2.2 50.4,-2.7 51.6,-3.2 52.8,-3.6 54.0,-3.9 55.2,-4.2 56.4,-4.5 57.6,-4.8 58.8,-5.1 60.0,-5.3 61.2,-5.4 62.4,-5.6 63.6,-5.7 64.8,-5.8 66.0,-5.9 67.2,-6.0 68.4,-6.0 69.6,-6.0 70.8,-6.0 72.0,-6.0 73.2,-5.9 74.4,-5.8 75.6,-5.8 76.8,-5.7 78.0,-5.6 79.2,-5.4 80.4,-5.3 81.6,-5.1 82.8,-5.0 84.0,-4.8 85.2,-4.6 86.4,-4.4 87.6,-4.3 88.8,-4.1 90.0,-3.8 91.2,-3.6 92.4,-3.4 93.6,-3.2 94.8,-3.0 96.0,-2.8 97.2,-2.6 98.4,-2.4 99.6,-2.2 100.8,-1.9 102.0,-1.8 103.2,-1.6 104.4,-1.4 105.6,-1.2 106.8,-1.0 108.0,-0.9 109.2,-0.7 110.4,-0.6 111.6,-0.4 112.8,-0.3 114.0,-0.2 115.2,-0.2 116.4,-0.1 117.6,-0.0 118.8,-0.0 120.0,0.0"/>
 * </svg>
 * <p/>
 * The math in this class is taken from
 * <a href="http://www.robertpenner.com/easing/">http://www.robertpenner.com/easing/</a>.
 *
 * @author Christian Schudt
 */
class BackInterpolator extends EasingInterpolator {

    private DoubleProperty amplitude = new SimpleDoubleProperty(this, "amplitude", 1.70158);

    /**
     * Default constructor. Initializes the interpolator with ease out mode.
     */
    public BackInterpolator() {
        this(EasingMode.EASE_OUT);
    }

    /**
     * Constructs the interpolator with a specific easing mode.
     *
     * @param easingMode The easing mode.
     */
    public BackInterpolator(EasingMode easingMode) {
        super(easingMode);
    }

    /**
     * Constructs the interpolator with a specific easing mode and an amplitude.
     *
     * @param easingMode The easing mode.
     * @param amplitude  The amplitude.
     */
    public BackInterpolator(EasingMode easingMode, double amplitude) {
        super(easingMode);
        this.amplitude.set(amplitude);
    }

    /**
     * Gets the amplitude. The default value is 1.70158.
     *
     * @return The property.
     * @see #getAmplitude()
     * @see #setAmplitude(double)
     */
    public DoubleProperty amplitudeProperty() {
        return amplitude;
    }

    /**
     * Gets the amplitude.
     *
     * @return The property.
     * @see #amplitudeProperty()
     */
    public double getAmplitude() {
        return amplitude.get();
    }

    /**
     * Sets the amplitude.
     *
     * @param amplitude The amplitude.
     * @see #amplitudeProperty()
     */
    public void setAmplitude(final double amplitude) {
        this.amplitude.set(amplitude);
    }

    @Override
    protected double baseCurve(double v) {
        double s = amplitude.get();
        return v * v * ((s + 1) * v - s);
    }
}