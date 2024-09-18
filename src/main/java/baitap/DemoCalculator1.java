/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class DemoCalculator1 extends JFrame {

    private JLabel lbso1, lbso2, lbresult;
    private JTextField txtso1, txtso2, txtresult;
    private JButton btncong, btntru, btnnhan, btnchia, btnketthuc;

    public DemoCalculator1(String title) {
        super(title);
        createGUI();
        setResizable(false);
        txtresult.setEditable(false);
        setSize(530, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public static void main(String[] args) {
        DemoCalculator1 frm = new DemoCalculator1("Simple Calculator");
        frm.setVisible(true);
    }

    private void createGUI() {
        JPanel pl = new JPanel();
        pl.setLayout(null);
        pl.add(lbso1 = new JLabel("Số 1"));
        pl.add(txtso1 = new JTextField());
        pl.add(lbso2 = new JLabel("Số 2"));
        pl.add(txtso2 = new JTextField());
        pl.add(lbresult = new JLabel("Kết quả"));
        pl.add(txtresult = new JTextField());

        pl.add(btncong = new JButton("Cộng"));
        pl.add(btntru = new JButton("Trừ"));
        pl.add(btnnhan = new JButton("Nhân"));
        pl.add(btnchia = new JButton("Chia"));
        pl.add(btnketthuc = new JButton("Kết thúc"));

        lbso1.setBounds(5, 20, 180, 30);
        txtso1.setBounds(200, 20, 300, 30);

        lbso2.setBounds(5, 70, 180, 30);
        txtso2.setBounds(200, 70, 300, 30);

        lbresult.setBounds(5, 110, 180, 30);
        txtresult.setBounds(200, 110, 300, 30);

        btncong.setBounds(5, 160, 90, 30);
        btntru.setBounds(105, 160, 90, 30);
        btnnhan.setBounds(205, 160, 90, 30);
        btnchia.setBounds(305, 160, 90, 30);
        btnketthuc.setBounds(405, 160, 90, 30);
        add(pl);

        btncong.addActionListener((e) -> {
            txtresult.setBackground(Color.white);
            double so1 = Double.parseDouble(txtso1.getText());
            double so2 = Double.parseDouble(txtso2.getText());
            double kq = so1 + so2;
            txtresult.setText(String.valueOf(kq));
        });
        btntru.addActionListener((e) -> {
            txtresult.setBackground(Color.white);
            double so1 = Double.parseDouble(txtso1.getText());
            double so2 = Double.parseDouble(txtso2.getText());
            double kq = so1 - so2;
            txtresult.setText(String.valueOf(kq));
        });
        btnnhan.addActionListener((e) -> {
            txtresult.setBackground(Color.white);
            double so1 = Double.parseDouble(txtso1.getText());
            double so2 = Double.parseDouble(txtso2.getText());
            double kq = so1 * so2;
            txtresult.setText(String.valueOf(kq));
        });
        btnchia.addActionListener((e) -> {
            txtresult.setBackground(Color.white);
            double so1 = Double.parseDouble(txtso1.getText());
            double so2 = Double.parseDouble(txtso2.getText());
            if (so2 == 0) {
                txtresult.setText("khong chia cho 0");
            } else {
                double kq = so1 / so2;
                txtresult.setText(String.valueOf(kq));
            }
        });
        btnketthuc.addActionListener((e)->{
            int op=JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn thoát ? ","Thông báo?",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(op==JOptionPane.OK_OPTION)
                System.exit(0);
        });
        
    }

}
