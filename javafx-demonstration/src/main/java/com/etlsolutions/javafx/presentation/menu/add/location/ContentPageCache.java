/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author zc
 */
public class ContentPageCache {

    private final Map<SubAreaType, WizardPage> cache = new HashMap<>();

    public WizardPage getPage(SubAreaType type) {

        WizardPage page = cache.get(type);

        if (page == null) {

            switch (type) {
                
            }

        }
        return page;
    }
}
