package de.florianm.android.dagflow;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Simple implementation of a {@link PageDescriptor}
 */
public class SimplePageDescriptor extends PageDescriptor {

    protected SimplePageDescriptor(@NonNull String fragmentClass, @NonNull String tag, @Nullable String title) {
        super(fragmentClass, tag, title);
    }
}
