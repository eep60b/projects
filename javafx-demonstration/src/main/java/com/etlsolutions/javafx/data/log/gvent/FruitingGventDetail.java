package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class FruitingGventDetail implements GventDetail {

    private final ValueWrapper<Boolean> countable;
    private final ValueWrapper<Integer> count;
    private final ValueWrapper<String> color;
    private final ValueWrapper<String> shape;
    private final ValueWrapper<String> averageSize;
    private final ValueWrapper<String> averageWeight;

    public FruitingGventDetail(int count, String color, String shape, double averageSize, double averageWeight) {
        this.countable = new ValueWrapper<>(count >= 0);
        this.count = new ValueWrapper<>(count);
        this.color = new ValueWrapper<>(color);
        this.shape = new ValueWrapper<>(shape);
        this.averageSize = new ValueWrapper<>(String.valueOf(averageSize));
        this.averageWeight = new ValueWrapper<>(String.valueOf(averageWeight));
    }

    public ValueWrapper<Boolean> getCountable() {
        return countable;
    }
    
    public ValueWrapper<Integer> getCount() {
        return count;
    }

    public ValueWrapper<String> getColor() {
        return color;
    }

    public ValueWrapper<String> getShape() {
        return shape;
    }

    public ValueWrapper<String> getAverageSize() {
        return averageSize;
    }

    public ValueWrapper<String> getAverageWeight() {
        return averageWeight;
    }
    
    @Override
    public GventType getType() {
        return GventType.FRUITING;
    }
}
