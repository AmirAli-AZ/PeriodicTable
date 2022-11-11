package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group15 implements Group {

    public Group15(GridPane gridPane) {
        var nitrogenNode = new ElementNode(
                new Element(
                        "Nitrogen",
                        "N",
                        7,
                        getGroupNumber(),
                        2,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Nitrogen")
                )
        );
        GridPane.setConstraints(nitrogenNode, 14, 1);

        var phosphorusNode = new ElementNode(
                new Element(
                        "Phosphorus",
                        "P",
                        15,
                        getGroupNumber(),
                        3,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Phosphorus")
                )
        );
        GridPane.setConstraints(phosphorusNode, 14, 2);

        var arsenicNode = new ElementNode(
                new Element(
                        "Arsenic",
                        "As",
                        33,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Arsenic")
                )
        );
        GridPane.setConstraints(arsenicNode, 14, 3);

        var antimonyNode = new ElementNode(
                new Element(
                        "Antimony",
                        "Sb",
                        51,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Antimony")
                )
        );
        GridPane.setConstraints(antimonyNode, 14, 4);

        var bismuthNode = new ElementNode(
                new Element(
                        "Bismuth",
                        "Bi",
                        83,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Bismuth")
                )
        );
        GridPane.setConstraints(bismuthNode, 14, 5);

        var moscoviumNode = new ElementNode(
                new Element(
                        "Moscovium",
                        "Mc",
                        114,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Moscovium")
                )
        );
        GridPane.setConstraints(moscoviumNode, 14, 6);

        gridPane.getChildren().addAll(
                nitrogenNode,
                phosphorusNode,
                arsenicNode,
                antimonyNode,
                bismuthNode,
                moscoviumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 15;
    }
}
