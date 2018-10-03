package com.etlsolutions.javafx.data;

import com.etlsolutions.javafx.data.plant.GrowingMedium;
import java.util.List;
import java.util.Objects;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class GrowingMediumGroup {
    
    private final ObservableListWrapperA<GrowingMedium> growingMediums;

    public GrowingMediumGroup() {
        growingMediums = new ObservableListWrapperA<>();
    }

    public GrowingMediumGroup(List<GrowingMedium> growingMediums) {
        this.growingMediums = new ObservableListWrapperA<>(growingMediums);
    }

    public ObservableList<GrowingMedium> getGrowingMediums() {
        return growingMediums;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.growingMediums);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GrowingMediumGroup other = (GrowingMediumGroup) obj;
        return Objects.equals(this.growingMediums, other.growingMediums);
    }
    
}