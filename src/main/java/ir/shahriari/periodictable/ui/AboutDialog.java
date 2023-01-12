package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.Main;
import ir.shahriari.periodictable.utils.ThemeManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.Objects;

public class AboutDialog extends Stage {

    public AboutDialog() {
        setTitle("About");
        var scene = new Scene(createContent(), 600, 400);
        setScene(scene);
    }

    private Parent createContent() {
        var logo = new ImageView(Objects.requireNonNull(getClass().getResource("/ir/shahriari/periodictable/icons/logo.png")).toExternalForm());
        var header = new HBox(logo);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(8));

        var text1 = new Text(
                "\"Periodic Table\" is a simple periodic table program for chemistry lovers by 9th grade students of Shahriari High School.\n"
        );
        var text2 = new Text("This program is based on");
        var link1 = new Hyperlink("Periodic-Table-JSON");
        link1.setOnAction(actionEvent -> Main.getInstance().getHostServices().showDocument("https://github.com/Bowserinator/Periodic-Table-JSON"));
        var text3 = new Text("and written in Java and Javafx.\n");
        var text4 = new Text("You can also contribute to this project on");
        var link2 = new Hyperlink("Github");
        link2.setOnAction(actionEvent -> Main.getInstance().getHostServices().showDocument("https://github.com/AmirAli-AZ/PeriodicTable"));

        var textFlow = new TextFlow(text1, text2, link1, text3, text4, link2);
        textFlow.setPadding(new Insets(8));

        var root = new VBox(3, header, textFlow);
        root.setId("root");

        return root;
    }
}
