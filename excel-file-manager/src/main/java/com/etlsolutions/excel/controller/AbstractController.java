package com.etlsolutions.excel.controller;

import com.etlsolutions.tests.excel.datatable.IdentifiableRow;
import com.etlsolutions.tests.excel.datatable.LazyDqDataModel;
import java.io.Serializable;
import java.util.List;

/**
 * The AbstractController class is a super class controller classes for each
 * tab. It holds the common methods.
 *
 * @param <T> - The row type
 */
public abstract class AbstractController<T extends IdentifiableRow> implements Serializable {

  private static final long serialVersionUID = 577382622352531232L;

  /**
   * This field is required by the Primefaces table model to filter the table. Don't change it and its getter and setter.
   */
  protected List<T> filteredRows;

  /**
   * Get the table data model. In this module, we implement the custom
   * LazyDataModel and its sorter.
   *
   * @return a valid table data model.
   */
  public abstract LazyDqDataModel<T> getDataModel();

  /**
   * Get the rows for filter. This method is required by the Primefaces table
   * model to filter the table.
   *
   * @return the row list.
   */
  public List<T> getFilteredRows() {
    return filteredRows;
  }

  /**
   * Set the filtered rows. This method is required by the Primefaces table
   * model to filter the table.
   *
   * @param filteredRows - The row list.
   */
  public void setFilteredRows(List<T> filteredRows) {
    this.filteredRows = filteredRows;
  }


}
