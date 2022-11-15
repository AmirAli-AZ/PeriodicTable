package ir.shahriari.periodictable.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PlaceHolder extends VBox {

    public PlaceHolder(String text) {
        setPrefSize(90, 90);
        setPadding(new Insets(5));
        setAlignment(Pos.CENTER);
        getStyleClass().add("place-holder");

        getChildren().add(new Label(text));
    }
}
