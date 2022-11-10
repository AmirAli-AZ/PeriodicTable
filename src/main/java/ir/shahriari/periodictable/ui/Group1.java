package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group1 extends VBox implements Group {

    public Group1() {
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

        setSpacing(.5);
        getChildren().addAll(hydrogenNode, lithiumNode, sodiumNode, potassiumNode, rubidiumNode, caesiumNode, franciumNode);
    }

    @Override
    public int getGroupNumber() {
        return 1;
    }
}
