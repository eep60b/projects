package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import javafx.scene.input.DataFormat;

/**
 *
 * @author zc
 */
public class ExtendeeDataFormat extends DataFormat {

    public static final DataFormat DATA_UNIT = new DataFormat(DataUnit.class.getName());
    
    public static final DataFormat PLANT_SUBGROUP = new DataFormat(PlantSubGroup.class.getName());
    
    public static final DataFormat SUB_AREA = new DataFormat(SubArea.class.getName());
    
}
