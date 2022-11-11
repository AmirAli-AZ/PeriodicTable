package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group12 implements Group {

    public Group12(GridPane gridPane) {
        var zincNode = new ElementNode(
                new Element(
                        "Zinc",
                        "Zn",
                        30,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Zinc")
                )
        );
        GridPane.setConstraints(zincNode, 11, 3);

        var cadmiumNode = new ElementNode(
                new Element(
                        "Cadmium",
                        "Cd",
                        48,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Cadmium")
                )
        );
        GridPane.setConstraints(cadmiumNode, 11, 4);

        var mercuryNode = new ElementNode(
                new Element(
                        "Mercury",
                        "Hg",
                        80,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Mercury")
                )
        );
        GridPane.setConstraints(mercuryNode, 11, 5);

        var coperniciumNode = new ElementNode(
                new Element(
                        "Copernicium",
                        "Cn",
                        112,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Copernicium")
                )
        );
        GridPane.setConstraints(coperniciumNode, 11, 6);

        gridPane.getChildren().addAll(
                zincNode,
                cadmiumNode,
                mercuryNode,
                coperniciumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 12;
    }
}
