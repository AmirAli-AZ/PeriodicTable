package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group18 implements Group {

    public Group18(GridPane gridPane) {
        var heliumNode = new ElementNode(
                new Element(
                        "Helium",
                        "He",
                        2,
                        getGroupNumber(),
                        1,
                        Color.valueOf("#D32143"),
                        URI.create("https://en.wikipedia.org/wiki/Helium")
                )
        );
        GridPane.setConstraints(heliumNode, 17, 0);

        var neonNode = new ElementNode(
                new Element(
                        "Neon",
                        "Ne",
                        10,
                        getGroupNumber(),
                        2,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Neon")
                )
        );
        GridPane.setConstraints(neonNode, 17, 1);

        var argonNode = new ElementNode(
                new Element(
                        "Argon",
                        "Ar",
                        18,
                        getGroupNumber(),
                        3,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Argon")
                )
        );
        GridPane.setConstraints(argonNode, 17, 2);

        var kryptonNode = new ElementNode(
                new Element(
                        "Krypton",
                        "Kr",
                        36,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Krypton")
                )
        );
        GridPane.setConstraints(kryptonNode, 17, 3);

        var xenonNode = new ElementNode(
                new Element(
                        "Xenon",
                        "Xe",
                        54,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Xenon")
                )
        );
        GridPane.setConstraints(xenonNode, 17, 4);

        var radonNode = new ElementNode(
                new Element(
                        "Radon",
                        "Rn",
                        86,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Radon")
                )
        );
        GridPane.setConstraints(radonNode, 17, 5);

        var oganessonNode = new ElementNode(
                new Element(
                        "Oganesson",
                        "Og",
                        118,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Oganesson")
                )
        );
        GridPane.setConstraints(oganessonNode, 17, 6);

        gridPane.getChildren().addAll(
                heliumNode,
                neonNode,
                argonNode,
                kryptonNode,
                xenonNode,
                radonNode,
                oganessonNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 18;
    }
}
