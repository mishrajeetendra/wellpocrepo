package com.ltts.wellspoc.ui.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class UserSignIn extends WizardPage {

	private static Text userName;
	private static Text password;
	private Composite composite;

	public UserSignIn() {
		// TODO Auto-generated constructor stub
		super("User Page");
		setTitle("User");
		setDescription("User authentication");
	}

	public String getUserName() {
		return userName.getText();
	}

	public String getPassword() {
		return password.getText();
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub

		composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		composite.setLayout(layout);
		layout.numColumns = 2;

		Label userLabel = new Label(composite, SWT.NONE);
		userLabel.setText("User Name :   ");

		userName = new Text(composite, SWT.BORDER | SWT.SINGLE);
		userName.setText("");

		Label passwordLabel = new Label(composite, SWT.NONE);
		passwordLabel.setText("Password :   ");

		password = new Text(composite, SWT.BORDER | SWT.SINGLE | SWT.PASSWORD);
		password.setText("");

		userName.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub

				canFlipToNextPage();
				getWizard().getContainer().updateButtons();
			}
		});

		password.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub

				canFlipToNextPage();
				getWizard().getContainer().updateButtons();
			}
		});

		GridData userNameGridData = new GridData(GridData.FILL_HORIZONTAL);
		userName.setLayoutData(userNameGridData);

		GridData passwordGridData = new GridData(GridData.FILL_HORIZONTAL);
		password.setLayoutData(passwordGridData);

		setControl(composite);
		// setPageComplete(false);
	}

	@Override
	public boolean canFlipToNextPage() {
		// TODO Auto-generated method stub

		if (userName.getText().isEmpty() || password.getText().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "userName: " + getUserName() + "  " + "password: " + getPassword();
	}

}
