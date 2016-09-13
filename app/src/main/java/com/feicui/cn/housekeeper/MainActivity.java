package com.feicui.cn.housekeeper;

import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ImageView sk= (ImageView) findViewById(R.id.iv_sekai);
        AnimatorSet animator= (AnimatorSet) AnimatorInflater.loadAnimator(this,R.anim.anim_logo);
        animator.setTarget(sk);
        animator.start();*/
    }

}
