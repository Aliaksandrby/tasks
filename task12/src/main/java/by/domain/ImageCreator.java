package by.domain;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageCreator {

    private BufferedImage image;

    public ImageCreator(int counter) {
        image = new BufferedImage(300,50,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.setFont(new Font("Serif",Font.BOLD,40));
        int r = (int)(Math.random()*255);
        int g = (int)(Math.random()*255);
        int b = (int)(Math.random()*255);
        graphics2D.setColor(new Color(r,g,b));
        graphics2D.drawString("Count visit: " + (counter),10,35);
    }

    public BufferedImage getImage() {
        return image;
    }
}
