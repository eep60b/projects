package com.etlsolutions.javafx.data.log.gvent;

/**
 * Basic forms are the key to a flower type’s guide. These include: Raceme – A
 * raceme is a group of small stalked flowers attached to a stem in an elongated
 * cluster. Spike – Similar to raceme, a spike is an elongated cluster but the
 * flowers are stemless. Umbel – An umbel is an umbrella-shaped cluster of
 * florets with pedicles the same length. Corymb – While a corymb is shaped
 * similarly to an umbel, it has pedicles of different lengths to create a
 * flattened top. Head – A head is a type of inflorescence that resembles a
 * solitary flower but is, in fact, made up of tightly packed florets. Cyme – A
 * cyme is a flat-topped cluster where the upper flowers open first followed by
 * those lower in the arrangement. Panicle – A panicle has a central point
 * bearing a branched organization of racemes.
 *
 * Read more at Gardening Know How: Identifying Flowers: Learn About Flower
 * Types And Inflorescences
 * https://www.gardeningknowhow.com/garden-how-to/info/flowers-and-inflorescences.htm
 *
 * @author zc
 */
public class FloweringGvent extends Gvent {

    private String type;
    private int numberPerPlant = -1;
    private String color;

    public int getNumberPerPlant() {
        return numberPerPlant;
    }

    public void setNumberPerPlant(int numberPerPlant) {
        this.numberPerPlant = numberPerPlant;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public GventType getType() {
        return GventType.FLOWERING;
    }
}
