package com.example.ui;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class UserRepController {
    @FXML
    private Text userRep;

    public void setData(String userInput) {
        userRep.setText(userInput);
    }
}
