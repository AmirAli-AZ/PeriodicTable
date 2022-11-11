package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group7 implements Group {

    public Group7(GridPane gridPane) {
        var manganeseNode = new ElementNode(
                new Element(
                        "Manganese",
                        "Mn",
                        25,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Manganese")
                )
        );
        GridPane.setConstraints(manganeseNode, 6, 3);

        var technetiumNode = new ElementNode(
                new Element(
                        "Technetium",
                        "Tc",
                        43,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Technetium")
                )
        );
        GridPane.setConstraints(technetiumNode, 6, 4);

        var rheniumNode = new ElementNode(
                new Element(
                        "Rhenium",
                        "Re",
                        75,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Rehnium")
                )
        );
        GridPane.setConstraints(rheniumNode, 6, 5);

        var bohriumNode = new ElementNode(
                new Element(
                        "Bohrium",
                        "Bh",
                        107,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Bohrium")
                )
        );
        GridPane.setConstraints(bohriumNode, 6, 6);

        gridPane.getChildren().addAll(
                manganeseNode,
                technetiumNode,
                rheniumNode,
                bohriumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 7;
    }
}
