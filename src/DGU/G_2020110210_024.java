package DGU;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class G_2020110210_024 extends JFrame {
  private String[] fruits = { "apple", "cherry", "pear", "mango" };
  private JLabel imgLabel = new JLabel();
  private JComboBox<String> strCombo = new JComboBox<String>(fruits);

  public G_2020110210_024() {
    setTitle("콤보박스 활용 예제");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.add(strCombo);
    c.add(imgLabel);

    strCombo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JComboBox<String> cb = (JComboBox<String>) e.getSource();
        int index = cb.getSelectedIndex();
        ImageIcon icon = createResizedImageIcon("images/" + fruits[index] + ".jpg", 100, 100);
        imgLabel.setIcon(icon);
      }
    });

    setSize(300, 250);
    setVisible(true);
  }

  private ImageIcon createResizedImageIcon(String imagePath, int width, int height) {
    try {
      BufferedImage originalImage = ImageIO.read(new File(imagePath));
      Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(scaledImage);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void main(String[] args) {
    new G_2020110210_024();
  }
}
