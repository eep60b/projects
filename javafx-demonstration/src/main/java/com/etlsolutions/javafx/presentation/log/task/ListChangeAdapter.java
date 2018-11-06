/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 * @param <T>
 */
public class ListChangeAdapter<T> implements ListChangeListener<T>{

    private final ObservableListWrapperA<T> list;
    private final ComboBox<T> comboBox;

    public ListChangeAdapter(ObservableListWrapperA<T> list, ComboBox<T> comboBox) {
        this.list = list;
        this.comboBox = comboBox;
    }

    @Override
    public void onChanged(Change<? extends T> c) {
        comboBox.setItems(list);
    }  
}
