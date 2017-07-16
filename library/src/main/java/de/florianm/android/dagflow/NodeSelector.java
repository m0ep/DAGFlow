package de.florianm.android.dagflow;

import android.os.Bundle;
import android.support.annotation.NonNull;

public abstract class NodeSelector {
    public static NodeSelector ALWAYS = new NodeSelector() {
        @Override
        public boolean select(Bundle data) {
            return true;
        }
    };

    /**
     * Create a negation of a existing {@link NodeSelector}
     *
     * @param nodeSelector The selector to negate.
     * @return A new {@link NodeSelector} that negates the passed {@link NodeSelector}.
     */
    public static NodeSelector not(@NonNull final NodeSelector nodeSelector) {
        return new NodeSelector() {
            @Override
            public boolean select(Bundle data) {
                return !nodeSelector.select(data);
            }
        };
    }

    /**
     *
     *
     * @param data
     * @return
     */
    public abstract boolean select(Bundle data);
}
