package JavaCool303;

import javax.swing.JFrame;
import java.awt.*;
import java.util.ArrayList;

public class Cool303Root extends JFrame implements Themeable{
	
	private ArrayList<Cool303Component> components;
	private Cool303Theme theme;

	public Cool303Root() {
		this.components = new ArrayList<>();
		super.setPreferredSize(new Dimension(400, 230));
		this.pack();
	}

	public void addCool303Component(Cool303Component component) {
		this.components.add(component);
		this.add(component.getComponent());
	}


	public void paint() {
		super.setLayout(new GridLayout());
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.pack();
		super.setVisible(true);

		for (Cool303Component component : this.components) {
			component.paintComponent();
		}
	}
	
	@Override
	public void addTheme(Cool303Theme theme) {
		this.theme = theme;		
		
		for (Cool303Component component: this.components) {
			component.addTheme(theme);
		}
	}

	@Override
	public void setPreferredSize(Dimension dimension){
		Dimension old = this.getPreferredSize();
		if (dimension.getWidth() >= old.getWidth() && dimension.getHeight() >= old.getHeight()){
			super.setPreferredSize(dimension);
			this.pack();
		}
	}

	@Override
	public Cool303Theme getTheme() {
		return this.theme;
	}

	@Override
	public void paintComponent() {
		paint();
		
	}
}
