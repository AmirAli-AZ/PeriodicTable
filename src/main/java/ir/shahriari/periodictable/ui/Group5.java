package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group5 extends VBox implements Group {

    public Group5() {
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

        setSpacing(.5);
        getChildren().addAll(
                ElementNode.createEmptyNode(),
                ElementNode.createEmptyNode(),
                ElementNode.createEmptyNode(),
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