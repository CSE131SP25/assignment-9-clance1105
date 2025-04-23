// ColorUtils.java
package assignment9;

import java.awt.Color;
import java.util.Random;

public class ColorUtils {
    public static Color solidColor() {
        Random r = new Random();
        return new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
    }
}