/**
 Landon Harrison
 Version 09/23
 this file instantiates the other java files to be called
 it then calls the files to draw the surface view
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
        DrawingController drawControl = new DrawingController(theDrawing);

        }

    }