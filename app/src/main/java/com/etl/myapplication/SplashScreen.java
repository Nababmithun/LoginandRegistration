package com.etl.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        iv=findViewById(R.id.iv);
        //FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();




        Animation mine= AnimationUtils.loadAnimation(this,R.anim.transition);
        iv.startAnimation(mine);
        ObjectAnimator animation = ObjectAnimator.ofFloat(iv, "translationY", -300f);
        animation.setDuration(1000);
        animation.start();
        // boolean notFirsttime= Saving.getAboolean(this,"isFirstTime");
        final Intent i;

       /* if (user==null&& notFirsttime==false){
            Saving.SaveABoolean(this,"isFirstTime",true);
            i=new Intent(this, MyMainActivity.class);
        }else {
            i=new Intent(this, LoginSignup.class);
        }*/
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(SplashScreen.this,skipActivity.class);
                startActivity(intent);
            }
        },1500);

    }
}