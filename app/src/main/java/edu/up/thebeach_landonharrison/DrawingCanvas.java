/**
 Landon Harrison
 Version 09/23
 this file calls both the Drawing controller and model
 it holds all of the drawn elements and drawing methods
 this will get called by main activity to draw on the surface view
 */

package edu.up.thebeach_landonharrison;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.TextView;

public class DrawingCanvas extends SurfaceView {

    //For instantiating instances of colors
    Paint skyBlueDC = new Paint();
    Paint oceanBlue = new Paint();
    Paint sunOrange = new Paint();
    Paint birdBlack = new Paint();
    Paint treeTrunk = new Paint();
    Paint treeTop = new Paint();
    Paint beachSand = new Paint();
    TextView GreenValue;

    //random constants to be filled and used later
    public static final float sun = 40;
    public static final float ocean = 400.0f;
    public static final float beach = 300.0f;
    public static final float treeTrunkShape = 40.0f;
    public static final float treeTopShape = 40.0f;
    public static final float birdSize = 5.0f;

    //instantiates the other java classes
    private DrawingModel drawingModel;
    private DrawingController drawingCon;

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
        skyBlueDC.setColor(getDrawingModel().skyBlue);
        sunOrange.setColor(getDrawingModel().sunOrangeCode);
        birdBlack.setColor(getDrawingModel().birdBlackCode);
        treeTrunk.setColor(getDrawingModel().treeTrunk);
        treeTop.setColor(getDrawingModel().treeGreen);
        oceanBlue.setColor(getDrawingModel().oceanBlue);
        beachSand.setColor(getDrawingModel().sandy);

        setBackgroundColor(skyBlueDC.getColor());

    }


    //get methods to call in Model and Controller
    public DrawingModel getDrawingModel(){

        return this.drawingModel;

    }

    public DrawingController getDrawingCon() {

        return this.drawingCon;

    }

    //method to draw number of birds that the program feeds,
    //later will be available for user to adjust
    public void drawBird(Canvas canvas, float numBirds) {

        //initiates the location variables
        float xRecL = 1220;
        float xRecR = 1270;
        float xRecT = 328;
        float xRecB = 338;
        float cX = 1245;
        float cY = 340;

        for (int q = 0; q < numBirds; q++) {

            //draws a bird
            canvas.drawRect(xRecL, xRecT, xRecR, xRecB, birdBlack);
            canvas.drawCircle(cX, cY, 10, birdBlack);

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

    //draws all of the elements on the surface view
    //pulls in assigned colors
    @Override
    protected void onDraw(android.graphics.Canvas canvas) {

        canvas.drawCircle(600, 750, 300, sunOrange);
        canvas.drawRect(0, 800, 3000, 2000, oceanBlue);
        canvas.drawRect(0, 950, 3000, 2000, beachSand);

        canvas.drawRect(2000, 500, 2070, 1500, treeTrunk);
        canvas.drawCircle(2050, 500, 200, treeTop);


        canvas.drawText("Hello CS301", 400, 100, sunOrange);

        drawBird(canvas, 23);

    }

}