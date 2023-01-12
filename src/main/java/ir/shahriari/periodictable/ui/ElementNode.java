package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class ElementNode extends VBox {

    private final Element element;

    private boolean blockMouseClick;

    public ElementNode(Element element) {
        Objects.requireNonNull(element);
        this.element = element;

        setPrefSize(90, 90);
        setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
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

        switch (element.block().toLowerCase()) {
            case "s" -> getStyleClass().add("s-block");
            case "p" -> getStyleClass().add("p-block");
            case "d" -> getStyleClass().add("d-block");
            case "f" -> getStyleClass().add("f-block");
        }

        getChildren().addAll(atomicNumberLabel, symbolLabel, nameLabel, atomicMass);
        setOnMouseClicked(mouseEvent -> {
            if (isMouseClickBlocked())
                return;
            var infoDialog = new InfoDialog(element, getScene().getWindow());
            infoDialog.openDialog();
        });

        Tooltip.install(this, new Tooltip(getTooltipMessage(element)));
    }

    public final Element getElement() {
        return element;
    }

    private String getTooltipMessage(Element element) {
        return  "Atomic Number: " + element.atomicNumber() + '\n' +
                "Name: " + element.name() + '\n' +
                "Symbol: " + element.symbol() + '\n' +
                "Atomic Mass: " + element.atomicMass() + '\n' +
                "Group: " + element.group() + '\n' +
                "Period: " + element.period();
    }

    public void blockMouseClick(boolean blockMouseClick) {
        this.blockMouseClick = blockMouseClick;
    }

    public boolean isMouseClickBlocked() {
        return blockMouseClick;
    }
}
