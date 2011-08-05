package org.cytoscape.view.presentation.property;

import java.util.HashSet;
import java.util.Set;

import org.cytoscape.view.model.AbstractVisualProperty;
import org.cytoscape.view.model.DiscreteRange;
import org.cytoscape.view.model.NullDataType;
import org.cytoscape.view.model.Range;

/**
 * Visual Property for root. This will not be used in actual visualization. Just
 * a marker node in the tree.
 * 
 */
public class NullVisualProperty extends AbstractVisualProperty<NullDataType> {

	private static final NullDataType dummyObject = new NullDataTypeImpl();
	private static final Range<NullDataType> NULL_RANGE;

	static {
		final Set<NullDataType> nRange = new HashSet<NullDataType>();
		NULL_RANGE = new DiscreteRange<NullDataType>(
				NullDataType.class, nRange);
	}

	public NullVisualProperty(final String id, final String name) {
		super(dummyObject, NULL_RANGE, id, name, Object.class);
	}

	public String toSerializableString(final NullDataType value) {
		return value.toString();
	}

	public NullDataType parseSerializableString(final String text) {
		return dummyObject;
	}
	
	private final static class NullDataTypeImpl implements NullDataType {
		// Dummy class.  Currently this does nothing.
	}
}