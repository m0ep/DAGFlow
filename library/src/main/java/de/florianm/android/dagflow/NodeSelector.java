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
    public static NodeSelector NEVER = new NodeSelector() {
        @Override
        public boolean select(Bundle data) {
            return false;
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
     * Connect multiple {@link NodeSelector}s with an AND operation.
     *
     * @param nodeSelectors The variable array of child selectors.
     * @return Returns true if all child selectors are true.
     */
    public static NodeSelector and(final NodeSelector... nodeSelectors) {
        if (0 == nodeSelectors.length) {
            return NEVER;
        }

        return new NodeSelector() {
            @Override
            public boolean select(Bundle data) {
                for (NodeSelector nodeSelector : nodeSelectors) {
                    if (!nodeSelector.select(data)) {
                        return false;
                    }
                }

                return true;
            }
        };
    }

    /**
     * Connect multiple {@link NodeSelector}s with an OR operation.
     *
     * @param nodeSelectors The variable array of child selectors.
     * @return Returns true if at least one child selector are true.
     */
    public static NodeSelector or(final NodeSelector... nodeSelectors) {
        if (0 == nodeSelectors.length) {
            return NEVER;
        }

        return new NodeSelector() {
            @Override
            public boolean select(Bundle data) {
                for (NodeSelector nodeSelector : nodeSelectors) {
                    if (nodeSelector.select(data)) {
                        return true;
                    }
                }

                return false;
            }
        };
    }

    /**
     * Implementation should return if a node should be selected or not.
     *
     * @param data The current data of the DAGFlow
     * @return Returns if the node should be selected or not.
     */
    public abstract boolean select(Bundle data);
}
