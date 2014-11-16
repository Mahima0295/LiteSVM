package com.wanasit.litesvm;

import com.wanasit.litesvm.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by wanasit on 11/15/14.
 */
public class Vectors {

    private static class ArrayListVector extends ArrayList<Double> implements Vector {

        public ArrayListVector(int size) {
            super(size);
        }

        public ArrayListVector(Collection<Double> data) {
            super(data);
        }

        public ArrayListVector(double... data) {
            super(data.length);
            for (int i=0; i<data.length; i++) this.add(data[i]);
        }
    }

    public static Vector newVector(int size) {
        Vector x = new ArrayListVector(size);
        for (int i=0; i<size; i++) x.add(0.0);
        return x;
    }

    public static Vector newVector(Collection<Double> data) {
        return new ArrayListVector(data);
    }

    public static Vector newVector(double... data) {
        return new ArrayListVector(data);
    }

}
