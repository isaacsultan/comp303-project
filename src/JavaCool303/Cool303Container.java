package JavaCool303;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import static javax.swing.BorderFactory.createTitledBorder;

public class Cool303Container extends Cool303Component implements Themeable {

    private JPanel panel;
    private ArrayList<Cool303Component> components;
    private String title;

    public Cool303Container() {
        initializeComponent();
        this.components = new ArrayList<>();
    }

    public Cool303Container(String title) {
        initializeComponent(title);
        this.components = new ArrayList<>();
        this.title = title;
    }


    void initializeComponent() {
        this.panel = new JPanel();
        super.setComponent(panel);
    }

    void initializeComponent(String title) {
        this.panel = new JPanel();
        this.panel.setBorder(createTitledBorder(title));
        super.setComponent(panel);
    }

    public void addCool303Component(Cool303Component component) {
        component.addTheme(getTheme());
        this.components.add(component);
        this.panel.add(component.getComponent());
    }

    public void paintComponent() {
        this.getComponent().setBackground(this.getTheme().getPrimaryColor());
        for (Cool303Component component : this.components) {
            component.paintComponent();
        }
    }


}

