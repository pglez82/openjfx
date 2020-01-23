package com.pablo;

import java.util.Date;

public interface OnEndCountDown {
    /**
     * Se dispara cuando el temporizador llegue a cero
     * @param fechaEvento fecha/hora del evento
     */
    void ejecuta(Date fechaEvento);
}
