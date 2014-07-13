package com.example.square_otto_sample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.squareup.otto.Subscribe;

import java.util.Date;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Subscribe
    public void messageReceived(MessageEvent event){
        log("received: " + event.message);
    }

    public void register(View view) {
        log("registered");
        App.bus.register(this);
    }

    public void postEvent(View view) {
        Date now = new Date(System.currentTimeMillis());
        log("posted event: " + now);
        App.bus.post(new MessageEvent(now.toString()));
    }

    public void unregister(View view) {
        log("unregistered");
        App.bus.unregister(this);
    }

    private void log(String msg){
        Log.w("log", msg);
        TextView tv = (TextView) findViewById(R.id.logs);
        tv.setText(tv.getText() + "\n" + msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.bus.unregister(this);
    }

}