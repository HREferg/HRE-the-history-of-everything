package net.myerichsen.hremvp.person.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;

/**
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 4. apr. 2019
 *
 */
public class AncestorTreeContentProvider implements ITreeContentProvider {
	private static final Object[] EMPTY_ARRAY = new Object[0];
	private final List<TreePerson> tpList;

	/**
	 * Constructor
	 *
	 * @param tpList
	 */
	public AncestorTreeContentProvider(List<TreePerson> treePersonList) {
		super();
		tpList = treePersonList;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.
	 * Object)
	 */
	@Override
	public Object[] getChildren(Object parentElement) {
		final List<TreePerson> parentList = new ArrayList<>();

		if (parentElement instanceof TreePerson) {
			for (final TreePerson treePerson : tpList) {
				if (treePerson.getPersonPid() == ((TreePerson) parentElement)
						.getChildPid()) {
					parentList.add(treePerson);
				}
			}
		}

		return parentList.toArray();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.
	 * Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof List) {
			return ((List<TreePerson>) inputElement).toArray();
		} else {
			return EMPTY_ARRAY;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.
	 * Object)
	 */
	@Override
	public Object getParent(Object element) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.
	 * Object)
	 */
	@Override
	public boolean hasChildren(Object element) {
		return ((element instanceof TreePerson)
				&& !((TreePerson) element).getAncestorList().isEmpty());
	}
}