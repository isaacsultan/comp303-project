package JavaCool303;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import static java.lang.System.out;

public class Cool303Button extends Cool303Component {

	private String label;
	private JButton button;


	public Cool303Button(String label) {
		this.label = label;
		initializeComponent();
		this.setPreferredSize(new Dimension(400, 230));
	}


	void initializeComponent() {
		this.button = new JButton(this.label);
		this.button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPressed();
			}
		});
		super.setComponent(this.button);
	}

	private void buttonPressed() {
		out.println(this.label);
	}


	public void paintComponent() {
		this.getComponent().setOpaque(true);
		this.getComponent().setBackground(this.getTheme().getSecondaryColor());
	}
}
