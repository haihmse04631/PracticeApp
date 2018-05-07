package com.example.macbookpro.practiceapp.Model;

import com.squareup.otto.Bus;

/**
 * Created by MacbookPro on 4/30/18.
 */

public class BusStation {
    private static Bus bus = new Bus();

    public BusStation() {
    }

    public static Bus getBus() {
        return bus;
    }
}
