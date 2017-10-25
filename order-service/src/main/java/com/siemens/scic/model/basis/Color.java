package com.siemens.scic.model.basis;

/**
 * Created by Simon.Lau on 16-Dec-16.
 */
public enum Color {

    RED(1),
    YELLOW(2),
    BLACK(3),
    OTHER(-1);

    private static final int _RED = 1;
    private static final int _YELLOW = 2;
    private static final int _BLACK = 3;

    private final int value;

    private Color(int value) {
        this.value = value;
    }

    public int getValue () {
        return this.value;
    }

    public static Color fromValue (int value) {
        Color state = null;
        switch (value) {
            case _RED :
                state = Color.RED;
                break;
            case _YELLOW :
                state = Color.YELLOW;
                break;
            case _BLACK :
                state = Color.BLACK;
                break;
            default:
                state = Color.OTHER;
                break;
        }
        return state;
    }

}
