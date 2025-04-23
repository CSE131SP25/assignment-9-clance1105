// Game.java
package assignment9;

import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Game {
    private Snake snake;
    private Food food;
    private int score;

    public Game() {
        StdDraw.enableDoubleBuffering();
        snake = new Snake();
        food = new Food();
        score = 0;
    }

    public void play() {
        while (snake.isInbounds()) { // Game loop runs while snake is on screen
            int dir = getKeypress();
            if (dir != -1) {
                snake.changeDirection(dir); // Handle user input
            }
            snake.move(); // Move snake
            if (snake.eat(food)) { // Check for collision with food
                food = new Food(); // Respawn food
                score++; // Increase score
            }
            updateDrawing(); // Redraw game
        }

        // Game over screen (creative feature)
        StdDraw.clear();
        StdDraw.text(0.5, 0.6, "Game Over!");
        StdDraw.text(0.5, 0.5, "Score: " + score);
        StdDraw.text(0.5, 0.4, "Press R to restart");
        StdDraw.show();

        // Restart option (creative feature)
        while (true) {
            if (StdDraw.isKeyPressed(KeyEvent.VK_R)) {
                Game g = new Game();
                g.play();
                break;
            }
        }
    }

    private int getKeypress() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_W)) return 1;
        if (StdDraw.isKeyPressed(KeyEvent.VK_S)) return 2;
        if (StdDraw.isKeyPressed(KeyEvent.VK_A)) return 3;
        if (StdDraw.isKeyPressed(KeyEvent.VK_D)) return 4;
        return -1;
    }

    private void updateDrawing() {
        StdDraw.clear();
        snake.draw();
        food.draw();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.1, 0.95, "Score: " + score); // Display score (creative feature)
        StdDraw.pause(50);
        StdDraw.show();
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.play();
    }
}
