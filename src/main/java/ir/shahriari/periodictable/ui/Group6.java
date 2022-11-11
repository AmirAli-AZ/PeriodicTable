package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group6 implements Group {

    public Group6(GridPane gridPane) {
        var chromiumNode = new ElementNode(
                new Element(
                        "Chromium",
                        "Cr",
                        24,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Chromium")
                )
        );
        GridPane.setConstraints(chromiumNode, 5, 3);

        var molybdenumNode = new ElementNode(
                new Element(
                        "Molybdenum",
                        "Mo",
                        42,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Molybdenum")
                )
        );
        GridPane.setConstraints(molybdenumNode, 5, 4);

        var tungstenNode = new ElementNode(
                new Element(
                        "Tungsten",
                        "W",
                        74,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Tungsten")
                )
        );
        GridPane.setConstraints(tungstenNode, 5, 5);

        var seaborgiumNode = new ElementNode(
                new Element(
                        "Seaborgium",
                        "Sg",
                        106,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Seaborgium")
                )
        );
        GridPane.setConstraints(seaborgiumNode, 5, 6);

        gridPane.getChildren().addAll(
                chromiumNode,
                molybdenumNode,
                tungstenNode,
                seaborgiumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 6;
    }
}
