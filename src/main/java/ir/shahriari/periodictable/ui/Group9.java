package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group9 implements Group {

    public Group9(GridPane gridPane) {
        var cobaltNode = new ElementNode(
                new Element(
                        "Cobalt",
                        "Co",
                        27,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Cobalt")
                )
        );
        GridPane.setConstraints(cobaltNode, 8, 3);

        var rhodiumNode = new ElementNode(
                new Element(
                        "Rhodium",
                        "Rh",
                        45,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Rhodium")
                )
        );
        GridPane.setConstraints(rhodiumNode, 8, 4);

        var iridiumNode = new ElementNode(
                new Element(
                        "Iridium",
                        "Ir",
                        77,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Iridium")
                )
        );
        GridPane.setConstraints(iridiumNode, 8, 5);

        var meitneriumNode = new ElementNode(
                new Element(
                        "Meitnerium",
                        "Mt",
                        109,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Meitnerium")
                )
        );
        GridPane.setConstraints(meitneriumNode, 8, 6);

        gridPane.getChildren().addAll(
                cobaltNode,
                rhodiumNode,
                iridiumNode,
                meitneriumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 9;
    }
}
