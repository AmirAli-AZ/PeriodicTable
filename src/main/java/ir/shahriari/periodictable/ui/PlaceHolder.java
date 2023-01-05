package ir.shahriari.periodictable.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class PlaceHolder extends VBox {

    public PlaceHolder(String text) {
        setPrefSize(90, 90);
        setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        setPadding(new Insets(5));
        setAlignment(Pos.CENTER);
        getStyleClass().add("place-holder");

        getChildren().add(new Label(text));
    }
}
