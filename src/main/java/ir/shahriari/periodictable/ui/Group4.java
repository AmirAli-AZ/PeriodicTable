package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group4 extends VBox implements Group {

    public Group4() {
        var titaniumNode = new ElementNode(
                new Element(
                        "Titanium",
                        "Ti",
                        22,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Titanium")
                )
        );

        var zirconiumNode = new ElementNode(
                new Element(
                        "Zirconium",
                        "Zr",
                        40,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Zirconium")
                )
        );

        var hafniumNode = new ElementNode(
                new Element(
                        "Hafnium",
                        "Hf",
                        72,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Hafnium")
                )
        );

        var rutherfordiumNode = new ElementNode(
                new Element(
                        "Rutherfordium",
                        "Rf",
                        104,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Rutherfordium")
                )
        );

        setSpacing(.5);
        getChildren().addAll(
                ElementNode.createEmptyNode(),
                ElementNode.createEmptyNode(),
                ElementNode.createEmptyNode(),
                titaniumNode,
                zirconiumNode,
                hafniumNode,
                rutherfordiumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 4;
    }
}
