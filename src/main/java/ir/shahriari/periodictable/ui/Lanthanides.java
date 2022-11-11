package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Lanthanides implements Group {

    public Lanthanides(GridPane gridPane) {
        var lanthanumNode = new ElementNode(
                new Element(
                        "Lanthanum",
                        "La",
                        57,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Lanthanum")
                )
        );
        GridPane.setConstraints(lanthanumNode, 3, 7);

        var ceriumNode = new ElementNode(
                new Element(
                        "Cerium",
                        "Ce",
                        58,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Cerium")
                )
        );
        GridPane.setConstraints(ceriumNode, 4, 7);

        var praseodymiumNode = new ElementNode(
                new Element(
                        "Praseodymium",
                        "Pr",
                        59,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Praseodymium")
                )
        );
        GridPane.setConstraints(praseodymiumNode, 5, 7);

        var neodymiumNode = new ElementNode(
                new Element(
                        "Neodymium",
                        "Nd",
                        60,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Neodymium")
                )
        );
        GridPane.setConstraints(neodymiumNode, 6, 7);

        var promethiumNode = new ElementNode(
                new Element(
                        "Promethium",
                        "Pm",
                        61,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Promethium")
                )
        );
        GridPane.setConstraints(promethiumNode, 7, 7);

        var samariumNode = new ElementNode(
                new Element(
                        "Samarium",
                        "Sm",
                        62,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Samarium")
                )
        );
        GridPane.setConstraints(samariumNode, 8, 7);

        var europiumNode = new ElementNode(
                new Element(
                        "Europium",
                        "Eu",
                        63,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Europium")
                )
        );
        GridPane.setConstraints(europiumNode, 9, 7);

        var gadoliniumNode = new ElementNode(
                new Element(
                        "Gadolinium",
                        "Gd",
                        64,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Gadolinium")
                )
        );
        GridPane.setConstraints(gadoliniumNode, 10, 7);

        var terbiumNode = new ElementNode(
                new Element(
                        "Terbium",
                        "Tb",
                        65,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Terbium")
                )
        );
        GridPane.setConstraints(terbiumNode, 11, 7);

        var dysprosiumNode = new ElementNode(
                new Element(
                        "Dysprosium",
                        "Dy",
                        66,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Dysprosium")
                )
        );
        GridPane.setConstraints(dysprosiumNode, 12, 7);

        var holmiumNode = new ElementNode(
                new Element(
                        "Holmium",
                        "Ho",
                        67,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Holmium")
                )
        );
        GridPane.setConstraints(holmiumNode, 13, 7);

        var erbiumNode = new ElementNode(
                new Element(
                        "Erbium",
                        "Er",
                        68,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Erbium")
                )
        );
        GridPane.setConstraints(erbiumNode, 14, 7);

        var thuliumNode = new ElementNode(
                new Element(
                        "Thulium",
                        "Tm",
                        69,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Thulium")
                )
        );
        GridPane.setConstraints(thuliumNode, 15, 7);

        var ytterbiumNode = new ElementNode(
                new Element(
                        "Ytterbium",
                        "Yb",
                        70,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Ytterbium")
                )
        );
        GridPane.setConstraints(ytterbiumNode, 16, 7);

        var lutetiumNode = new ElementNode(
                new Element(
                        "Lutetium",
                        "Lu",
                        71,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#f2c80a"),
                        URI.create("https://en.wikipedia.org/wiki/Lutetium")
                )
        );
        GridPane.setConstraints(lutetiumNode, 17, 7);

        gridPane.getChildren().addAll(
                lanthanumNode,
                ceriumNode,
                praseodymiumNode,
                neodymiumNode,
                promethiumNode,
                samariumNode,
                europiumNode,
                gadoliniumNode,
                terbiumNode,
                dysprosiumNode,
                holmiumNode,
                erbiumNode,
                thuliumNode,
                ytterbiumNode,
                lutetiumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 3;
    }
}
