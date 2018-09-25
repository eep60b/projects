package com.etlsolutions.javafx.presentation.wizard;

/**
 *
 * @author zc
 */
public interface WizardDataModel {

    String STATUS_PROPERTY = "com.etlsolutions.javafx.presentation.wizardWizardDataMode.STATUS_PROPERTY";

       
    String getPageTitle();
    
    void save();

    boolean notToPrevious();

    void addPropertyChangeListener(String NAVIGATE_TO_PREVIOUS_PROPERTY, StatusPropertyChangeAdapter navigateToPreviousPropertyChangeAdapter);

    boolean notToNext();
    
    boolean canNotFinish();

    public void setCurrentIndex(int newPageIndex);

    public int getCurrentIndex();

    public String getErrorMessage();
}
