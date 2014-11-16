package com.wanasit.litesvm;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestLinears {

    @Test
    public void testHorizontalSamplesWithLinear() throws Exception {

        // Horizontal samples
        final List<BinaryTrainingSample> samples = Lists.newArrayList(
                new BinaryTrainingSample(false, 0, 0),
                new BinaryTrainingSample(false, 1, 0),
                new BinaryTrainingSample(true, 0, 1),
                new BinaryTrainingSample(true, 1, 1)
        );

        final BinaryClassifier classifier = LiteSVM.trainBinaryClassifier(samples, Kernels.Linear());
        assertFalse(classifier.predict(0, 0));
        assertFalse(classifier.predict(0.5, 0));
        assertFalse(classifier.predict(1, 0));

        assertTrue(classifier.predict(0, 1));
        assertTrue(classifier.predict(0.5, 1));
        assertTrue(classifier.predict(1, 1));
    }

    @Test
    public void testVerticalSamplesWithLinear() throws Exception {

        // Horizontal samples
        final List<BinaryTrainingSample> samples = Lists.newArrayList(
                new BinaryTrainingSample(false, 1, 0),
                new BinaryTrainingSample(false, 1, 1),
                new BinaryTrainingSample(true, 0, 0),
                new BinaryTrainingSample(true, 0, 1)
        );

        final BinaryClassifier classifier = LiteSVM.trainBinaryClassifier(samples, Kernels.Linear());
        assertFalse(classifier.predict(1, 0));
        assertFalse(classifier.predict(1, 0.5));
        assertFalse(classifier.predict(1, 1));

        assertTrue(classifier.predict(0, 0));
        assertTrue(classifier.predict(0, 0.5));
        assertTrue(classifier.predict(0, 1));
    }


}