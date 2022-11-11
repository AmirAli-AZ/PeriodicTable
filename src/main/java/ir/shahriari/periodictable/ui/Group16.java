package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group16 implements Group {

    public Group16(GridPane gridPane) {
        var oxygenNode = new ElementNode(
                new Element(
                        "Oxygen",
                        "O",
                        8,
                        getGroupNumber(),
                        2,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Oxygen")
                )
        );
        GridPane.setConstraints(oxygenNode, 15, 1);

        var sulfurNode = new ElementNode(
                new Element(
                        "Sulfur",
                        "S",
                        16,
                        getGroupNumber(),
                        3,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Sulfur")
                )
        );
        GridPane.setConstraints(sulfurNode, 15, 2);

        var seleniumNode = new ElementNode(
                new Element(
                        "Selenium",
                        "Se",
                        34,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Selenium")
                )
        );
        GridPane.setConstraints(seleniumNode, 15, 3);

        var telluriumNode = new ElementNode(
                new Element(
                        "Tellurium",
                        "Te",
                        52,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Tellurnium")
                )
        );
        GridPane.setConstraints(telluriumNode, 15, 4);

        var poloniumNode = new ElementNode(
                new Element(
                        "Polonium",
                        "Po",
                        84,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Polonium")
                )
        );
        GridPane.setConstraints(poloniumNode, 15, 5);

        var livermoriumNode = new ElementNode(
                new Element(
                        "Livermorium",
                        "Lv",
                        116,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Livermornium")
                )
        );
        GridPane.setConstraints(livermoriumNode, 15, 6);

        gridPane.getChildren().addAll(
                oxygenNode,
                sulfurNode,
                seleniumNode,
                telluriumNode,
                poloniumNode,
                livermoriumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 16;
    }
}
