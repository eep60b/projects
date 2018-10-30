package com.etlsolutions.javafx.data;

import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.etlsolutions.javafx.data.other.GrowingMediumFactory;
import com.etlsolutions.javafx.data.other.GrowingMediumGroup;

/**
 *
 * @author zc
 */
public class DefaultJsonDataFileWriterRunner {
    
    private final Object[] objects;

    public DefaultJsonDataFileWriterRunner() {

        
        //Growing mediums
        GrowingMedium loam = GrowingMediumFactory.getInstance().createGrowingMedium(501, "Loamy Soil", "", new ObservableListWrapperA<ImageLink>(), 0, "", new double[]{32, 32, 16, 20, 0, 20, 7.0}, true);
        GrowingMedium sandySoll = GrowingMediumFactory.getInstance().createGrowingMedium(502, "Sandy Soil", "", new ObservableListWrapperA<ImageLink>(), 0, "", new double[]{55, 35, 5, 5, 0, 5, 6.5}, true);
        GrowingMedium siltSoil = GrowingMediumFactory.getInstance().createGrowingMedium(503, "Silty Soil", "", new ObservableListWrapperA<ImageLink>(), 0, "", new double[]{25, 50, 5, 10, 0, 10, 6.8}, true);
        GrowingMedium peatSoil = GrowingMediumFactory.getInstance().createGrowingMedium(504, "Peaty Soil", "", new ObservableListWrapperA<ImageLink>(), 0, "", new double[]{10, 10, 60, 10, 0, 10, 7.0}, true);
        GrowingMedium lightClaySoil = GrowingMediumFactory.getInstance().createGrowingMedium(505, "Clay Soil (light)", "", new ObservableListWrapperA<ImageLink>(), 0, "", new double[]{15, 15, 45, 15, 0, 10, 7.0}, true);
        GrowingMedium heavyClaySoil = GrowingMediumFactory.getInstance().createGrowingMedium(506, "Clay Soil (heavy)", "", new ObservableListWrapperA<ImageLink>(), 0, "", new double[]{8, 8, 54, 10, 0, 20, 7.0}, true);
        GrowingMedium chalkySoil = GrowingMediumFactory.getInstance().createGrowingMedium(507, "Chalky Soil", "", new ObservableListWrapperA<ImageLink>(), 0, "", new double[]{28, 28, 14, 10, 20, 10, 8.0}, true);
        GrowingMedium multipurposeCompost = GrowingMediumFactory.getInstance().createGrowingMedium(508, "Multipurpose Compost", "", new ObservableListWrapperA<ImageLink>(), 0, "", new double[]{0, 0, 0, 80, 0, 20, 5.2}, true);
        GrowingMedium ericaceousCompost = GrowingMediumFactory.getInstance().createGrowingMedium(509, "Ericaceous Compost", "", new ObservableListWrapperA<ImageLink>(), 0, "", new double[]{28, 28, 14, 10, 20, 10, 8.0}, true);
        GrowingMedium stonySoil = GrowingMediumFactory.getInstance().createGrowingMedium(510, "Stony Soil", "", new ObservableListWrapperA<ImageLink>(), 0, "", new double[]{30, 10, 0, 5, 50, 5, 7.0}, true);
        GrowingMedium plantLiquidCulture = GrowingMediumFactory.getInstance().createGrowingMedium(511, "Plant Liquid Culture", "", new ObservableListWrapperA<ImageLink>(), 0, "", new double[]{0, 0, 0, 0, 0, 100, 15}, true);
        GrowingMedium johnInnes1 = GrowingMediumFactory.getInstance().createGrowingMedium(512, "John Innes No. 1", "", new ObservableListWrapperA<ImageLink>(), 0, "", new double[]{23.333, 23.33, 28.34, 25, 0, 10, 7.0}, true);
        GrowingMedium johnInnes2 = GrowingMediumFactory.getInstance().createGrowingMedium(513, "John Innes No. 2", "", new ObservableListWrapperA<ImageLink>(), 0, "", new double[]{23.333, 23.33, 28.34, 25, 0, 10, 7.0}, true);
        GrowingMedium johnInnes3 = GrowingMediumFactory.getInstance().createGrowingMedium(514, "John Innes No. 3", "", new ObservableListWrapperA<ImageLink>(), 0, "", new double[]{23.333, 23.33, 28.34, 25, 0, 10, 7.0}, true);
        GrowingMedium johnInnesSeeds = GrowingMediumFactory.getInstance().createGrowingMedium(515, "John Innes Seeds", "", new ObservableListWrapperA<ImageLink>(), 0, "", new double[]{45, 20, 10, 25, 0, 10, 7.0}, true);
        GrowingMedium johnInnesPotting = GrowingMediumFactory.getInstance().createGrowingMedium(516, "John Innes Potting", "", new ObservableListWrapperA<ImageLink>(), 0, "", new double[]{23.333, 23.33, 28.34, 25, 0, 10, 7.0}, true);
        GrowingMediumGroup growingMediumGroup = new GrowingMediumGroup(new ObservableListWrapperA<>(loam, sandySoll, siltSoil, peatSoil, lightClaySoil, heavyClaySoil, chalkySoil, multipurposeCompost,
                ericaceousCompost, stonySoil, plantLiquidCulture, johnInnes1, johnInnes2, johnInnes3, johnInnesSeeds, johnInnesPotting));

        objects = new Object[]{growingMediumGroup};
    }

    public void write() throws Exception {
        new DefaultJsonDataFileWriter().write(objects);
    }

}
