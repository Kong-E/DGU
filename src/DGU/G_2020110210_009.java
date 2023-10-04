package DGU;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 예제 10-1 IndepClassListener : 독립 클래스로 Action 이벤트 리스너 작성
public class G_2020110210_009 extends JFrame {
  public G_2020110210_009() {
    setTitle("Action 이벤트 리스너 예제");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    JButton btn = new JButton("Action");
    btn.addActionListener(new MyActionListener()); // 리스너 달기
    c.add(btn);

    setSize(350,150);
    setVisible(true);
  }

  public static void main(String[] args) {
    new G_2020110210_009();
  }
}

class MyActionListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    JButton b = (JButton)e.getSource();
    if(b.getText().equals("Action"))
      b.setText("액션");
    else
      b.setText("Action");
  }
}