/**
 @Author Landon Harrison
 Version 09/27
 this file calls both the Drawing controller and model
 it holds all of the drawn elements and drawing methods
 this will get called by main activity to draw on the surface view
 debugging help from chatgpt
 */

package edu.up.thebeach_landonharrison;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class DrawingCanvas extends SurfaceView {

    //instantiates the other java classes
    private DrawingModel drawingModel;

    //For instantiating instances of colors
    Paint skyBlueDC = new Paint();
    Paint oceanBlue = new Paint();
    Paint sunOrange = new Paint();
    Paint birdBlack = new Paint();
    Paint treeTrunk = new Paint();
    Paint treeTopCode = new Paint();
    Paint beachSand = new Paint();
    private TextView TVred;
    private TextView TVgreen ;
    private TextView TVblue ;
    TextView TVcurrElement;
    public SeekBar SBred;
    public SeekBar SBgreen;
    public SeekBar SBblue;


    //constants for drawingview
    public static final float sun = 100f;
    public static final float beachLeft = 0f;
    public static final float beachTop= 700f;
    public static final float beachRight = 2000f;
    public static final float beachBottom = 1200f;
    public static final float oceanleft = 0f;
    public static final float oceanTop = 600f;
    public static final float oceanRight = 2000f;
    public static final float oceanBottom = 1200f;
    public static final float sunX = 300f;
    public static final float sunY = 575f;
    public static final float sunRadius = 150f;
    public static final float treeLeft = 1490f;
    public static final float treeTop = 350f;
    public static final float treeRight = 1545f;
    public static final float treeBottom = 850f;
    public static final float trTopX = 1525f;
    public static final float trTopY = 350f;
    public static final float trTopRad = 120f;


    //the main class for DrawingCanvas
    //Calls in other necessary classes and colors
    //sets background colors
    public DrawingCanvas(Context context, AttributeSet attributes) {

        super(context, attributes);

        //Tell the app that this view (i.e., LizardCanvas object)
        //actually DOES draw something so please call the onDraw()
        //method at the right time.
        setWillNotDraw(false);

        drawingModel = new DrawingModel();

        //setup our favorite color
        skyBlueDC.setColor(drawingModel.skyBlue);
        sunOrange.setColor(drawingModel.sunOrangeCode);
        birdBlack.setColor(drawingModel.birdBlackCode);
        treeTrunk.setColor(drawingModel.treeTrunk);
        treeTopCode.setColor(drawingModel.treeGreen);
        oceanBlue.setColor(drawingModel.oceanBlue);
        beachSand.setColor(drawingModel.sandy);

        TVred = findViewById(R.id.TVRed);
        TVgreen = findViewById(R.id.TVGreen);
        TVblue = findViewById(R.id.TVBlue);

        SBred = findViewById(R.id.SBRed);
        SBgreen = findViewById(R.id.SBGreen);
        SBblue = findViewById(R.id.SBBlue);

        //setBackgroundColor(skyBlueDC.getColor());

    }

    //method to draw number of birds that the program feeds,
    //later will be available for user to adjust
    public void drawBird(Canvas canvas, float numBirds, Paint bird) {

        //initiates the location variables
        float xRecL = 817;
        float xRecR = 850;
        float xRecT = 287;
        float xRecB = 293;
        float cX = 834;
        float cY = 296;


        for (int q = 0; q < numBirds; q++) {



            //draws a bird
            canvas.drawRect(xRecL, xRecT, xRecR, xRecB, bird);
            canvas.drawCircle(cX, cY, 7, bird);

            //iterates through the value for the bird locations
            xRecL += 100;
            xRecR += 100;
            cX += 100;
            if (q % 5 == 0 && q != 0){
                xRecL -= 400;
                xRecR -= 400;
                cX -= 400;
                cY += 50;
                xRecT += 50;
                xRecB += 50;

            }
        }

    }

    //original instantiation of the textviews
    public void setTextViews(TextView red, TextView green, TextView blue,
                             TextView Element){

        this.TVblue = blue;
        this.TVred = red;
        this.TVgreen = green;
        this.TVcurrElement = Element;
    }

    //original assignment of the seekbars
    public void setSeekBars(SeekBar red, SeekBar green, SeekBar blue){

        this.SBblue = blue;
        this.SBred = red;
        this.SBgreen = green;
    }

    //used to update the textviews
    public void updateViews(String red, String green, String blue, String element){

        TVgreen.setText(green);
        TVblue.setText(blue);
        TVred.setText(red);
        TVcurrElement.setText(element);
    }

    //used to update the slider values
    public void updateSliderVals(int currRed, int currGreen, int currBlue){

        SBred.setProgress(currRed);
        SBgreen.setProgress(currGreen);
        SBblue.setProgress(currBlue);
    }

    public SeekBar retrieveSeek(String c){

        if (c.equals("r")){
            return this.SBred;
        }
        else if (c.equals("g")){//make this look like red
            return this.SBgreen;
        }
        else if (c.equals("b")){//this too
            return this.SBblue;
        }
        return null;
    }

    public void resetColor(String q){

        switch (q){

            case "The Sun":
                sunOrange.setColor(drawingModel.currColor);
                break;
            case "The Sky":
                skyBlueDC.setColor(drawingModel.currColor);
                break;
            case "The Ocean":
                oceanBlue.setColor(drawingModel.currColor);
                break;
            case "The Beach":
                beachSand.setColor(drawingModel.currColor);
                break;
            case "Tree Top":
                treeTopCode.setColor(drawingModel.currColor);
                break;
            case "Tree Trunk":
                treeTrunk.setColor(drawingModel.currColor);
                break;
            case "Birds":
                birdBlack.setColor(drawingModel.currColor);
                break;
        }
        invalidate();
    }

    //draws all of the elements on the surface view
    //pulls in assigned colors
    @Override
    protected void onDraw(android.graphics.Canvas canvas) {

        canvas.drawRect(0,0,3000,3000, skyBlueDC); //hardcoded b/c I am using for the background
        canvas.drawCircle(sunX, sunY, sunRadius, sunOrange);
        canvas.drawRect(oceanleft, oceanTop, oceanRight, oceanBottom, oceanBlue);
        canvas.drawRect(beachLeft, beachTop, beachRight, beachBottom, beachSand);

        canvas.drawRect(treeLeft, treeTop, treeRight, treeBottom, treeTrunk);
        canvas.drawCircle(trTopX, trTopY, trTopRad, treeTopCode);

        drawBird(canvas, 23, birdBlack);


    }

}