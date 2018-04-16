package worldSimulator;

import static java.lang.System.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.*;


class Main {


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
                } catch (Exception e) { }
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


    private static World buildWorld() {
        World simulator = new World(6, 6);

        Item auto = new Autonomous();
        Item move = new Movable();
        Item imo = new Immovable();

        simulator.add(imo, 2, 1);
        simulator.add(imo, 3, 2);
        simulator.add(imo, 4, 1);
        simulator.add(imo, 2, 2);
        simulator.add(imo, 2, 5);

        simulator.add(move, 0, 1);
        simulator.add(move, 0, 0);
        simulator.add(move, 1, 4);

        simulator.add(auto, 5, 4);
        simulator.add(auto, 3, 4);

        return simulator;
    }
}

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

    public void setText(String string) {
        textArea.setText(string);
    }


}

