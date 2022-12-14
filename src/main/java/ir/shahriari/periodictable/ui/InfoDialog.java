package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.utils.Theme;
import ir.shahriari.periodictable.utils.ThemeManger;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class InfoDialog extends Stage {

    private final Builder builder;
    private ScaleTransition scaleTransition = new ScaleTransition();
    private final Parent ownerRoot;

    public InfoDialog(Builder builder) {
        super(StageStyle.TRANSPARENT);

        this.builder = builder;
        ownerRoot = builder.owner.getScene().getRoot();

        initOwner(builder.owner);
        initModality(Modality.APPLICATION_MODAL);
        var scene = new Scene(builder.root, Color.TRANSPARENT);
        if (ThemeManger.load() == Theme.LIGHT)
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/ir/shahriari/periodictable/themes/light-dialog-theme.css")).toExternalForm());
        else
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/ir/shahriari/periodictable/themes/dark-dialog-theme.css")).toExternalForm());
        setScene(scene);

        scaleTransition.durationProperty().bind(builder.durationProperty);
        scaleTransition.setFromX(0);
        scaleTransition.setFromY(0);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.setNode(builder.root);
        scaleTransition.setInterpolator(Interpolator.EASE_BOTH);
    }

    public Duration getDuration() {
        return builder.durationProperty.get();
    }

    public void setDuration(Duration duration) {
        builder.durationProperty.set(duration);
    }

    public ObjectProperty<Duration> durationProperty() {
        return builder.durationProperty;
    }

    public void openDialog() {
        show();
        var bounds = ownerRoot.localToScreen(ownerRoot.getBoundsInLocal());
        setX(bounds.getMinX() + (bounds.getWidth() - getWidth()) / 2);
        setY(bounds.getMinY() + (bounds.getHeight() - getHeight()) / 2);
        scaleTransition.play();
    }

    public void closeDialog() {
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(2);
        scaleTransition.setOnFinished(event -> close());
        scaleTransition.playFrom(scaleTransition.getDuration());
    }

    public static class Builder {

        // UI components
        private final BorderPane root = new BorderPane();
        private final ButtonBar buttonBar = new ButtonBar();
        private final Button positiveButton = new Button(), negativeButton = new Button();
        private final ObjectProperty<Duration> durationProperty = new SimpleObjectProperty<>(Duration.millis(300));
        private final List<EventHandler<ActionEvent>> positiveEventHandlers = new ArrayList<>(), negativeEventsHandler = new ArrayList<>();
        private final Window owner;
        private boolean positiveButtonAdded, negativeButtonAdded;
        private InfoDialog modalDialog;

        private final Element element;

        public Builder(Element element, Window owner) {
            this.element = element;
            this.owner = owner;

            root.setId("window");
            root.setPrefSize(600, 400);
            root.setPadding(new Insets(8));

            Label titleLabel = new Label(element.name());
            titleLabel.setId("title");
            root.setTop(titleLabel);

            var elementNode = new ElementNode(element);
            elementNode.setBlockMouseClick(true);
            var headerInfo = new HBox(elementNode);
            headerInfo.setAlignment(Pos.CENTER);
            var infoTextArea = new TextArea(getInfo());
            infoTextArea.setId("info-text-area");
            infoTextArea.setEditable(false);
            infoTextArea.setWrapText(true);
            var infoBox = new VBox(5, headerInfo, infoTextArea);
            root.setCenter(infoBox);

            positiveButton.setDefaultButton(true);
            positiveButton.setId("positive-button");
            negativeButton.setId("negative-button");

            buttonBar.setPadding(new Insets(8));
            root.setBottom(buttonBar);
        }

        public Builder setPositiveButton(String text, EventHandler<ActionEvent> event) {
            if (event != null)
                positiveEventHandlers.add(event);
            positiveButton.setText(text);
            positiveButton.setOnAction(actionEvent -> {
                if (modalDialog != null)
                    modalDialog.closeDialog();
                positiveEventHandlers.forEach(eventEventHandler -> eventEventHandler.handle(actionEvent));
            });

            if (!positiveButtonAdded) {
                buttonBar.getButtons().add(positiveButton);
                positiveButtonAdded = true;
            }

            return this;
        }

        public Builder setNegativeButton(String text, EventHandler<ActionEvent> event) {
            if (event != null)
                negativeEventsHandler.add(event);
            negativeButton.setText(text);
            negativeButton.setOnAction(actionEvent -> {
                if (modalDialog != null)
                    modalDialog.closeDialog();
                negativeEventsHandler.forEach(eventEventHandler -> eventEventHandler.handle(actionEvent));
            });

            if (!negativeButtonAdded) {
                buttonBar.getButtons().add(negativeButton);
                negativeButtonAdded = true;
            }

            return this;
        }

        public Builder setDuration(Duration duration) {
            durationProperty.set(duration);

            return this;
        }

        private String getInfo() {
            return "Atomic Number: " + element.atomicNumber() + '\n' +
                    "Name: " + element.name() + '\n' +
                    "Symbol: " + element.symbol() + '\n' +
                    "Atomic Mass: " + element.atomicMass() + '\n' +
                    "Group: " + element.group() + '\n' +
                    "Period: " + element.period() + "\n\n" +
                    "Summary: " + element.summary();
        }

        public InfoDialog create() {
            modalDialog = new InfoDialog(this);
            return modalDialog;
        }
    }
}
