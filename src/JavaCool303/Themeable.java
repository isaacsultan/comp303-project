package JavaCool303;

/**
 * Themable interface is implemented by any object that can have a theme applied
 * @see Cool303Theme
 * @author isaacsultan
 * @version 1.0
 */
interface Themeable {

    /**
     * @param theme a Cool303Theme object that holds styling information.
     *              A Cool303Theme object can be added to any Themeable class.
     */
    void addTheme(Cool303Theme theme);

    /**
     * @return the Cool303Theme private attribute of this Themeable class.
     * Each Themeable class may hold 0 or 1 Cool303Theme private attribute.
     */
    Cool303Theme getTheme();

    /**
     * Each Themeable class can have its component and child components painted.
     * Components will be painted in correspondence to a given Cool303Theme.
     */
    void paintComponent();
}
