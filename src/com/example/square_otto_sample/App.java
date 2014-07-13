package com.example.square_otto_sample;

import android.app.Application;
import com.squareup.otto.Bus;

/**
 * Created by gturedi on 13.07.2014.
 */
public class App extends Application {

    public static Bus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        bus = new Bus();
    }

}
