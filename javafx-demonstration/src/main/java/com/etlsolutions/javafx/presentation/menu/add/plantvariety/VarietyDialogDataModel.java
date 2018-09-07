package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.presentation.TitleDataModel;
import java.util.List;

/**
 *
 * @author zc
 */
public class VarietyDialogDataModel implements TitleDataModel {

    private String title;
    private String latinName;
    private String informaiton;
    private List<String> aliases;
    private List<ImageLink> imageLinks;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public String getInformaiton() {
        return informaiton;
    }

    public void setInformaiton(String informaiton) {
        this.informaiton = informaiton;
    }
    
    
}
