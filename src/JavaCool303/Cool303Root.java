package JavaCool303;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Cool303Root is a container populated with Components and Containers.
 * It allows its components to be set with a theme by implementing Themeable
 * @author isaacsultan
 * @version 1.0
 */
public class Cool303Root extends JFrame implements Themeable{
	
	private final ArrayList<Cool303Component> components;
	private Cool303Theme theme;

	/**
	 * Constructor of Cool303Root
	 * Sets preferredSize to 400*230
	 */
	Cool303Root() {
		this.components = new ArrayList<>();
		super.setPreferredSize(new Dimension(400, 230));
		this.pack();
	}

	/**
	 * Adds a component to the Root
	 * @param component the component to add
	 */
	public void addCool303Component(Cool303Component component) {
		this.components.add(component);
		this.add(component.getComponent());
	}

	/**
	 * Paints each component in the root
	 */
	public void paint() {
		super.setLayout(new GridLayout());
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		super.pack();
		super.setVisible(true);

		for (Cool303Component component : this.components) {
			component.paintComponent();
		}
	}

	/**
	 * Adds a theme to each component
	 * @param theme a Cool303Theme object that holds styling information.
	 */
	@Override
	public void addTheme(Cool303Theme theme) {
		this.theme = theme;		
		
		for (Cool303Component component: this.components) {
			component.addTheme(theme);
		}
	}

	/**
	 * Changes dimensions of GUI
	 * GUI is set to 400*230 (the minimum size to display 20 buttons in 4*5 grid layout) by default
	 * this method resize the GUI only to a dimension equal or larger than this
	 * @param dimension to set the size of the window to
	 */
	@Override
	public void setPreferredSize(Dimension dimension){
		Dimension old = this.getPreferredSize();
		if (dimension.getWidth() >= old.getWidth() && dimension.getHeight() >= old.getHeight()){
			super.setPreferredSize(dimension);
			this.pack();
		}
	}

	/**
	 * Getter method
	 * @return theme of a root
	 */
	@Override
	public Cool303Theme getTheme() {
		return this.theme;
	}

	/**
	 * Paints an individual component
	 */
	@Override
	public void paintComponent() {
		paint();
		
	}
}
