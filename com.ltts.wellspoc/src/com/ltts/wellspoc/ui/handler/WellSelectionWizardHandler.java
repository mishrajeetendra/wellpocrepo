package com.ltts.wellspoc.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import com.ltts.wellspoc.ui.wizard.WellSelectionWizard;

public class WellSelectionWizardHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub

		WizardDialog wizardDialog = new WizardDialog(Display.getDefault().getActiveShell(), new WellSelectionWizard());
		wizardDialog.setShellStyle(SWT.CLOSE | SWT.MIN | SWT.RESIZE);
		wizardDialog.setPageSize(600, 400);
		wizardDialog.open();

		return null;
	}

}
