package com.example.ui;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ChatBotRepController {
    @FXML
    private Text chatBotRep;

    public void setChatBotRep(String userInput) {
        if (userInput.equals("@@")) {
            chatBotRep.setText("Chào bạn, tớ là M.");
            return;
        }
        chatBotRep.setText("Chào bạn, tớ là M.");
    }
}
