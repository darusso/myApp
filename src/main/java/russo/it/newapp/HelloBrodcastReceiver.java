package russo.it.newapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class HelloBrodcastReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.d("Brodcast", "Dispositivo in carica");
        Log.d("Brodcast","Dispositivo disconnesso dalla carica");

    }
}
