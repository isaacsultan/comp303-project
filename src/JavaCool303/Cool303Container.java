package JavaCool303;

import java.util.ArrayList;

import javax.swing.*;

import static javax.swing.BorderFactory.createTitledBorder;

/**
 * Cool303Container contains all components and a Jpanel
 * @author isaacsultan
 * @version 1.0
 */
public class Cool303Container extends Cool303Component implements Themeable {

    private JPanel panel;
    private final ArrayList<Cool303Component> components;

    /**
     * Cool303Container constructor
     */
    Cool303Container() {
        this.panel = new JPanel();
        super.setComponent(panel);
        this.components = new ArrayList<>();
    }

    /**
     * Cool303Container constructor
     * Sets a title on the top right of the container
     * @param title optional title
     */
    Cool303Container(String title) {
        this.panel = new JPanel();
        this.panel.setBorder(createTitledBorder(title));
        super.setComponent(panel);
        this.components = new ArrayList<>();
    }

    /**
     * Adds a component to the components list and to the panel
     *
     * @param component component to add
     */
    void addCool303Component(Cool303Component component) {
        component.addTheme(getTheme());
        this.components.add(component);
        this.panel.add(component.getComponent());
    }

    /**
     * Sets background of Jpanel to Theme.primaryColour
     * Paints each component
     */
    public void paintComponent() {
        this.getComponent().setBackground(this.getTheme().getPrimaryColor());
        for (Cool303Component component : this.components) {
            component.paintComponent();
        }
    }
}

