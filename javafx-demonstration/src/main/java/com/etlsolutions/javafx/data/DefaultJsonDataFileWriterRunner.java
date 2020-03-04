package com.etlsolutions.javafx.data;

import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.etlsolutions.javafx.data.other.GrowingMediumGroup;
import com.etlsolutions.javafx.data.other.GrowingMediumSpecialValueWrapper;

/**
 *
 * @author zc
 */
public class DefaultJsonDataFileWriterRunner {
    
    private final Object[] objects;

    public DefaultJsonDataFileWriterRunner() {

        
        //Growing mediums
        GrowingMedium loam = new GrowingMedium(501, new GrowingMediumSpecialValueWrapper("Loamy Soil", "", new ObservableListWrapperA<ImageLink>(), null, "", 32, 32, 16, 20, 0, 20, 7.0, true));
        GrowingMedium sandySoll = new GrowingMedium(502, new GrowingMediumSpecialValueWrapper("Sandy Soil", "", new ObservableListWrapperA<ImageLink>(), null, "", 55, 35, 5, 5, 0, 5, 6.5, true));
        GrowingMedium siltSoil = new GrowingMedium(503, new GrowingMediumSpecialValueWrapper("Silty Soil", "", new ObservableListWrapperA<ImageLink>(), null, "", 25, 50, 5, 10, 0, 10, 6.8, true));
        GrowingMedium peatSoil = new GrowingMedium(504, new GrowingMediumSpecialValueWrapper("Peaty Soil", "", new ObservableListWrapperA<ImageLink>(), null, "", 10, 10, 60, 10, 0, 10, 7.0, true));
        GrowingMedium lightClaySoil = new GrowingMedium(505, new GrowingMediumSpecialValueWrapper("Clay Soil (light)", "", new ObservableListWrapperA<ImageLink>(), null, "", 15, 15, 45, 15, 0, 10, 7.0, true));
        GrowingMedium heavyClaySoil = new GrowingMedium(506, new GrowingMediumSpecialValueWrapper("Clay Soil (heavy)", "", new ObservableListWrapperA<ImageLink>(), null, "", 8, 8, 54, 10, 0, 20, 7.0, true));
        GrowingMedium chalkySoil = new GrowingMedium(507, new GrowingMediumSpecialValueWrapper("Chalky Soil", "", new ObservableListWrapperA<ImageLink>(), null, "", 28, 28, 14, 10, 20, 10, 8.0, true));
        GrowingMedium multipurposeCompost = new GrowingMedium(508, new GrowingMediumSpecialValueWrapper("Multipurpose Compost", "", new ObservableListWrapperA<ImageLink>(), null, "", 0, 0, 0, 80, 0, 20, 5.2, true));
        GrowingMedium ericaceousCompost = new GrowingMedium(509, new GrowingMediumSpecialValueWrapper("Ericaceous Compost", "", new ObservableListWrapperA<ImageLink>(), null, "", 28, 28, 14, 10, 20, 10, 8.0, true));
        GrowingMedium stonySoil = new GrowingMedium(510, new GrowingMediumSpecialValueWrapper("Stony Soil", "", new ObservableListWrapperA<ImageLink>(), null, "", 30, 10, 0, 5, 50, 5, 7.0, true));
        GrowingMedium plantLiquidCulture = new GrowingMedium(511, new GrowingMediumSpecialValueWrapper("Plant Liquid Culture", "", new ObservableListWrapperA<ImageLink>(), null, "", 0, 0, 0, 0, 0, 100, 15, true));
        GrowingMedium johnInnes1 = new GrowingMedium(512, new GrowingMediumSpecialValueWrapper("John Innes No. 1", "", new ObservableListWrapperA<ImageLink>(), null, "", 23.333, 23.33, 28.34, 25, 0, 10, 7.0, true));
        GrowingMedium johnInnes2 = new GrowingMedium(513, new GrowingMediumSpecialValueWrapper("John Innes No. 2", "", new ObservableListWrapperA<ImageLink>(), null, "", 23.333, 23.33, 28.34, 25, 0, 10, 7.0, true));
        GrowingMedium johnInnes3 = new GrowingMedium(514, new GrowingMediumSpecialValueWrapper("John Innes No. 3", "", new ObservableListWrapperA<ImageLink>(), null, "", 23.333, 23.33, 28.34, 25, 0, 10, 7.0, true));
        GrowingMedium johnInnesSeeds = new GrowingMedium(515, new GrowingMediumSpecialValueWrapper("John Innes Seeds", "", new ObservableListWrapperA<ImageLink>(), null, "", 45, 20, 10, 25, 0, 10, 7.0, true));
        GrowingMedium johnInnesPotting = new GrowingMedium(516, new GrowingMediumSpecialValueWrapper("John Innes Potting", "", new ObservableListWrapperA<ImageLink>(), null, "", 23.333, 23.33, 28.34, 25, 0, 10, 7.0, true));     
        GrowingMediumGroup growingMediumGroup = new GrowingMediumGroup(new ObservableListWrapperA<>(loam, sandySoll, siltSoil, peatSoil, lightClaySoil, heavyClaySoil, chalkySoil, multipurposeCompost,
                ericaceousCompost, stonySoil, plantLiquidCulture, johnInnes1, johnInnes2, johnInnes3, johnInnesSeeds, johnInnesPotting));

        objects = new Object[]{growingMediumGroup};
    }

    public void write() throws Exception {
        new DefaultJsonDataFileWriter().write(objects);
    }

}
