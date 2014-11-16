package com.wanasit.litesvm;

import java.util.List;

/**
 * Created by wanasit on 11/15/14.
 */
public interface Kernel {
    double product(Vector x1, Vector x2);
}
