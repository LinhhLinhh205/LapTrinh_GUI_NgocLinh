/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class DemoCalculator3 extends JFrame {

    private JLabel lbso1, lbso2, lbresult, lbpheptinh;
    private JTextField txtso1, txtso2, txtresult;
    private JComboBox combobox;
    private JButton btntinh, btnnhaplai;

    public DemoCalculator3(String title) {
        super(title);
        createGUI();
        setResizable(false);
        txtresult.setEditable(false);
        setSize(340, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        DemoCalculator3 frm = new DemoCalculator3("Simple Calculator");
        frm.setVisible(true);
    }

    private void createGUI() {
        JPanel pl = new JPanel();
        pl.setLayout(null);
        pl.add(lbso1 = new JLabel("Số 1"));
        pl.add(txtso1 = new JTextField());
        pl.add(lbso2 = new JLabel("Số 2"));
        pl.add(txtso2 = new JTextField());
        pl.add(lbpheptinh = new JLabel("Phép tính"));
        String[] items = {"Cộng", "Trừ", "Nhân", "Chia"};
        pl.add(combobox = new JComboBox(items));
        pl.add(lbresult = new JLabel("Kết quả"));
        pl.add(txtresult = new JTextField());

        pl.add(btntinh = new JButton("Tính"));
        pl.add(btnnhaplai = new JButton("Nhập lại"));

        combobox.setSelectedIndex(0);

        lbso1.setBounds(5, 20, 80, 30);
        txtso1.setBounds(120, 20, 200, 30);

        lbso2.setBounds(5, 70, 80, 30);
        txtso2.setBounds(120, 70, 200, 30);

        lbpheptinh.setBounds(5, 120, 100, 30);
        combobox.setBounds(120, 120, 200, 30);

        lbresult.setBounds(5, 170, 80, 30);
        txtresult.setBounds(120, 170, 200, 30);

        btntinh.setBounds(5, 220, 150, 30);
        btnnhaplai.setBounds(165, 220, 150, 30);

        add(pl);

        btntinh.addActionListener((e) -> {

            txtresult.setBackground(Color.white);
            Object selectitem = combobox.getSelectedItem();
            String pheptinh = selectitem.toString();

            String text1 = txtso1.getText().trim();
            String text2 = txtso2.getText().trim();

            if (text1.isEmpty() || text2.isEmpty()) {
                txtresult.setText("Nội dung TextBox không được rỗng");
                return;
            } else if (!tryParseDouble(text1) || !tryParseDouble(text2)) {
                txtresult.setText("TextBox không phải kiểu số");
                return;

            } else {
                double so1 = Double.parseDouble(txtso1.getText());
                double so2 = Double.parseDouble(txtso2.getText());
                double result = 0.0;

                switch (pheptinh) {
                    case "Cộng":
                        result = so1 + so2;
                        break;
                    case "Trừ":
                        result = so1 - so2;
                        break;
                    case "Nhân":
                        result = so1 * so2;
                        break;
                    case "Chia":
                        if (so2 == 0) {
                            txtresult.setText("Khong chia cho 0");
                            return;
                        } else {
                            result = so1 / so2;
                        }
                    default:
                        txtresult.setText("Chọn phép tính");
                        break;

                }
                txtresult.setText(String.valueOf(result));
            }
        });
        btnnhaplai.addActionListener(
                (e) -> {
                    txtso1.setText("");
                    txtso2.setText("");
                    combobox.setSelectedIndex(0);
                    txtresult.setText("");
                    txtresult.setBackground(Color.white);
                    txtso1.requestFocus();
                }
        );

        txtso1.setFocusable(true);

    }

    public boolean tryParseDouble(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            txtresult.setText("Nội dung TextBox không được rỗng");
            return false;
        }
    }

}
