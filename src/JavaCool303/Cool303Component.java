package JavaCool303;

import java.awt.Graphics;

import javax.swing.JComponent;
public abstract class Cool303Component extends JComponent implements Themeable{
	
	private Cool303Theme theme;
	
	private JComponent component;

    public Cool303Component() {

    }
	
	public abstract void paintComponent();
	abstract void initializeComponent();

    public Cool303Component(Cool303Theme theme) {
        this.theme = theme;
    }

    public void setComponent(JComponent component) {
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
	};
}
