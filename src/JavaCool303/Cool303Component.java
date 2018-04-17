package JavaCool303;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * Cool303Component is an abstract class that is extended by Cool303Container and Cool303Button
 * Components are individual GUI units that are used to populate Containers
 * @author isaacsultan
 * @version 1.0
 */
public abstract class Cool303Component extends JComponent implements Themeable {

    private Cool303Theme theme;
    private JComponent component;

    Cool303Component() { }

    public abstract void paintComponent();

    void setComponent(JComponent component) {
        this.component = component;
    }

    public void addTheme(Cool303Theme theme) {
        this.theme = theme;
    }

    public Cool303Theme getTheme() {
        return this.theme;
    }

    public JComponent getComponent() {
        return this.component;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
