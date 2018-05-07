package com.example.macbookpro.practiceapp.EventBus;

import com.squareup.otto.Bus;

/**
 * Created by MacbookPro on 5/1/18.
 */

public class OttoBus {
    private static Bus bus;

    public static Bus getInstance() {
        if (bus == null) {
            bus = new Bus();
        }
        return bus;
    }
}
