package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group11 implements Group {

    public Group11(GridPane gridPane) {
        var copperNode = new ElementNode(
                new Element(
                        "Copper",
                        "Cu",
                        29,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Copper")
                )
        );
        GridPane.setConstraints(copperNode, 10, 3);

        var silverNode = new ElementNode(
                new Element(
                        "Silver",
                        "Ag",
                        47,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Silver")
                )
        );
        GridPane.setConstraints(silverNode, 10, 4);

        var goldNode = new ElementNode(
                new Element(
                        "Gold",
                        "Au",
                        79,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Gold")
                )
        );
        GridPane.setConstraints(goldNode, 10, 5);

        var roentgeniumNode = new ElementNode(
                new Element(
                        "Roentgenium",
                        "Rg",
                        111,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Roentgenium")
                )
        );
        GridPane.setConstraints(roentgeniumNode, 10, 6);

        gridPane.getChildren().addAll(
                copperNode,
                silverNode,
                goldNode,
                roentgeniumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 11;
    }
}
