package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group13 implements Group {

    public Group13(GridPane gridPane) {
        var boronNode = new ElementNode(
                new Element(
                        "Boron",
                        "B",
                        5,
                        getGroupNumber(),
                        2,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Boron")
                )
        );
        GridPane.setConstraints(boronNode, 12, 1);

        var aluminiumNode = new ElementNode(
                new Element(
                        "Aluminium",
                        "Al",
                        13,
                        getGroupNumber(),
                        3,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Aluminium")
                )
        );
        GridPane.setConstraints(aluminiumNode, 12, 2);

        var galliumNode = new ElementNode(
                new Element(
                        "Gallium",
                        "Ga",
                        31,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Gallium")
                )
        );
        GridPane.setConstraints(galliumNode, 12, 3);

        var indiumNode = new ElementNode(
                new Element(
                        "Indium",
                        "In",
                        49,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Indium")
                )
        );
        GridPane.setConstraints(indiumNode, 12, 4);

        var thalliumNode = new ElementNode(
                new Element(
                        "Thallium",
                        "Tl",
                        81,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Thallium")
                )
        );
        GridPane.setConstraints(thalliumNode, 12, 5);

        var nihoniumNode = new ElementNode(
                new Element(
                        "Nihonium",
                        "Nh",
                        113,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Nihonium")
                )
        );
        GridPane.setConstraints(nihoniumNode, 12, 6);

        gridPane.getChildren().addAll(
                boronNode,
                aluminiumNode,
                galliumNode,
                indiumNode,
                thalliumNode,
                nihoniumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 13;
    }
}
