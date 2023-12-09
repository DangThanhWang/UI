package com.example.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField userMessage;

    @FXML
    private VBox view;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FXMLLoader other = new FXMLLoader();
        other.setLocation(getClass().getResource("/FXML/Content/Home/chat-bot-rep.fxml"));
        HBox chatBotBox = null;
        try {
            chatBotBox = other.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ChatBotRepController chatBotRep = other.getController();
        chatBotRep.setChatBotRep("@@");
        view.getChildren().add(chatBotBox);
    }

    @FXML
    void animation() {
        //new BounceInLeft(home).play();
    }

    @FXML
    void sendMessage(ActionEvent event) {
        if (userMessage.getText() == null) {
            return;
        }

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXML/Content/Home/user-rep.fxml"));
        HBox userBox = null;
        try {
            userBox = loader.load();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        UserRepController userRep = loader.getController();
        userRep.setData(userMessage.getText());
        view.getChildren().add(userBox);

        FXMLLoader other = new FXMLLoader();
        other.setLocation(getClass().getResource("/FXML/Content/Home/chat-bot-rep.fxml"));
        HBox chatBotBox = null;
        try {
            chatBotBox = other.load();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Thread thread = new Thread(()->{
            ChatBotRepController chatBotRep = other.getController();
            chatBotRep.setChatBotRep(userMessage.getText());
            userMessage.setText("");
        });
        thread.setDaemon(false);
        thread.start();
        view.getChildren().add(chatBotBox);
    }
}