package com.example.fxfirst;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField display;

    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operator = "";

    @FXML
    private void handleNumber(ActionEvent event){
        Button btn = (Button) event.getSource();
        display.setText(display.getText() + btn.getText());
    }

    @FXML
    private void handleOperator(ActionEvent event){
        Button btn = (Button) event.getSource();
        try {
            firstNumber = Double.parseDouble(display.getText());
        } catch (NumberFormatException e) {
            firstNumber = 0;
        }
        operator = btn.getText();
        display.setText("");
    }

    @FXML
    private void handleEqual(ActionEvent event){
        try {
            secondNumber = Double.parseDouble(display.getText());
        } catch (NumberFormatException e) {
            secondNumber = 0;
        }

        double result = 0;

        // if-else version
        if(operator.equals("+")){
            result = firstNumber + secondNumber;
        } else if(operator.equals("-")){
            result = firstNumber - secondNumber;
        } else if(operator.equals("*")){
            result = firstNumber * secondNumber;
        } else if(operator.equals("/")){
            if(secondNumber != 0){
                result = firstNumber / secondNumber;
            } else {
                display.setText("Error: Div by 0");
                return;
            }
        } else {
            display.setText("Error: No operator");
            return;
        }

        display.setText(String.valueOf(result));
    }

    @FXML
    private void handleClear(ActionEvent event){
        display.setText("");
        firstNumber = 0;
        secondNumber = 0;
        operator = "";
    }

    @FXML
    private void handleOff(ActionEvent event){
        System.exit(0);
    }
}
