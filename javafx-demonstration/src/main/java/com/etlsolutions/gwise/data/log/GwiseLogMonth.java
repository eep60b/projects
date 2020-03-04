package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.ImageLink;
import java.util.List;

/**
 * The GwiseLogMonth class contains all logs for a whole month.
 *
 * @author zc
 */
public class GwiseLogMonth extends GwiseDataUnit {

    private final ValueWrapper<Integer> monthWrapper;
    private final ObservableListWrapperA<GwiseLog> logs;
    
    public GwiseLogMonth(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, int month, List<GwiseLog> logs) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        monthWrapper = new ValueWrapper<>(month);
        this.logs = new ObservableListWrapperA<>(logs);
    }

    public GwiseLogMonth(GwiseLogMonthBean bean) {
        super(bean);
        monthWrapper = new ValueWrapper<>(bean.getMonth());
        logs = new ObservableListWrapperA<>();
        for (GwiseLogBean log : bean.getLogs()) {
            logs.add(GwiseLogFactory.getInstance().createLog(log));
        }
    }

    public GwiseLogMonth(int month) {
        this(new GwiseLogMonthBean(month));
    }
    
    
    public int getMonth() {
        return monthWrapper.getValue();
    }

    public void setMonth(int month) {
        monthWrapper.setValue(month);
    }

    public ValueWrapper<Integer> getMonthWrapper() {
        return monthWrapper;
    }
    
    public ObservableListWrapperA<GwiseLog> getLogs() {
        return logs;
    }

    @Override
    public GwiseLogMonthBean getBean() {
        return new GwiseLogMonthBean(this);
    }
}
