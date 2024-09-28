/**
 @Author Landon Harrison
 Version 09/27
 this file instantiates the other java files to be called
 it then calls the files to draw the surface view
 debugging help from chatgpt
 */

package edu.up.thebeach_landonharrison;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        //calls the DrawingCanvas to be pushed onto the surface view
        //also calls the empty DrawingController
        DrawingCanvas theDrawing;
        theDrawing = findViewById(R.id.drawingview);
        DrawingModel drawingModel = new DrawingModel();
        DrawingController drawControl = new DrawingController(theDrawing);

        theDrawing.setTextViews(

                findViewById(R.id.TVRedVal),
                findViewById(R.id.TVGreenVal),
                findViewById(R.id.TVBlueVal),
                findViewById(R.id.currentElement)
        );

        theDrawing.setSeekBars(

                findViewById(R.id.SBRed),
                findViewById(R.id.SBGreen),
                findViewById(R.id.SBBlue)
        );


        theDrawing.updateSliderVals(drawingModel.currRed, drawingModel.currGreen,
                drawingModel.currBlue);

        drawControl.updateCurrVals();

        theDrawing.setOnTouchListener(drawControl);

        theDrawing.SBred.setOnSeekBarChangeListener(drawControl);
        theDrawing.SBgreen.setOnSeekBarChangeListener(drawControl);
        theDrawing.SBblue.setOnSeekBarChangeListener(drawControl);

        drawControl.onProgressChanged(theDrawing.retrieveSeek("r"),
                theDrawing.retrieveSeek("r").getProgress(), true);
        drawControl.onProgressChanged(theDrawing.retrieveSeek("g"),
                theDrawing.retrieveSeek("g").getProgress(), true);
        drawControl.onProgressChanged(theDrawing.retrieveSeek("b"),
                theDrawing.retrieveSeek("b").getProgress(), true);

        }

    }