package com.siemens.scic.model.basis;

/**
 * Created by Simon.Lau on 16-Dec-16.
 */
public enum OrderState {

    CREATED(1),
    ERP(2),
    MES(3),
    WCC(4),
    DONE(5),
    UNRECOGNIZED(-1);

    private static final int _CREATED = 1;
    private static final int _ERP = 2;
    private static final int _MES = 3;
    private static final int _WCC = 4;
    private static final int _DONE = 5;

    private final int value;

    private OrderState(int value) {
        this.value = value;
    }

    public int getValue () {
        return this.value;
    }

    public static OrderState fromValue (int value) {
        OrderState state = null;
        switch (value) {
            case _CREATED :
                state = OrderState.CREATED;
                break;
            case _ERP :
                state = OrderState.ERP;
                break;
            case _MES :
                state = OrderState.MES;
                break;
            case _WCC:
                state = OrderState.WCC;
                break;
            case _DONE:
                state = OrderState.DONE;
                break;
            default:
                state = OrderState.UNRECOGNIZED;
                break;
        }
        return state;
    }

}
