package com.etlsolutions.tests.excel.datatable;

import java.lang.reflect.Field;
import java.util.Comparator;
import org.primefaces.model.SortOrder;

/**
 * @param <T>
 */
public class LazySorter<T> implements Comparator<T>
{

  private final String sortField;

  private final SortOrder sortOrder;

  public LazySorter(String sortField, SortOrder sortOrder)
  {
    this.sortField = sortField;
    this.sortOrder = sortOrder;
  }

  @Override
  @SuppressWarnings(
          {
            "unchecked"
          })
  public int compare(T row1, T row2)
  {
    int value;
    if (sortOrder == null || sortOrder == SortOrder.UNSORTED)
    {
      value = 0;
    }
    else if (row1 == null && row2 == null)
    {
      value = 0;
    }
    else if (row1 == null)
    {
      value = -1;
    }
    else if (row2 == null)
    {
      value = 1;
    }
    else
    {
      try
      {
        Field field = row1.getClass().getDeclaredField(this.sortField);
        field.setAccessible(true);
        Object value1 = field.get(row1);
        Object value2 = field.get(row2);

        if (value1 == null && value2 == null)
        {
          value = 0;
        }
        else if (value1 == null)
        {
          value = -1;
        }
        else if (value2 == null)
        {
          value = 1;
        }
        else if (!(value1 instanceof Comparable) || !(value2 instanceof Comparable))
        {
          value = 0;
        }
        else
        {
          value = ((Comparable) value1).compareTo(value2);
        }
      }
      catch (NoSuchFieldException | IllegalAccessException e)
      {
        throw new RuntimeException(e);
      }
    }
    return SortOrder.ASCENDING.equals(sortOrder) ? value : (-1 * value);
  }
}
