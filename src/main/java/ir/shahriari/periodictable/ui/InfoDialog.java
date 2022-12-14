package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.Main;
import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.utils.ThemeManager;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
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

import java.util.Objects;

public class InfoDialog extends Stage {

    private final ScaleTransition scaleTransition = new ScaleTransition();

    private final ObjectProperty<Duration> durationProperty = new SimpleObjectProperty<>(Duration.millis(300));

    private final Parent ownerRoot;

    private HBox headerInfo;

    private Element element;

    private ElementNode elementNode;

    private TextArea infoTextArea;

    private Label titleLabel;

    public InfoDialog(Window owner) {
        super(StageStyle.TRANSPARENT);

        ownerRoot = owner.getScene().getRoot();

        var content = createContent();
        var scene = new Scene(content, Color.TRANSPARENT);
        setScene(scene);
        initOwner(owner);
        initModality(Modality.APPLICATION_MODAL);
        setOnShowing(windowEvent -> ThemeManager.setTheme(scene, ThemeManager.load()));

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
        root.setPrefSize(600, 400);
        root.setPadding(new Insets(8));

        titleLabel = new Label();
        titleLabel.setId("title");
        titleLabel.setPadding(new Insets(8));
        root.setTop(titleLabel);

        headerInfo = new HBox();
        headerInfo.setAlignment(Pos.CENTER);

        infoTextArea = new TextArea();
        infoTextArea.setEditable(false);
        infoTextArea.setWrapText(true);

        var infoBox = new VBox(5, headerInfo, infoTextArea);
        root.setCenter(infoBox);

        var sourceButton = new Button("Source");
        sourceButton.setDefaultButton(true);
        sourceButton.setOnAction(actionEvent -> {
            if (element == null)
                return;
            Main.getInstance().getHostServices().showDocument(element.source());
        });

        var okButton = new Button("OK");
        okButton.setOnAction(actionEvent -> closeDialog());

        var buttonBar = new ButtonBar();
        buttonBar.setPadding(new Insets(8));
        buttonBar.getButtons().addAll(okButton, sourceButton);
        root.setBottom(buttonBar);

        return root;
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

    public final void setElement(Element element) {
        Objects.requireNonNull(element);
        this.element = element;

        if (elementNode == null) {
            elementNode = new ElementNode(element);
            headerInfo.getChildren().add(elementNode);
        }else {
            elementNode.setElement(element);
        }
        titleLabel.setText(element.name());
        infoTextArea.setText(getInfo());
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
        setX(bounds.getMinX() + (bounds.getWidth() - getWidth()) / 2);
        setY(bounds.getMinY() + (bounds.getHeight() - getHeight()) / 2);
        scaleTransition.play();
    }

    public final void closeDialog() {
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(2);
        scaleTransition.setOnFinished(event -> {
            close();
            scaleTransition.setAutoReverse(false);
            scaleTransition.setCycleCount(1);
            scaleTransition.setOnFinished(null);
        });
        scaleTransition.playFrom(scaleTransition.getDuration());
    }
}
