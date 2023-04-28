/* The Scenery Theme Program
Programmed by Andrew Au. January 15, 2020.
This program displays a setting with the theme of a rocket launch.
*/
import hsa.Console;
import java.awt.*;

public class SceneryThemeAu
{
    static Console c;
    public static void main (String[] args)
    {
	// Declare variables, arrays, and console
	c = new Console (35, 110);
	char command;
	int xCloudSpeed = 1, xCloud, counter, rocketHeight, rocketSpeed;
	Font titleFont = new Font ("Helvetica", Font.BOLD, 24);
	Color skyBlue = new Color (50, 150, 230);
	Color skyBlue2 = new Color (50, 180, 250);
	Color skyBlue3 = new Color (100, 200, 255);
	Color groundClr = new Color (100, 80, 0);
	Color mountainClr = new Color (0, 100, 0);
	Color poleYellow = new Color (250, 220, 100);
	Color sunYellow = new Color (255, 255, 150);
	Color bushGreen = new Color (30,180,0);
	Color spaceBlue = new Color (0,0,150);
	int[] xRoad = {0, 900, 500, 400};
	int[] yRoad = {550, 550, 450, 450};
	int[] xMountain1 = {0, 300, 150};
	int[] yMountain = {450, 450, 380};
	int[] xMountain2 = {700, 900, 900};

	// Draw background
	c.setColor (skyBlue); // sky
	c.fillRect (0, 0, 900, 151);
	c.setColor (skyBlue2);
	c.fillRect (0, 151, 900, 150);
	c.setColor (sunYellow); // sun
	c.fillOval (20, 20, 60, 60);
	c.setColor (poleYellow); // pole
	c.fillRect (380, 230, 7, 40);

	while (true)
	{
	    // Reset variables
	    rocketHeight = 300;
	    xCloud = 0;
	    counter = 0;
	    rocketSpeed = 3;

	    c.setColor (skyBlue3); // sky
	    c.fillRect (0, 301, 900, 149);
	    c.setColor (mountainClr); // mountain
	    c.fillPolygon (xMountain1, yMountain, 3);
	    c.fillPolygon (xMountain2, yMountain, 3);
	    c.setColor (groundClr); // ground
	    c.fillRect (0, 450, 900, 100);
	    c.setColor (Color.gray); // road
	    c.fillPolygon (xRoad, yRoad, 4);
	    c.fillRect(50,400,150,50); // short building
	    c.setColor (bushGreen); // bushes and trees
	    c.fillOval(75,440,10,10); 
	    c.fillOval(125,440,10,10);
	    c.fillOval(140,425,10,25);
	    c.fillOval(155,425,10,25);
	    c.fillOval(170,425,10,25);
	    c.fillOval(185,425,10,25);
	    c.setColor (poleYellow);
	    c.drawLine (50, 550, 405, 450); // road lines
	    c.drawLine (850, 550, 495, 450);
	    c.setColor (Color.black); // stoplight
	    c.fillRect (20, 500, 150, 50);
	    c.setColor (Color.darkGray); // tall building
	    c.fillRect (360, 270, 35, 180);
	    c.fillRect (350, 300, 20, 25);
	    c.fillRect (90,430,20,20); // door

	    drawRocket (rocketHeight);

	    // Display instructions and get input
	    c.setColor (Color.white);
	    c.fillRect (0, 550, 600, 100);
	    c.setFont (titleFont);
	    c.setColor (Color.black);
	    c.drawString ("Enter any key to launch rocket", 0, 600);
	    c.drawString ("Enter x to exit", 0, 630);
	    command = c.getChar ();
	    c.setColor (Color.white);
	    c.fillRect (0, 550, 400, 100);

	    // End program if user enters x
	    if (command == 'x')
	    {
		break;
	    }

	    while (counter < 350)
	    {
		counter++;

		// animate clouds and orange blinker
		c.setColor (Color.white);
		c.fillOval (xCloud, 80, 100, 20);
		c.fillOval (c.maxx () - xCloud, 150, 100, 20);
		if (counter % 30 == 0)
		{
		    c.setColor (Color.orange);
		    c.fillOval (360, 300, 10, 10);

		    delay (100);

		    c.setColor (Color.darkGray);
		    c.fillOval (360, 300, 10, 10);
		}
		else
		{
		    delay (100);
		}
		c.setColor (skyBlue);
		c.fillOval (xCloud, 80, 100, 20);
		c.setColor (skyBlue2);
		c.fillOval (c.maxx () - xCloud, 150, 100, 20);
		xCloud += xCloudSpeed;

		// change stoplight colour
		if (counter == 1)
		{
		    c.setColor (Color.red);
		    c.fillOval (40, 505, 40, 40);
		}
		else if (counter == 50)
		{
		    c.setColor (Color.black);
		    c.fillOval (39, 505, 42, 42);
		    c.setColor (Color.orange);
		    c.fillOval (80, 505, 40, 40);
		}
		else if (counter == 100)
		{
		    c.setColor (Color.black);
		    c.fillOval (80, 505, 40, 40);
		    c.setColor (Color.green);
		    c.fillOval (120, 505, 40, 40);
		}
		else if (counter == 185)
		{
		    rocketSpeed = 5; // increase rocket speed
		}
		else if (counter == 225)
		{
		    rocketSpeed = 7;
		}
		else if (counter == 275)
		{
		    c.setColor (Color.black);
		    c.drawString ("Hooray! The rocket launch was successful!", 0, 600);
		}

		
		// Animate rocket and rocket exhaust
		if (counter > 100 && counter < 250)
		{
		    rocketHeight -= rocketSpeed;

		    if (counter > 135)
		    {
			if (counter < 185)
			{
			    c.setColor (skyBlue3);
			}
			else if (counter < 215)
			{
			    c.setColor (skyBlue2);
			}
			else
			{
			    c.setColor (skyBlue);
			}
			c.fillRect (450, rocketHeight + 250, 20, 8);
		    }
		    
		    if (counter > 102)
		    {
			c.setColor (poleYellow);
			c.fillRect (455, rocketHeight + 150, 10, 9);
			c.setColor (Color.orange);
			c.fillRect (450, rocketHeight + 150, 5, 9);
			c.fillRect (465, rocketHeight + 150, 5, 9);
		    }

		    drawRocket (rocketHeight);
		    drawExhaust (counter);
		}
	    } // end of inner loop
	} // end of while (true) loop

	// Display End Message
	c.setColor (Color.white);
	c.fillRect (0, 550, 400, 100);
	for (int i = 0 ; i < 10 ; i++)
	{
	    c.setColor (spaceBlue);
	    c.fillRect (0, 55 * i, 900, 55);
	    delay (100);
	}
	c.setColor (Color.white);
	c.fillStar (100,100,50,50);
	c.fillStar (400,450,30,30);
	c.fillStar (200,300,30,30);
	c.fillStar (500,100,20,20);
	c.fillStar (750,400,40,40);
	c.drawString ("End of Program", 350, 250);

    } // end of main method

