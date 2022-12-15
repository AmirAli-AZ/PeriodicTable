package ir.shahriari.periodictable.utils;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

public final class ThemeManager {


    public static void setTheme(Scene scene, Theme theme) {
        var stylesheets = scene.getStylesheets();

        if (stylesheets.isEmpty())
            stylesheets.add(theme.getPath());
        else
            stylesheets.set(0, theme.getPath());
    }

    public static void applyThemeToAllWindows(Theme theme) {
        var windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof Stage stage) {
                var scene = stage.getScene();
                setTheme(scene, theme);
            }
        }
    }

    public static Theme load() {
        var theme = Theme.LIGHT;

        try {
            var themeName = getProperty("theme", "light");
            if (themeName.equalsIgnoreCase("dark"))
                theme = Theme.DARK;
        }catch (IOException e) {
            e.printStackTrace();
        }

        return theme;
    }

    public static void save(Theme theme) throws IOException {
        var properties = new Properties();
        properties.setProperty("theme", theme.getName());
        var fos = new FileOutputStream(getThemeConfigFile().toFile());
        properties.store(fos, "DO NOT EDIT");
        fos.close();
    }


    public static Path getThemeConfigFile() {
        return Paths.get(Environment.getAppData() + File.separator + "theme-config.properties");
    }

    public static boolean isThemeConfigFileExists() {
        return Files.exists(getThemeConfigFile());
    }

    public static String getProperty(String key) throws IOException {
        Objects.requireNonNull(key);

        if (!isThemeConfigFileExists())
            return null;

        var properties = new Properties();
        var fis = new FileInputStream(getThemeConfigFile().toFile());
        properties.load(fis);
        fis.close();

        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) throws IOException {
        var value = getProperty(key);
        return value == null ? defaultValue : value;
    }
}
