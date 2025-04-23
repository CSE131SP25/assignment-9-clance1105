// Snake.java
package assignment9;

import java.util.LinkedList;

public class Snake {
    private static final double SEGMENT_SIZE = 0.02;
    private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
    private LinkedList<BodySegment> segments;
    private double deltaX;
    private double deltaY;
    private boolean shouldGrow = false;

    public Snake() {
        segments = new LinkedList<>();
        segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE)); // Snake starts with 1 segment
        deltaX = 0;
        deltaY = 0;
    }

    public void changeDirection(int direction) {
        if (direction == 1) {
            deltaY = MOVEMENT_SIZE;
            deltaX = 0;
        } else if (direction == 2) {
            deltaY = -MOVEMENT_SIZE;
            deltaX = 0;
        } else if (direction == 3) {
            deltaY = 0;
            deltaX = -MOVEMENT_SIZE;
        } else if (direction == 4) {
            deltaY = 0;
            deltaX = MOVEMENT_SIZE;
        }
    }

    public void move() {
        BodySegment head = segments.getFirst();
        double newX = head.getX() + deltaX;
        double newY = head.getY() + deltaY;
        segments.addFirst(new BodySegment(newX, newY, SEGMENT_SIZE)); // Snake moves by adding head

        if (!shouldGrow) {
            segments.removeLast(); // If not growing, remove tail
        } else {
            shouldGrow = false; // If growing, keep the tail (snake grows)
        }
    }

    public void draw() {
        for (BodySegment segment : segments) {
            segment.draw();
        }
    }

    public boolean eat(Food f) {
        BodySegment head = segments.getFirst();
        double dx = head.getX() - f.getX();
        double dy = head.getY() - f.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance < SEGMENT_SIZE + Food.FOOD_SIZE) {
            shouldGrow = true; // Snake will grow on next move
            return true;
        }
        return false;
    }

    public boolean isInbounds() {
        BodySegment head = segments.getFirst();
        double x = head.getX();
        double y = head.getY();
        return x >= 0 && x <= 1 && y >= 0 && y <= 1; // Game ends if head leaves screen
    }

    public int getLength() {
        return segments.size();
    }
}