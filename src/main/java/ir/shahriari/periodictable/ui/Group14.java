package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.model.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URI;

public class Group14 implements Group {

    public Group14(GridPane gridPane) {
        var carbonNode = new ElementNode(
                new Element(
                        "Carbon",
                        "C",
                        6,
                        getGroupNumber(),
                        2,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Carbon")
                )
        );
        GridPane.setConstraints(carbonNode, 13, 1);

        var siliconNode = new ElementNode(
                new Element(
                        "Silicon",
                        "Si",
                        14,
                        getGroupNumber(),
                        3,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Silicon")
                )
        );
        GridPane.setConstraints(siliconNode, 13, 2);

        var germaniumNode = new ElementNode(
                new Element(
                        "Germanium",
                        "Ge",
                        32,
                        getGroupNumber(),
                        4,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Germanium")
                )
        );
        GridPane.setConstraints(germaniumNode, 13, 3);

        var tinNode = new ElementNode(
                new Element(
                        "Tin",
                        "Sn",
                        50,
                        getGroupNumber(),
                        5,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Tin")
                )
        );
        GridPane.setConstraints(tinNode, 13, 4);

        var leadNode = new ElementNode(
                new Element(
                        "Lead",
                        "Pb",
                        82,
                        getGroupNumber(),
                        6,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Lead")
                )
        );
        GridPane.setConstraints(leadNode, 13, 5);

        var fleroviumNode = new ElementNode(
                new Element(
                        "Flerovium",
                        "Fl",
                        114,
                        getGroupNumber(),
                        7,
                        Color.valueOf("#2196F3"),
                        URI.create("https://en.wikipedia.org/wiki/Flerovium")
                )
        );
        GridPane.setConstraints(fleroviumNode, 13, 6);

        gridPane.getChildren().addAll(
                carbonNode,
                siliconNode,
                germaniumNode,
                tinNode,
                leadNode,
                fleroviumNode
        );
    }

    @Override
    public int getGroupNumber() {
        return 14;
    }
}
