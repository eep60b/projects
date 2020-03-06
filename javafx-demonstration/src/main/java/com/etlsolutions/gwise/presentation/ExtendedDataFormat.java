package com.etlsolutions.gwise.presentation;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.plant.PlantType;
import com.etlsolutions.gwise.data.subarea.GwiseSubarea;
import javafx.scene.input.DataFormat;

/**
 * The ExtendedDataFormat class stores Data format identifiers used as means of
 * identifying the data stored on a clipboard/dragboard.
 *
 * @author zc
 */
public class ExtendedDataFormat extends DataFormat {

    public static final DataFormat DATA_UNIT = new DataFormat(GwiseDataUnit.class.getName());

    public static final DataFormat PLANT_SUBGROUP = new DataFormat(PlantType.class.getName());

    public static final DataFormat SUB_AREA = new DataFormat(GwiseSubarea.class.getName());

}
