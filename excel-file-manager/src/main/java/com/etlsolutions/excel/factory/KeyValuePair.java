/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etlsolutions.excel.factory;

import java.util.Objects;

/**
 * The KeyValuePair class is used to represents a data point retrieved from the
 * database. As the key is unique, Its equals/hashCode/compareTo methods will
 * only rely on the key not the value.
 */
public final class KeyValuePair implements Comparable<KeyValuePair> {

  private final String key;
  private final Number value;

  public KeyValuePair(String key, Number value) {
    this.key = key;
    this.value = value;
  }

  /**
   * Get the key.
   *
   * @return the key string.
   */
  public String getKey() {
    return key;
  }

  /**
   * Get the value.
   *
   * @return value number.
   */
  public Number getValue() {
    return value;
  }

  @Override
  public int compareTo(KeyValuePair o) {

    if (o == null) {
      return -1;
    }

    if (o.key == null) {
      return this.key == null ? 0 : -1;
    }

    return this.key.compareTo(o.key);
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 29 * hash + Objects.hashCode(this.key);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final KeyValuePair other = (KeyValuePair) obj;

    return Objects.equals(this.key, other.key);
  }
}
