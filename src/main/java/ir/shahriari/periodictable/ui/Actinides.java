package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Actinides implements Group {

    public Actinides(GridPane gridPane) {
        var actiniumNode = new ElementNode(
                new Element(
                        "Actinium",
                        "Ac",
                        89,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Actinium")
                )
        );
        GridPane.setConstraints(actiniumNode, 3, 8);

        var thoriumNode = new ElementNode(
                new Element(
                        "Thorium",
                        "Th",
                        90,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Thorium")
                )
        );
        GridPane.setConstraints(thoriumNode, 4, 8);

        var protactiniumNode = new ElementNode(
                new Element(
                        "Protactinium",
                        "Pa",
                        91,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Protactinium")
                )
        );
        GridPane.setConstraints(protactiniumNode, 5, 8);

        var uraniumNode = new ElementNode(
                new Element(
                        "Uranium",
                        "U",
                        92,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Uranium")
                )
        );
        GridPane.setConstraints(uraniumNode, 6, 8);

        var neptuniumNode = new ElementNode(
                new Element(
                        "Neptunium",
                        "Np",
                        93,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Neptunium")
                )
        );
        GridPane.setConstraints(neptuniumNode, 7, 8);

        var plutoniumNode = new ElementNode(
                new Element(
                        "Plutonium",
                        "Sm",
                        62,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Samarium")
                )
        );
        GridPane.setConstraints(plutoniumNode, 8, 8);

        var americiumNode = new ElementNode(
                new Element(
                        "Americium",
                        "Am",
                        95,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Americium")
                )
        );
        GridPane.setConstraints(americiumNode, 9, 8);

        var curiumNode = new ElementNode(
                new Element(
                        "Curium",
                        "Cm",
                        96,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Curium")
                )
        );
        GridPane.setConstraints(curiumNode, 10, 8);

        var berkeliumNode = new ElementNode(
                new Element(
                        "Berkelium",
                        "Bk",
                        97,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Berkelium")
                )
        );
        GridPane.setConstraints(berkeliumNode, 11, 8);

        var californiumNode = new ElementNode(
                new Element(
                        "Californium",
                        "Cf",
                        98,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Californium")
                )
        );
        GridPane.setConstraints(californiumNode, 12, 8);

        var einsteiniumNode = new ElementNode(
                new Element(
                        "Einsteinium",
                        "Es",
                        99,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Einsteinium")
                )
        );
        GridPane.setConstraints(einsteiniumNode, 13, 8);

        var fermiumNode = new ElementNode(
                new Element(
                        "Fermium",
                        "Fm",
                        100,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Fermium")
                )
        );
        GridPane.setConstraints(fermiumNode, 14, 8);

        var mendeleviumNode = new ElementNode(
                new Element(
                        "Mendelevium",
                        "Md",
                        101,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Mendelevium")
                )
        );
        GridPane.setConstraints(mendeleviumNode, 15, 8);

        var nobeliumNode = new ElementNode(
                new Element(
                        "Nobelium",
                        "No",
                        102,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Nobelium")
                )
        );
        GridPane.setConstraints(nobeliumNode, 16, 8);

        var lawrenciumNode = new ElementNode(
                new Element(
                        "Lawrencium",
                        "Lr",
                        103,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Lawrencium")
                )
        );
        GridPane.setConstraints(lawrenciumNode, 17, 8);

        gridPane.getChildren().addAll(
                actiniumNode,
                thoriumNode,
                protactiniumNode,
                uraniumNode,
                neptuniumNode,
                plutoniumNode,
                americiumNode,
                curiumNode,
                berkeliumNode,
                californiumNode,
                einsteiniumNode,
                fermiumNode,
                mendeleviumNode,
                nobeliumNode,
                lawrenciumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 3;
    }
}
