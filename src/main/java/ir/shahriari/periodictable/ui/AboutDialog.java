package ir.shahriari.periodictable.ui;

import ir.shahriari.periodictable.Main;
import ir.shahriari.periodictable.utils.Theme;
import ir.shahriari.periodictable.utils.ThemeManger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
        textFlow.setPadding(new Insets(10));

        var logo = new ImageView(Objects.requireNonNull(getClass().getResource("/ir/shahriari/periodictable/icons/logo.png")).toExternalForm());
        var header = new HBox(logo);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(10));

        var root = new VBox(3, header, textFlow);
        root.setId("root");

        setTitle("About");
        var scene = new Scene(root, 600, 400);
        setScene(scene);
        setOnShowing(windowEvent -> {
            var light = Objects.requireNonNull(getClass().getResource("/ir/shahriari/periodictable/themes/light-dialog-theme.css")).toExternalForm();
            var dark = Objects.requireNonNull(getClass().getResource("/ir/shahriari/periodictable/themes/dark-dialog-theme.css")).toExternalForm();
            var stylesheets = scene.getStylesheets();

            if (ThemeManger.load() == Theme.LIGHT) {
                if (stylesheets.isEmpty())
                    stylesheets.add(light);
                else
                    stylesheets.set(0, light);
            }else {
                if (stylesheets.isEmpty())
                    stylesheets.add(dark);
                else
                    stylesheets.set(0, dark);
            }
        });
    }
}
