package de.florianm.android.dagflow;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Simple implementation of a {@link PageDescriptor}
 */
public class SimplePageDescriptor extends PageDescriptor {
    public SimplePageDescriptor(@NonNull String name, @NonNull String tag, @Nullable Bundle args) {
        super(name, tag, args);
    }
}
