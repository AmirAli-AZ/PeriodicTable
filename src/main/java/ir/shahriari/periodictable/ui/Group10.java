package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group10 implements Group {

    public Group10(GridPane gridPane) {
        var nickelNode = new ElementNode(
                new Element(
                        "Nickel",
                        "Ni",
                        28,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Nickel")
                )
        );
        GridPane.setConstraints(nickelNode, 9, 3);

        var palladiumNode = new ElementNode(
                new Element(
                        "Palladium",
                        "Pd",
                        46,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Palladium")
                )
        );
        GridPane.setConstraints(palladiumNode, 9, 4);

        var platinumNode = new ElementNode(
                new Element(
                        "Platinum",
                        "Pt",
                        78,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Platinum")
                )
        );
        GridPane.setConstraints(platinumNode, 9, 5);

        var darmstadtiumNode = new ElementNode(
                new Element(
                        "Darmstadtium",
                        "Ds",
                        110,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Darmstadtium")
                )
        );
        GridPane.setConstraints(darmstadtiumNode, 9, 6);

        gridPane.getChildren().addAll(
                nickelNode,
                palladiumNode,
                platinumNode,
                darmstadtiumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 10;
    }
}
