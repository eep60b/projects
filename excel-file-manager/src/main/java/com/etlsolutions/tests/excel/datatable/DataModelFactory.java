package com.etlsolutions.tests.excel.datatable;

import com.etlsolutions.jlrmena.tests.excel.ExcelUtils;

public class DataModelFactory {

    private static final DataModelFactory INSTANCE = new DataModelFactory();
    
    private DataModelFactory() {
    }

    public static DataModelFactory getInstance() {
        return INSTANCE;
    }
    
    public LazyDqDataModel getDataModel () {
               
        return new LazyDqDataModel(ExcelUtils.getInstance().loadData());
    }
}
