/**
 @Author Landon Harrison
 Version 09/27
 this file gives the color values for drawn elements
 and is set up to hold constants to be used in the
 DrawingCanvas file
 debugging help from chatgpt
 */

package edu.up.thebeach_landonharrison;

import android.graphics.Color;
import android.widget.TextView;

import java.util.ArrayList;

public class DrawingModel {

    //Color variables for drawing canvas
    //Will also be used in the controller to change the color
    //values when users adjust the seekbars
    public static int sunOrangeCode = 0xFFEBD256;
    public static int birdBlackCode = 0xFF0C1442;
    public static int treeTrunk = 0xFFAD914C;
    public static int skyBlue = 0xFF5BE1E0;
    public static int sandy = 0xFFE0BC7D;
    public static int treeGreen = 0xFFA2E05C;
    public static int oceanBlue = 0xFF5AEEC0;
    public static int currColor = sunOrangeCode;


    //use for later when changing colors with user seekbar changes (Prof. Nuxoll)
    public int currRed = Color.red(sunOrangeCode);
    public int currBlue = Color.blue(sunOrangeCode);
    public int currGreen = Color.green(sunOrangeCode);

    //assigns current touch location
    public float currX = 0;
    public float currY = 0;

    public String theCurrentElement = "Pick Element";

}