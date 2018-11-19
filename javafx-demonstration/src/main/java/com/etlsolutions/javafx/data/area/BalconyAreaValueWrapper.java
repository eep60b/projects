package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;

/**
 *
 * @author Zhipeng
 */
public class BalconyAreaValueWrapper implements AreaSpecialValueWrapper {
    
    private final ObservableListWrapperA<ContainerSet> containerSets;
    private final ObservableListWrapperA<SingleContainer> singleContainers;
    private final ObservableListWrapperA<CustomSubArea> customSubareas;

    public BalconyAreaValueWrapper(ObservableListWrapperA<ContainerSet> containerSets, ObservableListWrapperA<SingleContainer> singleContainers, ObservableListWrapperA<CustomSubArea> customSubareas) {
        this.customSubareas = new ObservableListWrapperA<>(customSubareas);        
        this.containerSets = new ObservableListWrapperA<>(containerSets);
        this.singleContainers = new ObservableListWrapperA<>(singleContainers);
    }

     public BalconyAreaValueWrapper(BalconyArea area){
         this(area.getContainerSets(), area.getSingleContainers(), area.getCustomSubareas());
     }
    
    public ObservableListWrapperA<ContainerSet> getContainerSets() {
        return containerSets;
    }

    public ObservableListWrapperA<SingleContainer> getSingleContainers() {
        return singleContainers;
    }

    public ObservableListWrapperA<CustomSubArea> getCustomSubareas() {
        return customSubareas;
    }

    @Override
    public AreaType getType() {
        return AreaType.BALCONY;
    }
}
