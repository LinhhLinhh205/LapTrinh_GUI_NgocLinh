/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class TinhToan extends JFrame{
    DecimalFormat df = new DecimalFormat("0.000");
    private JLabel lb1, lb2, lb3;
    private JTextField txtSo1, txtSo2, txtKq;
    private JButton btnCong, btnTru, btnNhan, btnChia;

    public TinhToan() {
        setTitle("Tính toán ");
        createGUI();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createGUI() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 2, 5, 5));
        p1.add(lb1 = new JLabel("Số 1"));
        p1.add(txtSo1 = new JTextField());
        p1.add(lb2 = new JLabel("Số 2"));
        p1.add(txtSo2 = new JTextField());
        p1.add(lb3 = new JLabel("Kết quả"));
        p1.add(txtKq = new JTextField());
        
        JPanel p2 = new JPanel();
        p2.add(btnCong=new JButton("Cộng"));
        p2.add(btnTru=new JButton("Trừ"));
        p2.add(btnNhan=new JButton("Nhân"));
        p2.add(btnChia=new JButton("Chia"));
        
        setLayout(new BorderLayout());
        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);
        
        btnCong.addActionListener(((e) -> {
            double x1=Double.parseDouble(txtSo1.getText());
            double x2=Double.parseDouble(txtSo2.getText());
            double kq=x1+x2;
            txtKq.setText(String.valueOf(kq));
        }));
        btnTru.addActionListener(((e) -> {
            double x1=Double.parseDouble(txtSo1.getText());
            double x2=Double.parseDouble(txtSo2.getText());
            double kq=x1-x2;
            txtKq.setText(String.valueOf(kq));
        }));
        btnNhan.addActionListener(((e) -> {
            double x1=Double.parseDouble(txtSo1.getText());
            double x2=Double.parseDouble(txtSo2.getText());
            double kq=x1*x2;
            txtKq.setText(String.valueOf(kq));
        }));
        btnChia.addActionListener(((e) -> {
            double x1=Double.parseDouble(txtSo1.getText());
            double x2=Double.parseDouble(txtSo2.getText());
            double kq=x1/x2;
            txtKq.setText(df.format(kq));
        }));

    }
    public static void main(String[] args) {
        TinhToan frm=new TinhToan();
        frm.setVisible(true);
    }
}
