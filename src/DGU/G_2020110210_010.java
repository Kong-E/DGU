package DGU;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 예제 10-2 InnerClassListener
public class G_2020110210_010 extends JFrame {
  public G_2020110210_010() {
    setTitle("Action 이벤트 리스너 예제");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container c = getContentPane();
    c.setLayout(new FlowLayout());

    JButton btn = new JButton("Action");
    btn.addActionListener(new MyActionListener());
    c.add(btn);

    setSize(350, 150);
    setVisible(true);
  }

  private class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JButton b = (JButton)e.getSource();
      if (b.getText().equals("Action"))
        b.setText("액션");
      else
        b.setText("Action");
      setTitle(b.getText());
    }
  }

  public static void main(String[] args) {
    new G_2020110210_010();
  }
}
