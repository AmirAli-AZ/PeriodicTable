package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group1 implements Group {

    public Group1(GridPane gridPane) {
        var hydrogenNode = new ElementNode(
                new Element(
                        "Hydrogen",
                        "H",
                        1,
                        getGroupNumber(),
                        1,
                        Color.valueOf("#D32143"),
                        URI.create("https://en.wikipedia.org/wiki/Hydrogen")
                )
        );
        GridPane.setConstraints(hydrogenNode, 0, 0);

        var lithiumNode = new ElementNode(
                new Element(
                        "Lithium",
                        "Li",
                        3,
                        getGroupNumber(),
                        2,
                        Color.valueOf("#D32143"),
                        URI.create("https://en.wikipedia.org/wiki/Lithium")
                )
        );
        GridPane.setConstraints(lithiumNode, 0, 1);

        var sodiumNode = new ElementNode(
                new Element(
                        "Sodium",
                        "Na",
                        11,
                        getGroupNumber(),
                        3,
                        Color.valueOf("#D32143"),
                        URI.create("https://en.wikipedia.org/wiki/Sodium")
                )
        );
        GridPane.setConstraints(sodiumNode, 0, 2);

        var potassiumNode = new ElementNode(
                new Element(
                        "Potassium",
                        "K",
                        19,
                        getGroupNumber(),
                        1,
                        Color.valueOf("#D32143"),
                        URI.create("https://en.wikipedia.org/wiki/Potassium")
                )
        );
        GridPane.setConstraints(potassiumNode, 0, 3);

        var rubidiumNode = new ElementNode(
                new Element(
                        "Rubidium",
                        "Rb",
                        37,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#D32143"),
                        URI.create("https://en.wikipedia.org/wiki/Rubidium")
                )
        );
        GridPane.setConstraints(rubidiumNode, 0, 4);

        var caesiumNode = new ElementNode(
                new Element(
                        "Caesium",
                        "Cs",
                        55,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#D32143"),
                        URI.create("https://en.wikipedia.org/wiki/Caesium")
                )
        );
        GridPane.setConstraints(caesiumNode, 0, 5);

        var franciumNode = new ElementNode(
                new Element(
                        "Francium",
                        "Fr",
                        87,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#D32143"),
                        URI.create("https://en.wikipedia.org/wiki/Francium")
                )
        );
        GridPane.setConstraints(franciumNode, 0, 6);

        gridPane.getChildren().addAll(
                hydrogenNode,
                lithiumNode,
                sodiumNode,
                potassiumNode,
                rubidiumNode,
                caesiumNode,
                franciumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 1;
    }
}
