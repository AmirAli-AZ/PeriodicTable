package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group8 implements Group {

    public Group8(GridPane gridPane) {
        var ironNode = new ElementNode(
                new Element(
                        "Iron",
                        "Fe",
                        26,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Iron")
                )
        );
        GridPane.setConstraints(ironNode, 7, 3);

        var rutheniumNode = new ElementNode(
                new Element(
                        "Ruthenium",
                        "Ru",
                        44,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Ruthenium")
                )
        );
        GridPane.setConstraints(rutheniumNode, 7, 4);

        var osmiumNode = new ElementNode(
                new Element(
                        "Osmium",
                        "Os",
                        76,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Osmium")
                )
        );
        GridPane.setConstraints(osmiumNode, 7, 5);

        var hassiumNode = new ElementNode(
                new Element(
                        "Hassium",
                        "Hs",
                        108,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Hassium")
                )
        );
        GridPane.setConstraints(hassiumNode, 7, 6);

        gridPane.getChildren().addAll(
                ironNode,
                rutheniumNode,
                osmiumNode,
                hassiumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 8;
    }
}
