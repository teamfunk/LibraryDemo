package de.teamfunk.android.libdemo;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.caverock.androidsvg.SVGImageView;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/**
 * Libraries Demo
 *
 * 1) Android SVG
 *    https://code.google.com/p/androidsvg/
 *    https://code.google.com/p/androidsvg/wiki/Documentation
 *
 * 2) Floating Action Button
 *    https://github.com/futuresimple/android-floating-action-button
 *
 * 3) Apache Commons Lang
 *    http://commons.apache.org/proper/commons-lang/
 *    http://commons.apache.org/proper/commons-lang/javadocs/api-release/index.html
 *
 */
public class MainActivity extends Activity {

    private FrameLayout mLogoContainerSvg;
    private FrameLayout mLogoVectorDrawable;
    private FloatingActionsMenu mFloatingActionsMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mFloatingActionsMenu = (FloatingActionsMenu)findViewById(R.id.floating_actions_menu);
        FloatingActionButton btn1 = (FloatingActionButton)findViewById(R.id.action_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFloatingActionsMenu.collapse();
                demoSVG();
            }
        });
        FloatingActionButton btn2 = (FloatingActionButton)findViewById(R.id.action_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFloatingActionsMenu.collapse();
                ApacheCommonsLangDemo demo = new ApacheCommonsLangDemo();
                demo.demoStringUtils();
                demo.demoNumbers();
                demo.demoArrayUtils();
                demo.demoMisc();
            }
        });


    }

    /**
     * demo to show SVG graphic in Android
     */
    protected void demoSVG() {

        // https://code.google.com/p/androidsvg/
        // https://code.google.com/p/androidsvg/wiki/Documentation

        mLogoContainerSvg = (FrameLayout)findViewById(R.id.logo_svg);
        SVGImageView svgImageView = new SVGImageView(this);
        svgImageView.setImageAsset("svg-logo-v.svg");
        mLogoContainerSvg.addView(svgImageView);


        // online SVG to vector drawable converter
        // http://ozodrukh.github.io/Svg2MrVector/

        mLogoVectorDrawable = (FrameLayout)findViewById(R.id.logo_vectordrawable);
        mLogoVectorDrawable.setBackground(getDrawable(R.drawable.vectordrawable_svg_logo));
    }

}
