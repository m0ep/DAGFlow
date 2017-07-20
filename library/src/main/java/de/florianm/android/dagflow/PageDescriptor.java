package de.florianm.android.dagflow;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class PageDescriptor {
    private final String name;
    private final String tag;
    private final Bundle args;

    public PageDescriptor(@NonNull String name, @NonNull String tag, @Nullable Bundle args) {
        this.name = name;
        this.tag = tag;
        this.args = args;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public Bundle getArgs() {
        return args;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageDescriptor that = (PageDescriptor) o;

        if (!name.equals(that.name)) return false;
        if (!tag.equals(that.tag)) return false;
        return args != null ? args.equals(that.args) : that.args == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + tag.hashCode();
        result = 31 * result + (args != null ? args.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PageDescriptor{" +
                "name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", args=" + args +
                '}';
    }
}
