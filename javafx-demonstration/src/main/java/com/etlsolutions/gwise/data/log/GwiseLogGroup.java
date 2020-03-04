package com.etlsolutions.gwise.data.log;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ImageLink;
import java.util.List;

/**
 *
 * @author zc
 */
public abstract class GwiseLogGroup extends GwiseDataUnit {

    private final ObservableListWrapperA<GwiseLog> cache = new ObservableListWrapperA<>();

    private final ObservableListWrapperA<GwiseLogYear> years;

    public GwiseLogGroup(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, List<GwiseLogYear> years) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.years = new ObservableListWrapperA<>(years);
    }

    public GwiseLogGroup(GwiseLogGroupBean bean) {
        super(bean);
        years = new ObservableListWrapperA<>();
        for(GwiseLogYearBean year : bean.getYears()) {
            years.add(new GwiseLogYear(year));
        }
    }

    public ObservableListWrapperA<GwiseLogYear> getYears() {
        return years;
    }

    public boolean addLog(GwiseLog log) {
        int year = log.getYear();
        for (GwiseLogYear l : years) {
            if (l.getYear() == year) {
                boolean success = l.addLog(log);
                addLogToCache(log);
                return success;
            }
        }

        GwiseLogYear logYear = new GwiseLogYear(year);
        years.add(logYear);
        boolean success = logYear.addLog(log);
        addLogToCache(log);
        return success;
    }

    public boolean removeLog(GwiseLog log) {

        for (int i = 0; i < years.size(); i++) {
            GwiseLogYear l = years.get(i);
            if (l.contains(log)) {
                boolean success = l.removeLog(log);
                if (l.isEmpty()) {
                    years.remove(l);
                }
                removeLogFromCache(log);
                return success;
            }
        }

        return false;
    }

    private void addLogToCache(GwiseLog log) {
        cache.add(log);
    }

    private void removeLogFromCache(GwiseLog log) {
        cache.remove(log);
    }

    public ObservableListWrapperA<GwiseLog> getLogs() {
        return cache;
    }
    
    public void refreshCache() {
        
        cache.clear();
        
        for(GwiseLogYear year :years) {
            
            cache.addAll(year.getLogs());
        }
    }

}
