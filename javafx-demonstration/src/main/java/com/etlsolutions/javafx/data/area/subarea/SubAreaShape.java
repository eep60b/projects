package com.etlsolutions.javafx.data.area.subarea;

/**
 *
 * @author zc
 */
public enum SubAreaShape {

    RECTANGLE("Rectangle"),
    SQURE("Squre"),
    CIRCLE("Circle"),
    TRIANGLE("Triangle"),
    IRREGULAR("Irregular"),
    /**
     * Round border subarea
     */
    ROUND_BORDER(
            "Round"),
    /**
     * Straight line border.
     */
    STRAIGHT_LINE_BORDER("Straight line"),
    /**
     * Greenhouse
     */
    GOTHIC("Gothic"),
    HOOP("Hoop"),
    DOOM("Doom"),
    LEAN_TO_WALL("Lean-to-wall"),
    /**
     * Pound
     */
    RECTANGLE_POND("Rectangle"),
    SQURE_POND("Squre"),
    CIRCLE_POND("Circle"),
    TRIANGLE_POND("Triangle"),
    IRREGULAR_POND("Irregular");

    private final String title;

    private SubAreaShape(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
