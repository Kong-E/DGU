package DGU;

import java.awt.*;
import java.io.*;
import java.util.Vector;
import javax.swing.*;

public class G_2020110210_025 extends JFrame {
  // 메인 프레임 구성
  private Container c = getContentPane();
  private FileNameInputPanel p01;
  private FruitNameInputPanel p02;
  private String fileName;

  G_2020110210_025() {
    setTitle("25_2 Ex");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    c.setLayout(new BorderLayout());
    p01 = new FileNameInputPanel(this);
    c.add(p01, BorderLayout.CENTER);
    setSize(500, 350);
    setVisible(true);
  }

  // 파일 이름 설정 메서드
  public void setFileName(String fn) {
    fileName = fn;
  }

  // 파일 이름 가져오기 메서드
  public String getFileName() {
    return fileName;
  }

  // 패널 변경 메서드
  public void changePanel(int p) {
    c.removeAll();
    if (p == 1) {
      p01 = new FileNameInputPanel(this);
      c.add(p01);
    } else if (p == 2) {
      p02 = new FruitNameInputPanel(this);
      c.add(p02);
    }
    c.revalidate();
  }

  public static void main(String[] args) {
    new G_2020110210_025();
  }
}

// 파일 이름 입력 패널
class FileNameInputPanel extends JPanel {
  FileNameInputPanel(G_2020110210_025 g) {
    JLabel fileNameLabel = new JLabel("txt 파일 이름을 입력하세요.");
    JTextField fileTf = new JTextField(30);
    JButton makeFileBtn = new JButton("파일 만들기");
    makeFileBtn.addActionListener(e -> {
      String fileName = fileTf.getText().trim();
      if (fileName.isEmpty()) {
        JOptionPane.showMessageDialog(this, "파일 이름을 입력하세요.");
        return;
      }
      g.setFileName(fileName);
      File newFile = new File(fileName);
      try {
        if (newFile.createNewFile())
          g.changePanel(2);
        else
          JOptionPane.showMessageDialog(makeFileBtn, "파일이 이미 존재합니다.");
      } catch (IOException ie) {
        JOptionPane.showMessageDialog(makeFileBtn, "오류가 발생했습니다.");
      }
    });

    JButton loadFileBtn = new JButton("파일 불러오기");
    loadFileBtn.addActionListener(e -> {
      String fileName = fileTf.getText().trim();
      if (fileName.isEmpty()) {
        JOptionPane.showMessageDialog(this, "파일 이름을 입력하세요.");
        return;
      }
      g.setFileName(fileName);
      g.changePanel(2);
    });

    setLayout(new FlowLayout());
    add(fileNameLabel);
    add(fileTf);
    add(makeFileBtn);
    add(loadFileBtn);
  }
}

// 과일 이름 입력 패널
class FruitNameInputPanel extends JPanel {
  private Vector<String> fruitName;
  private String fileName;
  private JComboBox<String> cb;

  FruitNameInputPanel(G_2020110210_025 g) {
    fileName = g.getFileName();
    fruitName = new Vector<>();

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = br.readLine()) != null) {
        fruitName.add(line);
      }
    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(this, "파일을 찾을 수 없습니다.");
    } catch (IOException e) {
      JOptionPane.showMessageDialog(this, "오류가 발생했습니다.");
    }

    JPanel topPanel = new JPanel();
    topPanel.setPreferredSize(new Dimension(500, 70));
    JLabel nameLabel = new JLabel("추가 또는 삭제할 과일이름을 입력하세요.");
    JTextField nameTf = new JTextField(20);
    JButton addNameBtn = new JButton("추가하기");
    JButton deleteNameBtn = new JButton("삭제하기");
    cb = new JComboBox<>(fruitName);
    cb.setPreferredSize(new Dimension(150, 25));
    topPanel.add(nameLabel);
    topPanel.add(nameTf);
    topPanel.add(addNameBtn);
    topPanel.add(deleteNameBtn);
    topPanel.add(new JLabel("현재 이름 목록: "));
    topPanel.add(cb);

    JPanel imagePanel = new JPanel();
    JLabel imageLabel = new JLabel();
    imagePanel.add(imageLabel);
    JButton returnBtn = new JButton("처음으로");

    addNameBtn.addActionListener(e -> {
      String newFruitName = nameTf.getText();
      if (newFruitName.isEmpty()) {
        JOptionPane.showMessageDialog(this, "과일 이름을 입력하세요.");
        return;
      }
      if (fruitName.contains(newFruitName)) {
        JOptionPane.showMessageDialog(this, "이미 존재하는 과일입니다.");
        return;
      }
      fruitName.add(newFruitName);
      updateFile();
      nameTf.setText("");
    });

    deleteNameBtn.addActionListener(e -> {
      String deleteFruitName = nameTf.getText();
      if (fruitName.contains(deleteFruitName)) {
        fruitName.remove(deleteFruitName);
        updateFile();
      }
      nameTf.setText("");
    });

    returnBtn.addActionListener(e -> g.changePanel(1));

    cb.addActionListener(e -> {
      String name = (String) cb.getSelectedItem();
      if (name != null) {
        String imageName = "images/" + name + ".jpg";
        ImageIcon image = new ImageIcon(imageName);
        imageLabel.setIcon(imageSize(image));
      }
    });

    setLayout(new BorderLayout());
    add(topPanel, BorderLayout.NORTH);
    add(imagePanel, BorderLayout.CENTER);
    add(returnBtn, BorderLayout.SOUTH);
  }

  // 파일과 콤보박스 업데이트 메서드
  void updateFile() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
      for (int i = 0; i < fruitName.size(); i++) {
        bw.write(fruitName.get(i));
        if (i != fruitName.size() - 1)
          bw.newLine();
      }
      DefaultComboBoxModel<String> newModel = new DefaultComboBoxModel<>(fruitName);
      cb.setModel(newModel);
    } catch (IOException e) {
      JOptionPane.showMessageDialog(this, "오류가 발생했습니다.");
    }
  }

  // 이미지 사이즈 조절 메서드
  ImageIcon imageSize(ImageIcon i) {
    Image image = i.getImage();
    return new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
  }
}
