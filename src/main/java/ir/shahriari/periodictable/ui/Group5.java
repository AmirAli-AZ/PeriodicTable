package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group5 implements Group {

    public Group5(GridPane gridPane) {
        var vanadiumNode = new ElementNode(
                new Element(
                        "Vanadium",
                        "V",
                        23,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Vanadium")
                )
        );
        GridPane.setConstraints(vanadiumNode, 4, 3);

        var niobiumNode = new ElementNode(
                new Element(
                        "Niobium",
                        "Nb",
                        41,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Niobium")
                )
        );
        GridPane.setConstraints(niobiumNode, 4, 4);

        var tantalumNode = new ElementNode(
                new Element(
                        "Tantalum",
                        "Ta",
                        73,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Tantalum")
                )
        );
        GridPane.setConstraints(tantalumNode, 4, 5);

        var dubniumNode = new ElementNode(
                new Element(
                        "Dubnium",
                        "Db",
                        105,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Dubnium")
                )
        );
        GridPane.setConstraints(dubniumNode, 4, 6);

        gridPane.getChildren().addAll(
                vanadiumNode,
                niobiumNode,
                tantalumNode,
                dubniumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 5;
    }
}