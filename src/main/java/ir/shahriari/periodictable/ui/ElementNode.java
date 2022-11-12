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

    private final Tooltip tooltip;

    public ElementNode(Element element) {
        Objects.requireNonNull(element);
        this.element = element;

        setPrefSize(90, 90);
        setPadding(new Insets(5));
        setCursor(Cursor.HAND);
        getStyleClass().add("element-node");

        var atomicNumberLabel = new Label(String.valueOf(element.atomicNumber()));
        atomicNumberLabel.getStyleClass().add("atomic-number");
        var symbolLabel = new Label(element.symbol());
        symbolLabel.getStyleClass().add("symbol");
        var nameLabel = new Label(element.name());
        nameLabel.getStyleClass().add("name");
        var atomicMass = new Label(String.valueOf(element.atomicMass()));
        atomicMass.getStyleClass().add("atomic-mass");

        var block = element.block();
        switch (block.toLowerCase()) {
            case "s" -> getStyleClass().add("s-block");
            case "p" -> getStyleClass().add("p-block");
            case "d" -> getStyleClass().add("d-block");
            case "f" -> getStyleClass().add("f-block");
        }

        getChildren().addAll(atomicNumberLabel, symbolLabel, nameLabel, atomicMass);
        setOnMouseClicked(mouseEvent -> {
            if (isMouseClickBlocked())
                return;
            var infoDialog = new InfoDialog.Builder(element, getScene().getWindow())
                    .setNegativeButton("OK", null)
                    .setPositiveButton("Source", actionEvent -> {
                        var mainInstance = Main.getInstance();
                        mainInstance.getHostServices().showDocument(element.source());
                    })
                    .create();
            infoDialog.openDialog();
        });

        tooltip = new Tooltip(getTooltipMessage());
        Tooltip.install(this, tooltip);
    }

    public Element getElement() {
        return element;
    }

    public void setBlockMouseClick(boolean blockMouseClick) {
        this.blockMouseClick = blockMouseClick;
        if (blockMouseClick) {
            setCursor(Cursor.DEFAULT);
            Tooltip.uninstall(this, tooltip);
        }else {
            setCursor(Cursor.HAND);
            Tooltip.install(this, tooltip);
        }
    }

    public boolean isMouseClickBlocked() {
        return blockMouseClick;
    }

    public String getTooltipMessage() {
        return  "Atomic Number: " + element.atomicNumber() + '\n' +
                "Name: " + element.name() + '\n' +
                "Symbol: " + element.symbol() + '\n' +
                "Atomic Mass: " + element.atomicMass() + '\n' +
                "Group: " + element.group() + '\n' +
                "Period: " + element.period();
    }

}
