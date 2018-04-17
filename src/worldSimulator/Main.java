package worldSimulator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.lang.System.*;

/**
 * Main class intialises Word and Simulates it in a Swing GUI
 *
 * @author isaacsultan
 */
class Main {

    /**
     * Runs 100 iterations of simulator and asks on command-line if you want to view it again
     * 1 second delay between iterations
     * Answer (yes) or (no)
     *
     * @param args None
     */
    public static void main(String[] args) {
        World world = buildWorld();
        Boolean again = true;
        Scanner sc = new Scanner(in);
        String answer;

        ViewSwing gui = new ViewSwing();
        while (again) {
            for (int i = 0; i < 100; i++) {
                world.step();
                String text = world.display(i);
                gui.setText(text);

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                }

            }

            out.println("Would you like to run the simulation again?");
            do {
                answer = sc.next();

                if (answer.equals("yes")) {
                    again = true;
                } else if (answer.equals("no")) {
                    again = false;
                }
            } while (!answer.equals("yes") && !answer.equals("no"));
        }
    }

    /**
     * Builds a 6*6 World object and fills it with items
     *
     * @return world
     */
    private static World buildWorld() {

        World world = new World(6, 6);


        Item auto = new Autonomous();
        Item move = new Movable();
        Item imo = new Immovable();

        world.add(imo, 2, 1);
        world.add(imo, 3, 2);
        world.add(imo, 4, 1);
        world.add(imo, 2, 2);
        world.add(imo, 2, 5);

        world.add(move, 0, 1);
        world.add(move, 0, 0);
        world.add(move, 1, 4);

        world.add(auto, 5, 4);
        world.add(auto, 3, 4);

        return world;

    }
}

/**
 * ViewSwing class creates a popup window with just a text-area where the current iteration can be viewed
 *
 * @author isaacsultan
 */
class ViewSwing {
    private JTextArea textArea;

    public ViewSwing() {
        prepareGUI();
    }

    private void prepareGUI() {
        JFrame mainFrame = new JFrame("World Simulator");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(1, 1));


        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                exit(0);
            }
        });

        textArea = new JTextArea(100, 100);
        JScrollPane textPane = new JScrollPane(textArea);
        textArea.setEditable(false);

        mainFrame.add(textPane);
        mainFrame.setVisible(true);
    }

    /**
     * Sets the text of the gui
     *
     * @param string returned by display()
     */
    public void setText(String string) {
        textArea.setText(string);
    }


}

