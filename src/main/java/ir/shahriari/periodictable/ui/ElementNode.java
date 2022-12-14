package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.Main;
import ir.shahriari.periodictable.model.Element;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class ElementNode extends VBox {

    private Element element;

    private boolean blockMouseClick;

    private final Tooltip tooltip;

    private final Label atomicNumberLabel, symbolLabel, nameLabel, atomicMass;

    public ElementNode(Element element) {
        Objects.requireNonNull(element);
        this.element = element;

        setPrefSize(90, 90);
        setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        setPadding(new Insets(5));
        setCursor(Cursor.HAND);
        getStyleClass().add("element-node");

        atomicNumberLabel = new Label(String.valueOf(element.atomicNumber()));
        atomicNumberLabel.getStyleClass().add("atomic-number");
        symbolLabel = new Label(element.symbol());
        symbolLabel.getStyleClass().add("symbol");
        nameLabel = new Label(element.name());
        nameLabel.getStyleClass().add("name");
        atomicMass = new Label(String.valueOf(element.atomicMass()));
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
            var infoDialog = Main.getInstance().getInfoDialog();
            infoDialog.setElement(element);
            infoDialog.openDialog();
        });

        tooltip = new Tooltip(getTooltipMessage());
        Tooltip.install(this, tooltip);
    }

    public final Element getElement() {
        return element;
    }

    public final void setElement(Element element) {
        Objects.requireNonNull(element);
        this.element = element;

        atomicNumberLabel.setText(String.valueOf(element.atomicNumber()));
        symbolLabel.setText(element.symbol());
        nameLabel.setText(element.name());
        atomicMass.setText(String.valueOf(element.atomicMass()));

        var block = element.block();
        switch (block.toLowerCase()) {
            case "s" -> getStyleClass().set(1, "s-block");
            case "p" -> getStyleClass().set(1, "p-block");
            case "d" -> getStyleClass().set(1, "d-block");
            case "f" -> getStyleClass().set(1, "f-block");
        }
    }

    public final void setBlockMouseClick(boolean blockMouseClick) {
        this.blockMouseClick = blockMouseClick;
        if (blockMouseClick) {
            setCursor(Cursor.DEFAULT);
            Tooltip.uninstall(this, tooltip);
        }else {
            setCursor(Cursor.HAND);
            Tooltip.install(this, tooltip);
        }
    }

    public final boolean isMouseClickBlocked() {
        return blockMouseClick;
    }

    public final String getTooltipMessage() {
        return  "Atomic Number: " + element.atomicNumber() + '\n' +
                "Name: " + element.name() + '\n' +
                "Symbol: " + element.symbol() + '\n' +
                "Atomic Mass: " + element.atomicMass() + '\n' +
                "Group: " + element.group() + '\n' +
                "Period: " + element.period();
    }

}
