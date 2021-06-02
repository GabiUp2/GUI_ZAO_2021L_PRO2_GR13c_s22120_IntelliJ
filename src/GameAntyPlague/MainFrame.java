package GameAntyPlague;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame{

    public MainFrame(){
        generateFrame();
    }

    public void generateFrame() {

        this.setTitle("GUI_ZAO_2021L_PRO2_GR13c_s22120_IntelliJ");
        this.setMinimumSize(new Dimension(640, 480));
        this.setPreferredSize(new Dimension(640, 480));
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel ButtonPanel = new JPanel();

        ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.PAGE_AXIS));
        ButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
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
                MainFrame::exitAction
        );

        JPanel InfoPanel = new JPanel();
        InfoPanel.setLayout(new BoxLayout(InfoPanel, BoxLayout.PAGE_AXIS));
        InfoPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        this.add(ButtonPanel);
        this.add(InfoPanel);
    }

    private static void exitAction(ActionEvent e) {
        System.out.println("Exit!");
        System.exit(0);
    }
}
