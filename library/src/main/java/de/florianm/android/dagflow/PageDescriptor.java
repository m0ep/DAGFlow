package de.florianm.android.dagflow;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public abstract class PageDescriptor {
    private final String className;
    private final String tag;
    private final String title;

    public PageDescriptor(@NonNull String className, @NonNull String tag, @Nullable String title) {
        this.className = className;
        this.tag = tag;
        this.title = title;
    }

    public String getClassName() {
        return className;
    }

    public String getTag() {
        return tag;
    }

    public String getTitle() {
        return title;
    }

    public Fragment newFragment()  {
        try {
            Class<?> clazz = Class.forName(className);
            return (Fragment) clazz.newInstance();
        } catch (Throwable e) {
            throw new RuntimeException("Failed to create an instance of " + className);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageDescriptor that = (PageDescriptor) o;

        if (!className.equals(that.className)) return false;
        if (!tag.equals(that.tag)) return false;
        return title != null ? title.equals(that.title) : that.title == null;

    }

    @Override
    public int hashCode() {
        int result = className.hashCode();
        result = 31 * result + tag.hashCode();
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PageDescriptor{" +
                "className='" + className + '\'' +
                ", tag='" + tag + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
