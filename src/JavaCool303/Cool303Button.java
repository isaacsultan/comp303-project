package JavaCool303;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import static java.lang.System.out;

/**
 * Cool303Button class is a JButton wrapper that allows themes to be applied
 *
 * @author isaacsultan
 * @version 1.0
 */
public class Cool303Button extends Cool303Component {

    private final String label;


    /**
     * Constructor for Cool303Button
     * Sets prefered size of button to 400*230
     *
     * @param label a text label on the button
     */
    Cool303Button(String label) {
        this.label = label;
        initializeComponent();
        this.setPreferredSize(new Dimension(400, 230));
    }

    /**
     * Adds an actions lister to each button to print value when pressed
     *
     * @see Cool303Button#buttonPressed()
     */
    void initializeComponent() {
        JButton button = new JButton(this.label);
        button.addActionListener(e -> buttonPressed());
        super.setComponent(button);
    }

    /**
     * Prints the label of a button
     */
    private void buttonPressed() {
        out.println(this.label);
    }

    /**
     * Sets colour and font
     * theme of root: set background of a button to the secondary colour, and font specified
     * @see Cool303Theme
     */
    public void paintComponent() {
        this.getComponent().setOpaque(true);
        this.getComponent().setBackground(this.getTheme().getSecondaryColor());
        this.getComponent().setFont(this.getTheme().getFont());
    }
}
