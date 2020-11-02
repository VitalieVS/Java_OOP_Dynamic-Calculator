/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.*;

public class Calculator extends javax.swing.JFrame {

    int firstPos = 10;
    int secondPos = 95;

    String firstNumber = "";
    String secondNumber = "";

    boolean flag = false;
    JTextField input;
    char operator = ' ';
    boolean errorFlag = false;

    Calculate calculator = new Calculate();

    public Calculator() {
        initComponents();
        setLocation();
        createInput();
        createButtons();
    }

    private void setLocation() {
        Dimension screenSize, frameSize;
        int x, y;
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize = getSize();
        x = (screenSize.width - frameSize.width) / 2;
        y = (screenSize.height - frameSize.height) / 2;
        setLocation(x, y);
    }

    private void createInput() {
        input = new JTextField("");
        input.setBounds(10, 60, 235, 30);
        input.disable();
        add(input);
    }

    private void createButtons() {
        JButton b;
        int count = 0;
        String[] buttonArray = {"√", "x2", "C", "/", "7", "8", "9", "*", "4", "5", "6", "-",
            "1", "2", "3", "+", "+/-", "0", ".", "="};
        for (String buttonArray1 : buttonArray) {
            b = new JButton(buttonArray1);
            count++;
            if (count != 4) {
                b.setBounds(firstPos, secondPos, 55, 35);
                firstPos += 60;
            } else {
                b.setBounds(firstPos, secondPos, 55, 35);
                count = 0;
                secondPos += 50;
                firstPos = 10;
            }
            b.addActionListener((ActionEvent e) -> {
                clickButton(e);
            });
            Component add = add(b);
        }
    }

    public void clickButton(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        writeInput(clicked.getText());
    }

    public void writeInput(String value) {
        try {
            if (errorFlag) {
                input.setText("");
                errorFlag = false;
            }
            if (value.matches("^[0-9]*$")) {
                if (!"0".equals(input.getText())) {
                    if (!this.flag) {
                        if ("0".equals(this.firstNumber) & "0".equals(value)) {
                            input.setText(value);
                        } else {
                            this.firstNumber += value;
                            input.setText(input.getText() + value);
                        }
                    } else {
                        if ("0".equals(this.secondNumber) & "0".equals(value)) {
                            input.setText(this.firstNumber + this.operator + value);
                        } else {
                            this.secondNumber += value;
                            input.setText(input.getText() + value);
                        }
                    }
                } else {
                    input.setText("");
                    writeInput(value);
                    this.flag = false;
                }
            } else {
                switch (value) {
                    case "+":
                        writeOperator('+');
                        break;
                    case "*":
                        writeOperator('*');
                        break;
                    case "-":
                        writeOperator('-');
                        break;
                    case "/":
                        writeOperator('/');
                        break;
                    case ".":
                        writeDecimal();
                        break;
                    case "x2":
                        calculator.setFirstNumber(firstNumber);
                        input.setText(String.valueOf(calculator.square()));
                        this.firstNumber = String.valueOf(calculator.square());
                        break;
                    case "=":
                        sendData();
                        break;
                    case "√":
                        calculator.setFirstNumber(firstNumber);
                        input.setText(String.valueOf(calculator.sqrtNumber()));
                        this.firstNumber = String.valueOf(calculator.sqrtNumber());
                        break;
                    case "C":
                        clearAll();
                        break;
                    case "+/-":
                        Negate();
                        break;
                }
            }
        } catch (Exception e) {
            input.setText("error");
            errorFlag = true;
        }
    }

    void writeDecimal() {
        if (this.operator == ' ') {
            if (!this.firstNumber.contains(".")
                    && this.firstNumber.length() > 0) {
                this.firstNumber += '.';
                this.addDot();
            }
        } else {
            if (!this.secondNumber.contains(".")
                    && this.secondNumber.length() > 0) {
                this.secondNumber += '.';
                this.addDot();
            }
        }
    }

    void Negate() {      
        if (this.operator == ' ') {
            if (this.firstNumber.contains("-")) {
                this.firstNumber = this.firstNumber.replace("-", "");
                input.setText(this.firstNumber);
            } else {
                this.firstNumber = "-" + this.firstNumber;
                input.setText(this.firstNumber);
            }
        } else {           
            if (this.secondNumber.contains("-")) {
                this.secondNumber = this.secondNumber.replace("-", "");
                input.setText(this.firstNumber 
                        + this.operator 
                        + this.secondNumber);
            } else {
                this.secondNumber = "-" + this.secondNumber;
                input.setText(this.firstNumber 
                            + this.operator 
                            + this.secondNumber);
            }
        }      
    }

    void clearAll() {
        firstNumber = "";
        secondNumber = "";
        input.setText("");
        operator = ' ';
        flag = false;            
    }

    void sendData() {
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
        calculator.setOperator(operator);
        input.setText(String.valueOf(calculator.calculate()));
        this.flag = false;
        this.secondNumber = "";
        this.firstNumber = String.valueOf(calculator.calculate());
    }

    void addDot() {
        input.setText(input.getText() + '.');
    }

    void writeOperator(char requestedOperator) {
        this.operator = requestedOperator;

        if (!this.flag && input.getText().length() != 0) {
            input.setText(input.getText() + operator);
            this.flag = true;
        }
        if (this.secondNumber.length() == 0) {
            input.setText(
                    input.getText().substring(0,
                            input.getText().length() - 1));
            input.setText(input.getText() + operator);
            this.flag = true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        setForeground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(400, 500));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Calculator().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
