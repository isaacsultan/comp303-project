package JavaCool303;

import java.awt.*;

/**
 * SummerCool303Theme has a yellow color and Comic Sans Font
 * @see Cool303Theme
 * @version 1.0
 * @author isaacsultan
 */
class SummerCool303Theme extends Cool303Theme{
     SummerCool303Theme() {
        this.setPrimaryColor(Color.YELLOW);
        this.setSecondaryColor(Color.YELLOW.brighter());
        this.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
    }
}
