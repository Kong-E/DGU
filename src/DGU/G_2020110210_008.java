package DGU;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class G_2020110210_008 extends JFrame {
    public G_2020110210_008() {
        setTitle("BoxLayout Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel gridPanel = new JPanel();
        GridLayout grid = new GridLayout(6, 2); // 7 rows (including the row for the textarea), 2 columns
        grid.setVgap(5);
        gridPanel.setLayout(grid);
        
        // Set padding using EmptyBorder
        gridPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        gridPanel.setPreferredSize(new Dimension(300, 200));

        gridPanel.add(new JLabel(" 학교"));
        gridPanel.add(new JTextField("동국대학교"));

        gridPanel.add(new JLabel(" 이름"));
        gridPanel.add(new JTextField("공소연"));

        gridPanel.add(new JLabel(" 학번"));
        gridPanel.add(new JTextField("2020110210"));

        gridPanel.add(new JLabel(" 학과"));
        gridPanel.add(new JTextField("경제학과"));

        gridPanel.add(new JLabel(" 과목"));
        gridPanel.add(new JTextField("융합프로그래밍2"));

        gridPanel.add(new JLabel(" 메일"));
        gridPanel.add(new JTextField("kng001016@gmail.com"));

        // JTextArea addition
        JTextArea tf = new JTextArea(4,25);
        tf.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(tf);
        scrollPane.setPreferredSize(new Dimension(300, 100));

        JPanel textAreaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        textAreaPanel.add(scrollPane);
        
        gridPanel.add(textAreaPanel);
        gridPanel.add(new JLabel());  // Placeholder label for alignment

        getContentPane().add(gridPanel);

        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new G_2020110210_008();
    }
}
