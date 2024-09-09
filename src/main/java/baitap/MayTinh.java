/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class MayTinh extends JFrame{
    private JTextField txtDis;
    private JButton btnReset;
    private JButton[] bt = new JButton[16];
    private String[] str = new String[]{"7", "8", "9", "/", "4", "5", "6", "*",
                                        "1", "2", "3", "-", "0", ".", "=", "+"};

    private double result = 0;
    private String phepTinh = "";
    private boolean phepToanMoi = true;

    public MayTinh() {
        setTitle("Máy tính");
        createGUI();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createGUI() {
        txtDis = new JTextField();
        txtDis.setPreferredSize(new Dimension(165, 28));
        btnReset = new JButton("C");

        JPanel p1 = new JPanel();
        p1.add(txtDis);
        p1.add(btnReset);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(4, 4, 5, 5));

        for (int i = 0; i < bt.length; i++) {
            bt[i] = new JButton(str[i]);
            p2.add(bt[i]);

            bt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String a = e.getActionCommand();

                    if (a.charAt(0) >= '0' && a.charAt(0) <= '9' || a.equals(".")) {
                        if (phepToanMoi) {
                            txtDis.setText("");
                            phepToanMoi = false;
                        }
                        if (a.equals(".") && txtDis.getText().contains(".")) {
                            return;
                        }
                        txtDis.setText(txtDis.getText() + a);
                    } else if (a.equals("C")) {
                        txtDis.setText("");
                        result = 0;
                        phepTinh = "";
                        phepToanMoi = true;
                    } else if (a.equals("=")) {
                        if (!phepTinh.isEmpty() && !txtDis.getText().isEmpty()) {
                            calculate(Double.parseDouble(txtDis.getText()));
                            txtDis.setText(String.valueOf(result));
                            phepTinh = "";
                            phepToanMoi = true;
                        }
                    } else { // Các phép toán khác (+, -, *, /)
                        if (!phepTinh.isEmpty() && !txtDis.getText().isEmpty()) {
                            calculate(Double.parseDouble(txtDis.getText()));
                        } else {
                            result = Double.parseDouble(txtDis.getText());
                        }
                        phepTinh = a;
                        phepToanMoi = true;
                    }
                }
            });
        }

        setLayout(new BorderLayout());
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        btnReset.addActionListener(e -> {
            txtDis.setText("");
            result = 0;
            phepTinh = "";
            phepToanMoi = true;
        });
    }

    private void calculate(double number) {
        switch (phepTinh) {
            case "+":
                result += number;
                break;
            case "-":
                result -= number;
                break;
            case "*":
                result *= number;
                break;
            case "/":
                if (number == 0) {
                    txtDis.setText("Lỗi"); // Xử lý lỗi chia cho 0
                    phepTinh = "";
                    phepToanMoi = true;
                    return;
                }
                result /= number;
                break;
            default:
                result = number;
                break;
        }
    }

    public static void main(String[] args) {
        MayTinh frm = new MayTinh();
        frm.setVisible(true);
    }
    
}
