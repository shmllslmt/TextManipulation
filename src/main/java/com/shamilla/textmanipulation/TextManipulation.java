package com.shamilla.textmanipulation;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class TextManipulation extends Application {
    private Text txtOutput;
    private CheckBox cbBold;
    private CheckBox cbItalic;
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane border = new BorderPane();

        Label lblMessage = new Label("Enter a message: ");
        TextField tfMessage = new TextField("");
        tfMessage.setOnAction(e -> {
            txtOutput.setText(tfMessage.getText());
        });

        HBox topbox = new HBox(lblMessage, tfMessage);
        topbox.setSpacing(10);
        topbox.setPadding(new Insets(10));

        border.setTop(topbox);

        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbGreen = new RadioButton("Green");
        RadioButton rbBlue = new RadioButton("Blue");

        ToggleGroup tgColour = new ToggleGroup();
        rbRed.setToggleGroup(tgColour);
        rbGreen.setToggleGroup(tgColour);
        rbBlue.setToggleGroup(tgColour);

        rbRed.setOnAction(e -> {
            txtOutput.setFill(Color.RED);
        });
        rbGreen.setOnAction(e -> {
            txtOutput.setFill(Color.GREEN);
        });
        rbBlue.setOnAction(e -> {
            txtOutput.setFill(Color.BLUE);
        });

        VBox leftbox = new VBox(rbRed, rbGreen, rbBlue);
        leftbox.setSpacing(15);
        leftbox.setPadding(new Insets(15, 10, 15, 10));
        border.setLeft(leftbox);

        cbBold = new CheckBox("Bold");
        cbItalic = new CheckBox("Italic");

        cbBold.setOnAction(e -> checkBoldItalic());

        cbItalic.setOnAction(e -> checkBoldItalic());

        VBox rightbox = new VBox(cbBold, cbItalic);
        rightbox.setSpacing(15);
        rightbox.setPadding(new Insets(15, 10, 15, 10));
        border.setRight(rightbox);

        Image imgLeft = new Image(TextManipulation.class.getResource("left.png").toString());
        ImageView ivLeft = new ImageView(imgLeft);
        Button btnLeft = new Button("Left", ivLeft);

        btnLeft.setOnAction(e -> {
            System.out.println("Left button is clicked.");
        });

        Image imgRight = new Image(TextManipulation.class.getResource("right.png").toString());
        ImageView ivRight = new ImageView(imgRight);
        Button btnRight = new Button("Right", ivRight);

        btnRight.setOnAction(e -> {
            System.out.println("Right button is clicked.");
        });

        HBox bottombox = new HBox(btnLeft, btnRight);
        bottombox.setAlignment(Pos.CENTER);
        bottombox.setSpacing(10);
        bottombox.setPadding(new Insets(10));

        border.setBottom(bottombox);

        txtOutput = new Text("");
        border.setCenter(txtOutput);

        Scene scene = new Scene(border, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void checkBoldItalic() {
        if(cbBold.isSelected() && cbItalic.isSelected())
            txtOutput.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC, 15));
        else if (cbBold.isSelected()) {
            txtOutput.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.REGULAR, 15));
        } else if (cbItalic.isSelected()) {
            txtOutput.setFont(Font.font("Georgia", FontWeight.NORMAL, FontPosture.ITALIC, 15));
        } else {
            txtOutput.setFont(Font.font("Georgia", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        }
    }
    public static void main(String[] args) {
        launch();
    }
}