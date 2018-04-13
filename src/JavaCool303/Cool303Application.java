package JavaCool303;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class Cool303Application extends Cool303Container{


	public static void main (String [] a) {
		Cool303Root root = new Cool303Root();
		root.setLayout(new GridLayout(5, 4));
		root.setPreferredSize(new Dimension(400, 500));
		//root.pack();

		Cool303Theme pastelTheme = new PastelCool303Theme();

		Cool303Container cont = new Cool303Container("JavaCoolTitle");
		cont.addTheme(pastelTheme);

		int numberOfButtons = 20;

		for (int i = 1; i < numberOfButtons+1; i++) {
			Cool303Button b = new Cool303Button(""+i);
			cont.addCool303Component(b);
		}

		root.addCool303Component(cont);
		root.paint();
	}

}
