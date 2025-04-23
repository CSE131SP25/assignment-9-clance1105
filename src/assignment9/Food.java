package assignment9;

import java.awt.Color;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;

public class Food {
    public static final double FOOD_SIZE = 0.02;
    private double x, y;

    public Food() {
        Random rand = new Random();
        this.x = FOOD_SIZE + (1 - 2 * FOOD_SIZE) * rand.nextDouble();
        this.y = FOOD_SIZE + (1 - 2 * FOOD_SIZE) * rand.nextDouble();
    }

    public void draw() {
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(x, y, FOOD_SIZE);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
