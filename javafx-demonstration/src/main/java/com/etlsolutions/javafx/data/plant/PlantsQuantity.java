package com.etlsolutions.javafx.data.plant;

/**
 *
 * @author zc
 */
public class PlantsQuantity {

    public static enum Type {
        SINGLE, MULTIPLE, ESTIMATION, NO_COUNTING
    }

    private int quantity;
    private Type type;

    public PlantsQuantity() {
        this(Type.SINGLE);
    }

    public PlantsQuantity(Type type) {
        setType(type);
    }
    
    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {

        if (this.type == Type.SINGLE || this.type == Type.NO_COUNTING) {
            return;
        }
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public final void setType(Type type) {

        this.type = type;

        if (this.type == Type.SINGLE) {
            setQuantity(1);
        }

        if (this.type == Type.NO_COUNTING) {
            setQuantity(0);
        }
    }

}
