/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package textmod;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import static javafx.scene.paint.Color.color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author raphaelbridts
 */
public class TextMod extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        
        ComboBox cbox = new ComboBox();
        cbox.getItems().addAll(Font.getFamilies());
        cbox.setValue(cbox.getItems().get(0));
        Slider sSlider = new Slider(0,100,50);
        Slider redSlide = new Slider(0,255,50);
        Slider greenSlide = new Slider(0,255,50);
        Slider blueSlide = new Slider(0,255,50);
        CheckBox fettCheck = new CheckBox("Fett");
        CheckBox kursivCheck = new CheckBox("Kursiv");
        Label sizeLabel = new Label("Größenregler");
        Label colorLabel = new Label("Farbregler");
        Label red = new Label("  Rot:");
        Label green = new Label(" Grün:");
        Label blue = new Label(" Blau:");
        
        Text myText = new Text("Lorem Ypsum");
        
        
        Button bInfo = new Button("Info");
        Button bClose = new Button("Close");
        HBox bottomBox = new HBox(bInfo, bClose);
        bottomBox.setAlignment(Pos.BOTTOM_RIGHT);
        bottomBox.setPadding(new Insets(15));
        bottomBox.setSpacing(10);
        
        
        HBox redBox = new HBox(red, redSlide);
        HBox greenBox = new HBox(green, greenSlide);
        HBox blueBox = new HBox(blue, blueSlide);
        
        VBox rightBox = new VBox(cbox, sizeLabel, sSlider, colorLabel, redBox, greenBox, blueBox, fettCheck, kursivCheck);
        rightBox.setPadding(new Insets(15));
        rightBox.setSpacing(10);
        
        BorderPane bPane = new BorderPane();
        bPane.setLeft(rightBox);
        bPane.setCenter(myText);
        bPane.setBottom(bottomBox);
        
        bClose.setOnAction(e -> {
            Platform.exit();
        });
        
        cbox.setOnAction(e -> {
        String choice = (String) cbox.getValue();
            System.out.println("choice");
            myText.setFont(Font.font(choice));
        });
        
        sSlider.setOnMouseDragged(e -> {
        double choise = (double) sSlider.getValue();
        myText.setFont(Font.font(choise));
        });
        
        redSlide.setOnMouseDragged(e -> {
        double red1 = redSlide.getValue();
        double green1 = greenSlide.getValue();
        double blue1 = blueSlide.getValue();
        myText.setFill(color(red1, green1, blue1));
        });
        greenSlide.setOnMouseDragged(e -> {
        double red1 = redSlide.getValue();
        double green1 = greenSlide.getValue();
        double blue1 = blueSlide.getValue();
        myText.setFill(color(red1, green1, blue1));
        });
        blueSlide.setOnMouseDragged(e -> {
        double red1 = redSlide.getValue();
        double green1 = greenSlide.getValue();
        double blue1 = blueSlide.getValue();
        myText.setFill(color(red1, green1, blue1));
        });
        
        
        
        
        Scene scene = new Scene(bPane);
        
        primaryStage.setTitle("TextMod");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    

}

    /**
     * @param args the command line arguments
     */
    
    

