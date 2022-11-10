package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group2 implements Group {

    public Group2(GridPane gridPane) {
        var berylliumNode = new ElementNode(
                new Element(
                        "Beryllium",
                        "Be",
                        4,
                        getGroupNumber(),
                        2,
                        Color.valueOf("#D32143"),
                        URI.create("https://en.wikipedia.org/wiki/Beryllium")
                )
        );
        GridPane.setConstraints(berylliumNode, 1, 1);

        var magnesiumNode = new ElementNode(
                new Element(
                        "Magnesium",
                        "Mg",
                        12,
                        getGroupNumber(),
                        3,
                        Color.valueOf("#D32143"),
                        URI.create("https://en.wikipedia.org/wiki/Magnesium")
                )
        );
        GridPane.setConstraints(magnesiumNode, 1, 2);

        var calciumNode = new ElementNode(
                new Element(
                        "Calcium",
                        "Ca",
                        20,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#D32143"),
                        URI.create("https://en.wikipedia.org/wiki/Calcium")
                )
        );
        GridPane.setConstraints(calciumNode, 1, 3);

        var strontiumNode = new ElementNode(
                new Element(
                        "Strontium",
                        "Sr",
                        38,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#D32143"),
                        URI.create("https://en.wikipedia.org/wiki/Strontium")
                )
        );
        GridPane.setConstraints(strontiumNode, 1, 4);

        var bariumNode = new ElementNode(
                new Element(
                        "Barium",
                        "Ba",
                        56,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#D32143"),
                        URI.create("https://en.wikipedia.org/wiki/Barium")
                )
        );
        GridPane.setConstraints(bariumNode, 1, 5);

        var radiumNode = new ElementNode(
                new Element(
                        "Radium",
                        "Ra",
                        88,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#D32143"),
                        URI.create("https://en.wikipedia.org/wiki/Radium")
                )
        );
        GridPane.setConstraints(radiumNode, 1, 6);

        gridPane.getChildren().addAll(
                berylliumNode,
                magnesiumNode,
                calciumNode,
                strontiumNode,
                bariumNode,
                radiumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 2;
    }
}
