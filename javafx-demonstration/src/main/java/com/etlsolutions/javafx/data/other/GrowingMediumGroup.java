package com.etlsolutions.javafx.data.other;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import java.util.Objects;

/**
 *
 * @author zc
 */
public class GrowingMediumGroup {
    
    private ObservableListWrapperA<GrowingMedium> growingMediums;

    public GrowingMediumGroup() {
        
    }

    public GrowingMediumGroup(ObservableListWrapperA<GrowingMedium> growingMediums) {
        this.growingMediums = new ObservableListWrapperA<>(growingMediums);
    }

    public ObservableListWrapperA<GrowingMedium> getGrowingMediums() {
        return growingMediums;
    }

    public void setGrowingMediums(ObservableListWrapperA<GrowingMedium> growingMediums) {
        this.growingMediums = growingMediums;
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
