package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group2 extends VBox implements Group {

    public Group2() {
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

        setSpacing(.5);
        getChildren().addAll(
                ElementNode.createEmptyNode(),
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
