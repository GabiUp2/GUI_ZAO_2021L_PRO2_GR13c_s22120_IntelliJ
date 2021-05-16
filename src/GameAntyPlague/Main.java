package GameAntyPlague;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        SettingsManager settingsManager = new SettingsManager(new File("settings.yaml"));
        settingsManager.print_settings();

        JFrame MainJFrame = new JFrame();
        MainJFrame.setTitle("GUI_ZAO_2021L_PRO2_GR13c_s22120_IntelliJ");
        MainJFrame.setMinimumSize(new Dimension(640, 480));
        MainJFrame.setPreferredSize(new Dimension(640, 480));
        MainJFrame.setLayout(new GridBagLayout());
        MainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel ButtonPanel = new JPanel();

        ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.PAGE_AXIS));
        ButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10,10));
        ButtonPanel.add(Box.createHorizontalGlue());

        JButton NewGameButton = new JButton("New Game");
        ButtonPanel.add(NewGameButton);
        NewGameButton.addActionListener(
                e -> System.out.println("New Game!")
        );

        ButtonPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        JButton RankingButton = new JButton("Ranking");
        ButtonPanel.add(RankingButton);
        RankingButton.addActionListener(
                e -> System.out.println("Ranking!")
        );

        ButtonPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        JButton ExitButton = new JButton("Exit");
        ButtonPanel.add(ExitButton);
        ExitButton.addActionListener(
                Main::exitAction
        );

        JPanel InfoPanel = new JPanel();
        InfoPanel.setLayout(new BoxLayout(InfoPanel, BoxLayout.PAGE_AXIS));
        InfoPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));


        MainJFrame.add(ButtonPanel);
        MainJFrame.add(InfoPanel);
        MainJFrame.setVisible(true);

    }

    private static void exitAction(ActionEvent e) {
        System.out.println("Exit!");
        System.exit(0);
    }
}
