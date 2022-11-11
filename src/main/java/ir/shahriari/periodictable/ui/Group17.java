package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group17 implements Group {

    public Group17(GridPane gridPane) {
        var fluorineNode = new ElementNode(
                new Element(
                        "Fluorine",
                        "F",
                        9,
                        getGroupNumber(),
                        2,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Fluorine")
                )
        );
        GridPane.setConstraints(fluorineNode, 16, 1);

        var chlorineNode = new ElementNode(
                new Element(
                        "Chlorine",
                        "Cl",
                        17,
                        getGroupNumber(),
                        3,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Chlorine")
                )
        );
        GridPane.setConstraints(chlorineNode, 16, 2);

        var bromineNode = new ElementNode(
                new Element(
                        "Bromine",
                        "Br",
                        35,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Bromine")
                )
        );
        GridPane.setConstraints(bromineNode, 16, 3);

        var iodineNode = new ElementNode(
                new Element(
                        "Iodine",
                        "Te",
                        53,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Iodine")
                )
        );
        GridPane.setConstraints(iodineNode, 16, 4);

        var astatineNode = new ElementNode(
                new Element(
                        "Astatine",
                        "At",
                        85,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Astatine")
                )
        );
        GridPane.setConstraints(astatineNode, 16, 5);

        var tennessineNode = new ElementNode(
                new Element(
                        "Tennessine",
                        "Ts",
                        116,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Tennessine")
                )
        );
        GridPane.setConstraints(tennessineNode, 16, 6);

        gridPane.getChildren().addAll(
                fluorineNode,
                chlorineNode,
                bromineNode,
                iodineNode,
                astatineNode,
                tennessineNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 17;
    }
}
