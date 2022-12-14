package ir.shahriari.periodictable.utils;

import java.util.Objects;

public enum Theme {

    LIGHT("light", Objects.requireNonNull(Theme.class.getResource("/ir/shahriari/periodictable/themes/light-theme.css")).toExternalForm()),
    DARK("dark", Objects.requireNonNull(Theme.class.getResource("/ir/shahriari/periodictable/themes/dark-theme.css")).toExternalForm());

    private final String name, path;

    Theme(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public final String getName() {
        return name;
    }

    public final String getPath() {
        return path;
    }
}
