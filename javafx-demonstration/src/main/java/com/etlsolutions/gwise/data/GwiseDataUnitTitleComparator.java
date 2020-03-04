package com.etlsolutions.gwise.data;

import java.util.Comparator;

/**
 *
 * @author zc
 */
public class GwiseDataUnitTitleComparator implements Comparator<GwiseDataUnit> {

    @Override
    public int compare(GwiseDataUnit d1, GwiseDataUnit d2) {
        return d1.getTitle().toLowerCase().compareTo(d2.getTitle().toLowerCase());
    }
}
