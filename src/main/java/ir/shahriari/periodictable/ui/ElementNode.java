package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.Main;
import ir.shahriari.periodictable.model.Element;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ElementNode extends VBox {

    private final Element element;

    private boolean blockMouseClick;

    public ElementNode(Element element) {
        setPrefSize(90, 90);
        setPadding(new Insets(5));
        setCursor(Cursor.HAND);
        getStyleClass().add("element-node");

        if (element == null) {
            element = new Element("", "", 0, 0, 0, Color.TRANSPARENT, null);
            setBlockMouseClick(true);
        }
        this.element = element;

        var atomicNumberLabel = new Label(element.atomicNumber() > 0 ? String.valueOf(element.atomicNumber()) : "");
        var symbolLabel = new Label(element.symbol());
        symbolLabel.getStyleClass().add("symbol");
        var nameLabel = new Label(element.name());

        var color = element.color();
        setStyle(
                "-fx-background-color: #" + Integer.toHexString(color.hashCode()) + ";"
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
        setOnMouseClicked(mouseClick);
    }

    private final EventHandler<MouseEvent> mouseClick = mouseEvent -> {
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
    };

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
