package com.ltts.wellspoc.ui.wizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;

import com.ltts.wellspoc.ui.constant.Constant;
import com.ltts.wellspoc.ui.model.WellInformation;
import com.ltts.wellspoc.ui.view.WellsInformationView;

public class WellSelectionWizard extends Wizard {

	protected UserSignIn userSignIn;
	protected WellSelection wellSelection;

	private List<WellInformation> wellData = WellSelection.listOfWells;
	List<WellInformation> selectedWells = new ArrayList<WellInformation>();

	public WellSelectionWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public String getWindowTitle() {
		return "Well Selection Wizard";
	}

	@Override
	public void addPages() {
		userSignIn = new UserSignIn();
		wellSelection = new WellSelection();
		addPage(userSignIn);
		addPage(wellSelection);
	}

	@Override
	public boolean performFinish() {

		for (int i = 0; i < wellData.size(); i++) {

			if (wellData.get(i).isSelected() == true) {
				selectedWells.add(wellData.get(i));
				wellData.get(i).setSelected(false);
			}
		}

		if (getContainer().getCurrentPage() == wellSelection && selectedWells.isEmpty()) {
			MessageBox box = new MessageBox(getShell(), SWT.ICON_INFORMATION);
			box.setText("Message");
			box.setMessage("Please select atleast one well option.");
			box.open();
			return false;
		} else {
			WellsInformationView informationView = new WellsInformationView();
			informationView.setWellData(selectedWells);
			return true;
		}
	}

	@Override
	public boolean canFinish() {
		// TODO Auto-generated method stub
		if (getContainer().getCurrentPage() == wellSelection) {
			return true;
		}
		return false;
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		// TODO Auto-generated method stub

		String userName = userSignIn.getUserName();
		String password = userSignIn.getPassword();

		if (userName.equals(Constant.USER_NAME) && password.equals(Constant.PASSWORD)) {

			return wellSelection;

		} else if (!userName.equals(Constant.USER_NAME) && !password.equals(Constant.PASSWORD)) {

			MessageBox box = new MessageBox(getShell(), SWT.ICON_ERROR);
			box.setText("Error");
			box.setMessage("Please enter a valid username & password.");
			box.open();

		} else if (!userName.equals(Constant.USER_NAME)) {

			MessageBox box = new MessageBox(getShell(), SWT.ICON_ERROR);
			box.setText("Error");
			box.setMessage("Please enter a valid username.");
			box.open();

		} else if (!password.equals(Constant.PASSWORD)) {

			MessageBox box = new MessageBox(getShell(), SWT.ICON_ERROR);
			box.setText("Error");
			box.setMessage("Please enter a valid password.");
			box.open();

		}

		return null;
	}
}
