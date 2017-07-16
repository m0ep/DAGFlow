package de.florianm.android.dagflow;

import android.os.Bundle;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class Node {
    private final PageDescriptor pageDescriptor;
    private final NodeSelector nodeSelector;
    private final LinkedList<Node> outgoingEdges = new LinkedList<>();

    protected Node(PageDescriptor pageDescriptor, NodeSelector nodeSelector) {
        this.pageDescriptor = pageDescriptor;
        this.nodeSelector = nodeSelector;
    }

    public PageDescriptor getPageDescriptor() {
        return pageDescriptor;
    }

    public NodeSelector getNodeSelector() {
        return nodeSelector;
    }

    public List<Node> getOutgoingEdges() {
        return Collections.unmodifiableList(outgoingEdges);
    }

    public void addOutgoingEdge(Node node){
        if(this == node){
            throw new IllegalArgumentException("No self loops allowed");
        }

        outgoingEdges.add(node);
    }

    public boolean shouldSelect(Bundle data){
        return nodeSelector.select(data);
    }
}
