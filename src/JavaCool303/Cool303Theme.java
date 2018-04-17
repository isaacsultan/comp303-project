package JavaCool303;

import java.awt.Color;
import java.awt.Font;

/**
 * Cool303Theme is a class that can be instantiated with theme preferences for the GUI
 * If a font is no used, the system default will be applied
 * @author isaacsultan
 * @version 1.0
 */
public class Cool303Theme {

	private Color primaryColor;
	private Color secondaryColor;
	private Font font;

	/**
	 * Cool303Theme constructor
	 */
	Cool303Theme() {
	}

	/**
	 * Cool303Theme constructor
	 * @param primaryColor the colour of the background
	 * @param secondaryColor the colour surrounding the button
	 */
	Cool303Theme(Color primaryColor, Color secondaryColor) {
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
	}

	/**
	 * Cool303Theme constructor
	 * @param primaryColor the colour of the background
	 * @param secondaryColor the colour surrounding the button
	 * @param font a font to set the button text to
	 */
	Cool303Theme(Color primaryColor, Color secondaryColor, Font font) {
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.font = font;
	}

	/**
	 * Sets a primaryColor
	 * @param primaryColor colour surrounding the background
	 */
	void setPrimaryColor(Color primaryColor) {
		this.primaryColor = primaryColor;
	}
	/**
	 * Sets a primaryColor
	 * @param secondaryColor colour surrounding the button
	 */
	void setSecondaryColor(Color secondaryColor) {
		this.secondaryColor = secondaryColor;
	}

	/**
	 * Gets the font of the theme
	 * @return font
	 */
	public Font getFont() {
		return font;
	}

	/**
	 * Sets the font of the theme
	 * @param font font of buttons
	 */
	void setFont(Font font) {
		this.font = font;
	}

	/**
	 * Gets the primary colour
	 * @return colour surrounding the background
	 */
	public Color getPrimaryColor() {
		return this.primaryColor;
	}

	/**
	 * Gets the secondary colour
	 * @return colour surrounding the button
	 */
	public Color getSecondaryColor() {
		return this.secondaryColor;
	}


}
