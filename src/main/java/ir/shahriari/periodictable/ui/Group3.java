package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group3 implements Group {

    public Group3(GridPane gridPane) {
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
        GridPane.setConstraints(scandiumNode, 2, 3);

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
        GridPane.setConstraints(yttriumNode, 2, 4);

        gridPane.getChildren().addAll(
                scandiumNode,
                yttriumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 3;
    }
}
