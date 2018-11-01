/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.log;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class RepeatTimesChangeAdapter implements ChangeListener<Integer> {

    private final NotificationDataModel model;

    
    public RepeatTimesChangeAdapter(NotificationDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
        model.setRepeatTimes(newValue);
    }
    
}
