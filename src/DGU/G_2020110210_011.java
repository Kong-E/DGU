package DGU;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 예제 10-3 AnonymousClassListener : 익명 클래스로 Action 이벤트 리스너 만들기
public class G_2020110210_011 extends JFrame {
  public G_2020110210_011() {
    setTitle("Action 이벤트 리스너 작성");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    JButton btn = new JButton("Action");
    c.add(btn);

    btn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();
        if(b.getText().equals("Action"))
          b.setText("액션");
        else
          b.setText("Action");
        setTitle(b.getText());
      }
    });

    setSize(350,150);
    setVisible(true);
  }

  public static void main(String[] args) {
    new G_2020110210_011();
  }
}
