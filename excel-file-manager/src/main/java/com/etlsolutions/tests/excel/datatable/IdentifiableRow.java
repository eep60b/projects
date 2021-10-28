package com.etlsolutions.tests.excel.datatable;

import java.util.Objects;

/**
 * The IdentifiableRow class is a super class for the row data classes. It provides an ID for comparing and sorting.
 */
public class IdentifiableRow
{

  private String id;

  public IdentifiableRow()
  {
  }

  public IdentifiableRow(String id)
  {
    this.id = id;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  @Override
  public final int hashCode()
  {
    int hash = 7;
    hash = 19 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public final boolean equals(Object obj)
  {
    if (obj == null)
    {
      return false;
    }
    if (getClass() != obj.getClass())
    {
      return false;
    }

    final IdentifiableRow other = (IdentifiableRow) obj;
    return Objects.equals(this.id, other.id);
  }
}
