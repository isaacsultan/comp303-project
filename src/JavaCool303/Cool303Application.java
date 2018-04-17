package JavaCool303;

import java.awt.*;

/**
 * Cool303Application implements an button GUI
 *
 * @author isaacsultan
 * @version 1.0
 */
class Cool303Application extends Cool303Container {


    /**
     * Main method with an example of Cool303 capabilities
     * Adds 20 buttons and applies a summerTheme to the GUI (pastelTheme is also initialised)
     *
     * @param args None
     */
    public static void main(String[] args) {
        Cool303Root root = new Cool303Root();
        root.setLayout(new GridLayout(5, 4));
        root.setPreferredSize(new Dimension(400, 500));

        Cool303Theme pastelTheme = new PastelCool303Theme();
        Cool303Theme summerTheme = new SummerCool303Theme();


        Cool303Container cont = new Cool303Container("JavaCoolTitle");
        cont.addTheme(summerTheme);

        int numberOfButtons = 20;

        for (int i = 1; i < numberOfButtons + 1; i++) {
            Cool303Button b = new Cool303Button("" + i);
            cont.addCool303Component(b);
        }

        root.addCool303Component(cont);
        root.paint();
    }

}
