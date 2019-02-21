package com.etlsolutions.javafx.data;

import java.util.Comparator;

/**
 *
 * @author zc
 */
public class DataUnitTitleComparator implements Comparator<DataUnit> {

    @Override
    public int compare(DataUnit d1, DataUnit d2) {
        return d1.getTitle().toLowerCase().compareTo(d2.getTitle().toLowerCase());
    }
}
