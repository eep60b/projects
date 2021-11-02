package com.etlsolutions.excel.controller;

import com.etlsolutions.jlrmena.tests.excel.DataRow;
import com.etlsolutions.jlrmena.tests.excel.ExcelUtils;
import com.etlsolutions.tests.excel.datatable.LazyDqDataModel;
import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

@ManagedBean
@ViewScoped
public class SummaryCountController implements Serializable {

    private static final long serialVersionUID = 676202916465527901L;

    private List<DataRow> rows;
    private LazyDqDataModel dataModel;

    /**
     * This field is required by the Primefaces table model to filter the table.
     * Don't change it and its getter and setter.
     */
    private List<DataRow> filteredRows;

    public SummaryCountController() {
        Logger.getLogger(SummaryCountController.class).info("CONSTRUCTING SummaryCountController");
    }

    @PostConstruct
    public void init() {
        rows = ExcelUtils.getInstance().loadData();
        dataModel = new LazyDqDataModel(rows);
    }

//    public List<DataRow> getDataModel() {
//        return rows;
//    }

    public LazyDqDataModel getDataModel() {
        return dataModel;
    }
    /**
     * Get the rows for filter. This method is required by the Primefaces table
     * model to filter the table.
     *
     * @return the row list.
     */
    public List<DataRow> getFilteredRows() {
        return filteredRows;
    }

    /**
     * Set the filtered rows. This method is required by the Primefaces table
     * model to filter the table.
     *
     * @param filteredRows - The row list.
     */
    public void setFilteredRows(List<DataRow> filteredRows) {
        this.filteredRows = filteredRows;
    }

    public Date getFromDate() {
        return new Date();
    }

    public void setFromDate(Date fromDate) {

    }

    public Date getToDate() {
        return new Date();
    }

    public void setToDate(Date fromDate) {

    }

    public List<String> getAllMarkets() {
        return Arrays.asList("");
    }
}
