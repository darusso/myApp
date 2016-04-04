package russo.it.newapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends Activity{
    ImageView logo;
    Animation animFadeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        logo=(ImageView)findViewById(R.id.img_splash);
        animFadeIn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        logo.startAnimation(animFadeIn);

        //*---Thread---*///
        Thread threadLanciatore=new Thread(){
          public void run(){
              try {
                  int tempo=0;
                  while (tempo<6000){
                      sleep(100);
                      tempo += 100;
                  }
                  Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                  //intent.setClassName("russo.it.myappdrusso","russo.it.myappdrusso.HomePage");
                  startActivity(intent);

              }
              catch (InterruptedException exc){
                  exc.printStackTrace();
              }
              finally {
                  finish();
              }
          }
        };
        threadLanciatore.start();

    }

    @Override
    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

//    public void goHomePage(View view) {
//        //Intent esplicito
//        //Intent intent = new Intent(this, HomePage.class);
//        //startActivity(intent);
//        Intent intent = new Intent();
//
//        intent.setClassName("russo.it.myappdrusso","russo.it.myappdrusso.HomePage");
//        startActivity(intent);
//    }



}
