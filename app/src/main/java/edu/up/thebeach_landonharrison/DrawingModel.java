/**
Landon Harrison
 Version 09/23
 this file gives the color values for drawn elements
 and is set up to hold constants to be used in the
 DrawingCanvas file
 */

package edu.up.thebeach_landonharrison;

import android.graphics.Color;

public class DrawingModel {

    //Color variables for drawing canvas
    //Will also be used in the controller to change the color
    //values when users adjust the seekbars
    public int sunOrangeCode = 0xFFEBD256;
    public int birdBlackCode = 0xFF0C1442;
    public int treeTrunk = 0xFFAD914C;
    public int skyBlue = 0xFF5BE1E0;
    public int sandy = 0xFFE0BC7D;
    public int treeGreen = 0xFFA2E05C;
    public int oceanBlue = 0xFF5AEEC0;

    //use for later when changing colors with user seekbar changes
    public int currRed = Color.red(sunOrangeCode);
    public int currBlue = Color.blue(sunOrangeCode);
    public int currGreen = Color.green(sunOrangeCode);

}