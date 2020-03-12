package com.etlsolutions.gwise.presentation;

import de.jensd.fx.glyphs.GlyphIcons;

/**
 *
 * @author ZhipengChang
 */
public enum GwiseFontAwesomeIcon implements GlyphIcons {

    WHITE_RECTANGLE('\u25AD');


    private final char character;

    private GwiseFontAwesomeIcon(char character) {
        this.character = character;
    }

    @Override
    public char getChar() {
        return character;
    }

    @Override
    public String unicodeToString() {
        return String.format("\\u%04x", (int) character);
    }

    @Override
    public String characterToString() {
        return Character.toString(character);
    }

    @Override
    public String getFontFamily() {
        return "FontAwesome";
    }

}

