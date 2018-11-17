package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.Room;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;

/**
 *
 * @author Zhipeng
 */
public class IndoorAreaValueWrapper {

    private ObservableListWrapperA<ContainerSet> containerSets;
    private ObservableListWrapperA<SingleContainer> singleContainers;
    private ObservableListWrapperA<Room> rooms;
    private ObservableListWrapperA<CustomSubArea> customSubareas;
}
