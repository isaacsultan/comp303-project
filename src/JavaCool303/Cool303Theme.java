package JavaCool303;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.border.Border;

public class Cool303Theme {

	private Color primaryColor;
	private Color secondaryColor;
	private Font font;
	private ButtonStyle buttonStyle;

	public enum ButtonStyle {
		RECTANGULAR, CIRCULAR, BUBBLE;
	}
	
	public Cool303Theme() {
	}

	public ButtonStyle getButtonStyle() {
		return buttonStyle;
	}

	public void setPrimaryColor(Color primaryColor) {
		this.primaryColor = primaryColor;
	}

	public void setSecondaryColor(Color secondaryColor) {
		this.secondaryColor = secondaryColor;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public void setButtonStyle(ButtonStyle buttonStyle) {
		this.buttonStyle = buttonStyle;
	}

	public Color getPrimaryColor() {
		return this.primaryColor;
	}
	
	public Color getSecondaryColor() {
		return this.secondaryColor;
	}


}
