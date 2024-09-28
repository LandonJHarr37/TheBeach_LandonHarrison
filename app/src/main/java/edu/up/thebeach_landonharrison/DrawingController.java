/**
 @Author Landon Harrison
 Version 09/27
 this java file is used to control how the coloring book presents itself, it
 hold methods that change values and take user input
 debugging help from chatgpt
 */

package edu.up.thebeach_landonharrison;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

public class DrawingController implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {

    //instantiate instances of the DrawingCanvas and Model
    private DrawingCanvas theDrawing;
    private DrawingModel drawingModel;
    private float distFromSunC = 0;
    private float distFromTreeC = 0;


    //instantiates the private instances of Drawing Model and Canvas
    public DrawingController(DrawingCanvas theDrawing){

        this.theDrawing = theDrawing;
        this.drawingModel = new DrawingModel();
    }

    //touch within circle distance metric is with help from googleAI
    //this method sets the current element name and the current color that
    //is being used
    public String currElement(DrawingCanvas theDrawing){


                //sets distance values to check if sun or
        //tree top are touched
        distFromSunC = (float) Math.sqrt(Math.pow(drawingModel.currX - theDrawing.sunX, 2) +
                Math.pow(drawingModel.currY - theDrawing.sunY, 2));
        distFromTreeC = (float) Math.sqrt(Math.pow(drawingModel.currX - theDrawing.trTopX, 2) +
                Math.pow(drawingModel.currY - theDrawing.trTopY, 2));

        //when birds are touched
        if (drawingModel.currX > 1220 && drawingModel.currX < 2070 &&
        drawingModel.currY > 328 && drawingModel.currY < 558){

            drawingModel.currColor = drawingModel.birdBlackCode;
            return "Birds";
        }

        //when Tree top is touched
        else if (distFromTreeC < theDrawing.trTopRad){

            drawingModel.currColor = drawingModel.treeGreen;
            return "Tree Top";
        }

        //when the tree trunk is touched
        else if (drawingModel.currX > theDrawing.treeLeft && drawingModel.currX <
                theDrawing.treeRight && drawingModel.currY > theDrawing.treeTop
                && drawingModel.currY < theDrawing.treeBottom) {

            drawingModel.currColor = drawingModel.treeTrunk;
            return "Tree Trunk";
        }

        // when the beach is touched
        else if (drawingModel.currX > theDrawing.beachLeft && drawingModel.currX <
                theDrawing.beachRight && drawingModel.currY > theDrawing.beachTop
                && drawingModel.currY < theDrawing.beachBottom){

            drawingModel.currColor = drawingModel.sandy;
            return "The Beach";
        }

        //when the Ocean is touched
        else if (drawingModel.currX > theDrawing.oceanleft && drawingModel.currX <
                theDrawing.oceanRight && drawingModel.currY > theDrawing.oceanTop
                && drawingModel.currY < theDrawing.oceanBottom){

            drawingModel.currColor = drawingModel.oceanBlue;
            return "The Ocean";
        }

        //when the sun is touched
        else if (distFromSunC < theDrawing.sunRadius){

            drawingModel.currColor = drawingModel.sunOrangeCode;
            return "The Sun";
        }

        //when the sky is touched
        else {

            drawingModel.currColor = drawingModel.skyBlue;
            return "The Sky";
        }
    }

    //updates the currRed currGreen and currBlue values held in
    //drawingModel
    public void updateCurrVals(){

        drawingModel.currRed = Color.red(drawingModel.currColor);
        drawingModel.currGreen = Color.green(drawingModel.currColor);
        drawingModel.currBlue = Color.blue(drawingModel.currColor);
    }

    //when screen is touched
    //updates the slider values, current color values, and textviews
    public boolean onTouch(View tbView, MotionEvent motionEvent) {

        drawingModel.currX = motionEvent.getX();
        drawingModel.currY = motionEvent.getY();


        if (drawingModel.currX > 0 && drawingModel.currY < theDrawing.beachBottom
        && drawingModel.currX < 3000f && drawingModel.currY > 0) {

            updateCurrVals();
            drawingModel.theCurrentElement = currElement(theDrawing);
            theDrawing.updateSliderVals(drawingModel.currRed,
                    drawingModel.currGreen,
                    drawingModel.currBlue);
            theDrawing.updateViews(Integer.toString(drawingModel.currRed),
                Integer.toString(drawingModel.currGreen),
                Integer.toString(drawingModel.currBlue),
                drawingModel.theCurrentElement);
    }
        updateCurrVals();

        theDrawing.invalidate();
        return true;
    }

    //used when the seekbars are changed
    public void onProgressChanged(SeekBar seekb, int progress, boolean fromUser){

        //sort by the seekbar and assign progress to the respective colors
        if (seekb == theDrawing.retrieveSeek("r")) {
            drawingModel.currRed = progress;
        }
        if (seekb == theDrawing.retrieveSeek("g")) {
            drawingModel.currGreen = progress;
        }
        if (seekb == theDrawing.retrieveSeek("b")) {
            drawingModel.currBlue = progress;
        }

        updateColor();
        updateCurrVals();

        theDrawing.updateViews(Integer.toString(drawingModel.currRed),
                Integer.toString(drawingModel.currGreen),
                Integer.toString(drawingModel.currBlue),
                drawingModel.theCurrentElement);

        updateColor();

        theDrawing.invalidate();
    }


    //updates the color of drawn pieces
    public void updateColor() {

        drawingModel.currColor = Color.rgb(drawingModel.currRed,
                drawingModel.currGreen,
                drawingModel.currBlue);
        switch (drawingModel.theCurrentElement) {
            case "The Sun":
                theDrawing.resetColor("The Sun");
                break;
            case "Birds":
                theDrawing.resetColor("Birds");
                break;
            case "The Sky":
                theDrawing.resetColor("The Sky");
                break;
            case "The Ocean":
                theDrawing.resetColor("The Ocean");
                break;
            case "The Beach":
                theDrawing.resetColor("The Beach");
                break;
            case "Tree Top":
                theDrawing.resetColor("Tree Top");
                break;
            case "Tree Trunk":
                theDrawing.resetColor("Tree Trunk");
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}