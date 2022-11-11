package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.Main;
import ir.shahriari.periodictable.model.Element;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class ElementNode extends VBox {

    private final Element element;

    private boolean blockMouseClick;

    public ElementNode(Element element) {
        Objects.requireNonNull(element);
        this.element = element;

        setPrefSize(90, 90);
        setPadding(new Insets(5));
        setCursor(Cursor.HAND);
        getStyleClass().add("element-node");

        var atomicNumberLabel = new Label(element.atomicNumber() > 0 ? String.valueOf(element.atomicNumber()) : "");
        var symbolLabel = new Label(element.symbol());
        symbolLabel.getStyleClass().add("symbol");
        var nameLabel = new Label(element.name());

        var color = element.color();
        setStyle(
                "-fx-background-color: rgb(" + color.getRed() * 255 + ", " + color.getGreen() * 255 + ", " + color.getBlue() * 255 + ");"
        );
        if (color.getBrightness() < .9) {
            atomicNumberLabel.setStyle("-fx-text-fill: white;");
            symbolLabel.setStyle("-fx-text-fill: white;");
            nameLabel.setStyle("-fx-text-fill: white;");
        } else {
            atomicNumberLabel.setStyle("-fx-text-fill: black;");
            symbolLabel.setStyle("-fx-text-fill: black;");
            nameLabel.setStyle("-fx-text-fill: black;");
        }

        getChildren().addAll(atomicNumberLabel, symbolLabel, nameLabel);
        setOnMouseClicked(mouseEvent -> {
            if (isMouseClickBlocked())
                return;
            var infoDialog = new InfoDialog.Builder(getElement(), getScene().getWindow())
                    .setNegativeButton("OK", null)
                    .setPositiveButton("Source", actionEvent -> {
                        var mainInstance = Main.getInstance();
                        mainInstance.getHostServices().showDocument(getElement().source().toString());
                    })
                    .create();
            infoDialog.openDialog();
        });
        Tooltip.install(this, new Tooltip(getElement().toString()));
    }

    public Element getElement() {
        return element;
    }

    public void setBlockMouseClick(boolean blockMouseClick) {
        this.blockMouseClick = blockMouseClick;
        if (blockMouseClick)
            setCursor(Cursor.DEFAULT);
        else
            setCursor(Cursor.HAND);
    }

    public boolean isMouseClickBlocked() {
        return blockMouseClick;
    }

}
