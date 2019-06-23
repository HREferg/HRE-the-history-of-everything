package net.myerichsen.hremvp.person.parts;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Tree;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.person.providers.AncestorTreeContentProvider;
import net.myerichsen.hremvp.person.providers.AncestorTreeLabelProvider;
import net.myerichsen.hremvp.person.providers.PersonProvider;
import net.myerichsen.hremvp.person.providers.TreePerson;

/**
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 * @version 3. apr. 2019
 *
 */
public class AncestorNavigator {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");
	private PersonProvider provider;
	private Spinner spinnerGenerations;
	private TreeViewer treeViewer;
	private List<TreePerson> treePersonList;

	/**
	 * Constructor
	 *
	 */
	public AncestorNavigator() {
		try {
			provider = new PersonProvider();
			treePersonList = createTreePersonList(1);
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 * Create contents of the view part
	 *
	 * @param parent
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(2, false));

		final Label lblGenerations = new Label(parent, SWT.NONE);
		lblGenerations.setText("Generations");

		spinnerGenerations = new Spinner(parent, SWT.BORDER);
		spinnerGenerations.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				store.setValue("TREEGENERATIONS",
						spinnerGenerations.getSelection());
			}
		});
		spinnerGenerations.setSelection(store.getInt("TREEGENERATIONS"));

		treeViewer = new TreeViewer(parent, SWT.BORDER);
		treeViewer.setContentProvider(
				new AncestorTreeContentProvider(treePersonList));
		treeViewer.setLabelProvider(new AncestorTreeLabelProvider());

		final Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		treeViewer.setInput(treePersonList);
	}

	/**
	 * Create a TreePerson object for each string list for the selected person.
	 * Create a list of all objects. Then insert a list of parents and a list of
	 * children in each person object.
	 *
	 * @return
	 *
	 * @throws Exception
	 * @throws MvpException
	 */
	private List<TreePerson> createTreePersonList(int personPid)
			throws Exception {
		TreePerson person;
		final List<TreePerson> tpList = new ArrayList<>();

		for (final List<String> list : provider.getAncestorList(personPid,
				99999)) {
			tpList.add(
					new TreePerson(list.get(0), 0, list.get(1), list.get(2)));
		}

		for (int i = 0; i < tpList.size(); i++) {
			person = tpList.get(i);

			for (final TreePerson potentielParent : tpList) {
				if (potentielParent.getChildPid() == person.getPersonPid()) {
					person.addParent(potentielParent);
				}
			}

			for (final TreePerson potentialChild : tpList) {
				if (potentialChild.getParentPid() == person.getPersonPid()) {
					person.addChild(potentialChild);
				}
			}

			tpList.set(i, person);
		}
		return tpList;
	}

	/**
	 * @param personPid
	 */
	@Inject
	@Optional
	private void subscribePersonPidUpdateTopic(
			@UIEventTopic(Constants.PERSON_PID_UPDATE_TOPIC) int personPid) {
		LOGGER.log(Level.FINE, "Received person id {0}", personPid);
		try {
			treePersonList = createTreePersonList(personPid);
			treeViewer.setInput(treePersonList);
			treeViewer.refresh();
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}
}
