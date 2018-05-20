
package org.historyresearchenvironment.usergui.parts;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

public class ZestTest extends AbstractHREGuiPart {
	private Graph graph;
	private int layout = 1;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.historyresearchenvironment.usergui.parts.AbstractHREGuiPart#
	 * callBusinessLayer(int)
	 */
	@Override
	protected void callBusinessLayer(int i) {

	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		// Graph will hold all other objects
		graph = new Graph(parent, SWT.NONE);
		// now a few nodes
		final GraphNode node1 = new GraphNode(graph, SWT.NONE, "Jim");
		final GraphNode node2 = new GraphNode(graph, SWT.NONE, "Jack");
		final GraphNode node3 = new GraphNode(graph, SWT.NONE, "Joe");
		final GraphNode node4 = new GraphNode(graph, SWT.NONE, "Bill");
		// Lets have a directed connection
		new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, node1, node2);
		// Lets have a dotted graph connection
		new GraphConnection(graph, ZestStyles.CONNECTIONS_DOT, node2, node3);
		// Standard connection
		new GraphConnection(graph, SWT.NONE, node3, node1);
		// Change line color and line width
		final GraphConnection graphConnection = new GraphConnection(graph, SWT.NONE, node1, node4);
		graphConnection.changeLineColor(parent.getDisplay().getSystemColor(SWT.COLOR_GREEN));
		// Also set a text
		graphConnection.setText("This is a text");
		graphConnection.setHighlightColor(parent.getDisplay().getSystemColor(SWT.COLOR_RED));
		graphConnection.setLineWidth(3);

		graph.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
		// Selection listener on graphConnect or GraphNode is not supported
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=236528
		graph.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				LOGGER.info(e.toString());
			}

		});
	}

	public void setLayoutManager() {
		switch (layout) {
		case 1:
			graph.setLayoutAlgorithm(new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
			layout++;
			break;
		case 2:
			graph.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
			layout = 1;
			break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.historyresearchenvironment.usergui.parts.AbstractHREGuiPart#updateGui()
	 */
	@Override
	protected void updateGui() {

	}
}