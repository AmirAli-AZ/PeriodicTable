package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.utils.ThemeManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BohrModelWindow extends Stage {

    public BohrModelWindow(int[] shells) {
        var model = new BohrModel(shells);

        var scrollPane = new ScrollPane(model);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        var slider = new Slider();
        HBox.setHgrow(slider, Priority.ALWAYS);
        slider.setValue(model.getCore().getRadius());
        slider.valueProperty().addListener((observableValue, oldValue, newValue) -> model.getCore().setRadius(newValue.doubleValue()));

        var zoomOutLabel = new Label("ZoomOut");
        zoomOutLabel.setFont(Font.font(16));
        var zoomInLabel = new Label("ZoomIn");
        zoomInLabel.setFont(Font.font(16));

        var bottom = new HBox(3, zoomOutLabel, slider, zoomInLabel);
        bottom.setAlignment(Pos.CENTER);

        var borderPane = new BorderPane();
        borderPane.setId("root");
        borderPane.setPadding(new Insets(10));
        borderPane.setCenter(scrollPane);
        borderPane.setBottom(bottom);

        var scene = new Scene(borderPane, 900, 600);
        ThemeManager.setTheme(scene, ThemeManager.load());
        setTitle("Bohr's Model");
        setScene(scene);
    }

    public BohrModelWindow(Element element) {
        this(element.shells());
    }
}
