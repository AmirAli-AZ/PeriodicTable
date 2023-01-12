package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BohrModelWindow extends Stage {

    public BohrModelWindow(int[] shells) {
        var root = new BorderPane();
        root.setId("root");

        var model = new BohrModel(shells);

        var scrollPane = new ScrollPane(model);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        root.setCenter(scrollPane);

        var slider = new Slider();
        HBox.setHgrow(slider, Priority.ALWAYS);
        slider.setValue(model.getCore().getRadius());
        slider.valueProperty().addListener((observableValue, oldValue, newValue) -> model.getCore().setRadius(newValue.doubleValue()));

        var zoomOutLabel = new Label("ZoomOut");
        zoomOutLabel.setFont(Font.font(16));
        var zoomInLabel = new Label("ZoomIn");
        zoomInLabel.setFont(Font.font(16));

        var bottom = new HBox(3, zoomOutLabel, slider, zoomInLabel);
        bottom.setPadding(new Insets(8));
        bottom.setAlignment(Pos.CENTER);
        root.setBottom(bottom);

        var scene = new Scene(root, 900, 600);
        scene.setOnKeyPressed(keyEvent -> {
            if (new KeyCodeCombination(KeyCode.ADD, KeyCombination.CONTROL_DOWN).match(keyEvent))
                slider.setValue(slider.getValue() + 1);
            else if (new KeyCodeCombination(KeyCode.SUBTRACT, KeyCombination.CONTROL_DOWN).match(keyEvent))
                slider.setValue(slider.getValue() - 1);
        });
        setTitle("Bohr's Model");
        setScene(scene);
    }

    public BohrModelWindow(Element element) {
        this(element.shells());
    }
}
