package com.etlsolutions.excel.cache;

import com.etlsolutions.tests.excel.datatable.IdentifiableRow;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The AbstractCache class is a super class for all cache classes which serve
 * intermediate layers between the database layer and the controllers. Data can
 * be cached in these classes to gain performance. If there is no performance
 * issue, this layer simply delegate the methods to underlining database layer.
 *
 * @param <T> - The row type.
 */
public abstract class AbstractCache<T extends IdentifiableRow> {


  public abstract void updateChartModels(List<T> filteredRows);

  public AbstractCache(boolean isSummary) {
    //Set the end date to the last day of the last month.
    Calendar cal = Calendar.getInstance();
    //One year for the summary, one month for others.    
    cal.add(Calendar.MONTH, -1);
    //Allways end with the last day of the month.


    //Always start from the first day of the month.
    cal.add(Calendar.MONTH, isSummary ? -12 : 0);
  }

  /**
   * Get the rows to display.
   *
   * @return all rows between start date (inclusive) and end date (inclusive).
   */
  public abstract List<T> getRows();

  public abstract void reload(Date fromDate, Date toDate);

  
}
