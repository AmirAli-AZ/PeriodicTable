package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.Main;
import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.TempUnits;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Duration;

import java.util.Objects;

public class InfoDialog extends Stage {

    private final ScaleTransition scaleTransition = new ScaleTransition();

    private final ObjectProperty<Duration> durationProperty = new SimpleObjectProperty<>(Duration.millis(300));

    private final Parent ownerRoot;

    private final Element element;

    public InfoDialog(Element element, Window owner) {
        super(StageStyle.TRANSPARENT);
        Objects.requireNonNull(element);
        Objects.requireNonNull(owner);

        this.element = element;
        ownerRoot = owner.getScene().getRoot();

        var content = createContent();
        var scene = new Scene(content, 600, 400, Color.TRANSPARENT);
        setScene(scene);
        initOwner(owner);
        initModality(Modality.APPLICATION_MODAL);

        scaleTransition.durationProperty().bind(durationProperty());
        scaleTransition.setFromX(0);
        scaleTransition.setFromY(0);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.setNode(content);
        scaleTransition.setInterpolator(Interpolator.EASE_BOTH);
    }

    private Parent createContent() {
        var root = new BorderPane();
        root.setId("window");

        var titleLabel = new Label(element.name());
        titleLabel.setId("title");
        titleLabel.setPadding(new Insets(8));
        root.setTop(titleLabel);

        var elementNode = new ElementNode(element);
        elementNode.blockMouseClick(true);
        elementNode.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        var bohrModelWindow = new BohrModelWindow(element);
        bohrModelWindow.initOwner(this);

        var showBohrModelButton = new Button("Show Bohr's Model");
        showBohrModelButton.setOnAction(actionEvent -> bohrModelWindow.show());

        var infoHeader = new VBox(5, elementNode, showBohrModelButton);
        infoHeader.setAlignment(Pos.CENTER);

        var infoLabel = new Label(getInfo(element));
        infoLabel.setFont(Font.font(16));
        infoLabel.setWrapText(true);

        var boil = element.boil();

        var boilLabel = new Label();
        boilLabel.setFont(Font.font(16));
        boilLabel.setAlignment(Pos.CENTER_LEFT);
        boilLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(boilLabel, Priority.ALWAYS);

        var boilUnits = new ComboBox<>(FXCollections.observableArrayList(TempUnits.values()));
        boilUnits.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            var doubleBoil = ((Number) boil).doubleValue();
            switch (newValue) {
                case KELVIN -> boilLabel.setText("Boil: " + doubleBoil);
                case CENTIGRADE -> boilLabel.setText("Boil: " + convertKelvinToCentigrade(doubleBoil));
                case FAHRENHEIT -> boilLabel.setText("Boil: " + convertKelvinToFahrenheit(doubleBoil));
            }
        });

        if (boil.toString().equalsIgnoreCase("null")) {
            boilLabel.setText("Boil: N/A");
            boilUnits.setDisable(true);
        } else {
            boilLabel.setText("Boil: " + ((Number) boil).doubleValue());
            boilUnits.getSelectionModel().select(TempUnits.KELVIN);
        }
        var boilBox = new HBox(3, boilLabel, boilUnits);
        boilBox.setAlignment(Pos.CENTER_LEFT);


        var melt = element.melt();

        var meltLabel = new Label();
        meltLabel.setFont(Font.font(16));
        meltLabel.setAlignment(Pos.CENTER_LEFT);
        meltLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(meltLabel, Priority.ALWAYS);

        var meltUnits = new ComboBox<>(FXCollections.observableArrayList(TempUnits.values()));
        meltUnits.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            var doubleMelt = ((Number) melt).doubleValue();
            switch (newValue) {
                case KELVIN -> meltLabel.setText("Melt: " + doubleMelt);
                case CENTIGRADE -> meltLabel.setText("Melt: " + convertKelvinToCentigrade(doubleMelt));
                case FAHRENHEIT -> meltLabel.setText("Melt: " + convertKelvinToFahrenheit(doubleMelt));
            }
        });

        if (melt.toString().equalsIgnoreCase("null")) {
            meltLabel.setText("Melt: N/A");
            meltUnits.setDisable(true);
        } else {
            meltLabel.setText("Melt: " + ((Number) melt).doubleValue());
            meltUnits.getSelectionModel().select(TempUnits.KELVIN);
        }
        var meltBox = new HBox(3, meltLabel, meltUnits);
        meltBox.setAlignment(Pos.CENTER_LEFT);

        var infoBox = new VBox(10, infoLabel, boilBox, meltBox);
        var scrollPane = new ScrollPane(infoBox);
        scrollPane.setFitToWidth(true);

        var centerRoot = new VBox(5, infoHeader, scrollPane);
        centerRoot.setPadding(new Insets(8));

        root.setCenter(centerRoot);

        var sourceButton = new Button("Source");
        sourceButton.getStyleClass().add("default-button");
        sourceButton.setDefaultButton(true);
        sourceButton.setOnAction(actionEvent -> Main.getInstance().getHostServices().showDocument(element.source()));

        var okButton = new Button("OK");
        okButton.setOnAction(actionEvent -> closeDialog());

        var buttonBar = new ButtonBar();
        buttonBar.setPadding(new Insets(8));
        buttonBar.getButtons().addAll(okButton, sourceButton);
        root.setBottom(buttonBar);

        return root;
    }

    private String getInfo(Element element) {
        return "Atomic Number: " + element.atomicNumber() + '\n' +
                "Name: " + element.name() + '\n' +
                "Symbol: " + element.symbol() + '\n' +
                "Atomic Mass: " + element.atomicMass() + '\n' +
                "Group: " + element.group() + '\n' +
                "Period: " + element.period() + "\n\n" +
                "Summary: " + element.summary();
    }

    public final Duration getDuration() {
        return durationProperty.get();
    }

    public final void setDuration(Duration duration) {
        durationProperty.set(duration);
    }

    public final ObjectProperty<Duration> durationProperty() {
        return durationProperty;
    }

    public final void openDialog() {
        show();
        var bounds = ownerRoot.localToScreen(ownerRoot.getBoundsInLocal());
        var width = bounds.getWidth() / 2;
        var height = bounds.getHeight() / 2;
        if (width > 600)
            setWidth(width);
        if (height > 400)
            setHeight(height);
        setX(bounds.getMinX() + (bounds.getWidth() - getWidth()) / 2);
        setY(bounds.getMinY() + (bounds.getHeight() - getHeight()) / 2);
        scaleTransition.play();
    }

    public final void closeDialog() {
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(2);
        scaleTransition.setOnFinished(event -> close());
        scaleTransition.playFrom(scaleTransition.getDuration());
    }

    private double convertKelvinToCentigrade(double kelvin) {
        return kelvin - 273.15;
    }

    private double convertKelvinToFahrenheit(double kelvin) {
        return (convertKelvinToCentigrade(kelvin) * 9 / 5) + 32;
    }
}
