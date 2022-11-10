package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group3 extends VBox implements Group {

    public Group3() {
        var scandiumNode = new ElementNode(
                new Element(
                        "Scandium",
                        "Sc",
                        21,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Scandium")
                )
        );

        var yttriumNode = new ElementNode(
                new Element(
                        "Yttrium",
                        "Y",
                        39,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#1ed11b"),
                        URI.create("https://en.wikipedia.org/wiki/Yttrium")
                )
        );

        setSpacing(.5);
        getChildren().addAll(
                ElementNode.createEmptyNode(),
                ElementNode.createEmptyNode(),
                ElementNode.createEmptyNode(),
                scandiumNode,
                yttriumNode,
                ElementNode.createEmptyNode(),
                ElementNode.createEmptyNode()
        );
    }

    @Override
    public int getGroupNumber() {
        return 3;
    }
}
