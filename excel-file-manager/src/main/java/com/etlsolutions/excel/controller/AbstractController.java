package com.etlsolutions.excel.controller;

import com.etlsolutions.jlrmena.tests.excel.DataRow;
import com.etlsolutions.tests.excel.datatable.LazyDqDataModel;
import java.io.Serializable;
import java.util.List;

/**
 * The AbstractController class is a super class controller classes for each
 * tab. It holds the common methods.
 *
 */
public abstract class AbstractController implements Serializable {

  private static final long serialVersionUID = 577382622352531232L;

  /**
   * This field is required by the Primefaces table model to filter the table. Don't change it and its getter and setter.
   */
  protected List<DataRow> filteredRows;

  /**
   * Get the table data model. In this module, we implement the custom
   * LazyDataModel and its sorter.
   *
   * @return a valid table data model.
   */
  public abstract LazyDqDataModel getDataModel();



}
