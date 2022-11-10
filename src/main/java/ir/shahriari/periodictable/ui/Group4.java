package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group4 extends VBox implements Group {

    public Group4(GridPane gridPane) {
        var titaniumNode = new ElementNode(
                new Element(
                        "Titanium",
                        "Ti",
                        22,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Titanium")
                )
        );
        GridPane.setConstraints(titaniumNode, 3, 3);

        var zirconiumNode = new ElementNode(
                new Element(
                        "Zirconium",
                        "Zr",
                        40,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Zirconium")
                )
        );
        GridPane.setConstraints(zirconiumNode, 3, 4);

        var hafniumNode = new ElementNode(
                new Element(
                        "Hafnium",
                        "Hf",
                        72,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Hafnium")
                )
        );
        GridPane.setConstraints(hafniumNode, 3, 5);

        var rutherfordiumNode = new ElementNode(
                new Element(
                        "Rutherfordium",
                        "Rf",
                        104,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Rutherfordium")
                )
        );
        GridPane.setConstraints(rutherfordiumNode, 3, 6);

        gridPane.getChildren().addAll(
                titaniumNode,
                zirconiumNode,
                hafniumNode,
                rutherfordiumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 4;
    }
}
