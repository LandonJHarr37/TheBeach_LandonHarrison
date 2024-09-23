/**
 Landon Harrison
 Version 09/23
 this file doesn't do anything right now but it will be used
 later to take user input for the colors and read where on the screen
 is being pressed by the user, to assign the current drawing element
 */

package edu.up.thebeach_landonharrison;

public class DrawingController  {

    //instantiate instances of the DrawingCanvas and Model
    private DrawingCanvas theDrawing;
    private DrawingModel drawingModel;

    //empty currently
    public DrawingController(DrawingCanvas theDrawing){

        this.theDrawing = theDrawing;
        this.drawingModel = new DrawingModel();

    }

}