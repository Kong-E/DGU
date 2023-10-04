package DGU;

import javax.swing.*;
import java.awt.*;

// 예제 9-5 GridLayoutEx : GridLayout으로 입력 폼 만들기
public class G_2020110210_008 extends JFrame {
    public G_2020110210_008() {
        setTitle("GridLayout Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout()); //Frame의 기본 content pane의 레이아웃을 FlowLayout으로 설정

        JPanel gridPanel = new JPanel();
        GridLayout grid = new GridLayout(6, 2);
        grid.setVgap(5);
        gridPanel.setLayout(grid);
        gridPanel.setPreferredSize(new Dimension(280, 170));
        gridPanel.add(new JLabel(" 학교"));
        gridPanel.add(new JTextField(""));
        gridPanel.add(new JLabel(" 학과"));
        gridPanel.add(new JTextField(""));
        gridPanel.add(new JLabel(" 학번"));
        gridPanel.add(new JTextField(""));
        gridPanel.add(new JLabel(" 이름"));
        gridPanel.add(new JTextField(""));
        gridPanel.add(new JLabel(" 과목"));
        gridPanel.add(new JTextField(""));
        gridPanel.add(new JLabel(" 메일"));
        gridPanel.add(new JTextField(""));

        JTextArea textArea = new JTextArea(4, 26); //텍스트 영역 크기(줄, 글자 수)
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        c.add(gridPanel);
        c.add(scrollPane);

        setSize(300, 300);
        setVisible(true);
    }

	public static void main(String[] args) {
		new G_2020110210_008();
	}
}