    // Draw rocket exhaust
    public static void drawExhaust (int counterNum)
    {
	int diameter, yExhaust, xExhaust, xExhaust2;

	if (counterNum < 145)
	{
	    diameter = (int) (20 * Math.random () + 1);
	    xExhaust = (int) (60 * Math.random () + 370);
	    xExhaust2 = (int) (60 * Math.random () + 470);
	    yExhaust = (int) (50 * Math.random () + 400);
	}
	else if (counterNum < 165)
	{
	    diameter = (int) (30 * Math.random () + 5);
	    xExhaust = (int) (75 * Math.random () + 375);
	    xExhaust2 = (int) (75 * Math.random () + 470);
	    yExhaust = (int) (40 * Math.random () + 410);
	}
	else
	{
	    diameter = (int) (50 * Math.random () + 5);
	    xExhaust = (int) (175 * Math.random () + 275);
	    xExhaust2 = (int) (175 * Math.random () + 450);
	    yExhaust = (int) (75 * Math.random () + 375);
	}
	c.setColor (Color.lightGray);
	c.fillOval (xExhaust - 5, yExhaust, diameter + 2, diameter + 2);
	c.fillOval (xExhaust2 + 5, yExhaust, diameter + 2, diameter + 2);
	c.setColor (Color.white);
	c.fillOval (xExhaust, yExhaust, diameter, diameter);
	c.fillOval (xExhaust2, yExhaust, diameter, diameter);
    } // end of drawExhaust method


    // Draw the rocket
    public static void drawRocket (int yRocket)
    {
	// body and nose cone
	c.setColor (Color.white);
	int[] xCone = {450, 463, 460};
	int[] yCone = {yRocket, yRocket, yRocket - 30};
	c.fillPolygon (xCone, yCone, 3);
	c.fillRect (450, yRocket, 13, 150);
	// shaded parts
	c.setColor (Color.lightGray);
	int[] xConeShadow = {463, 470, 460};
	c.fillPolygon (xConeShadow, yCone, 3);
	c.fillRect (463, yRocket, 7, 150);
	// black areas
	c.setColor (Color.black);
	c.fillRect (450, yRocket + 50, 20, 30);
	c.fillRect (450, yRocket + 110, 20, 10);
	c.fillRect (450, yRocket + 20, 20, 10);
    }


    // Delay method
    public static void delay (int time)
    {
	try
	{
	    Thread.sleep (time);
	}
	catch (InterruptedException e)
	{
	}
    }
} // end of SceneryThemeAu class
