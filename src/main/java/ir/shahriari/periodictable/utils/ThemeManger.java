package ir.shahriari.periodictable.utils;

import javafx.scene.Scene;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public final class ThemeManger {


    public static void setTheme(Scene scene, Theme theme) {
        var stylesheets = scene.getStylesheets();

        if (stylesheets.isEmpty())
            stylesheets.add(theme.getPath());
        else
            stylesheets.set(0, theme.getPath());

        try {
            save(theme);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Theme load() {
        var path = Paths.get(Environment.getAppData() + File.separator + "theme-config.properties");
        if (Files.notExists(path))
            return Theme.LIGHT;

        try {
            var properties = new Properties();
            var fis = new FileInputStream(path.toFile());
            properties.load(fis);
            fis.close();

            return Theme.findByName(properties.getProperty("theme"));
        }catch (IOException e) {
            e.printStackTrace();
        }

        return Theme.LIGHT;
    }

    private static void save(Theme theme) throws IOException {
        var properties = new Properties();
        properties.setProperty("theme", theme.getName());
        var fos = new FileOutputStream(Environment.getAppData() + File.separator + "theme-config.properties");
        properties.store(fos, "DO NOT EDIT");
        fos.close();
    }
}
