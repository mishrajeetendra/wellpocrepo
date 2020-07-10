package com.ltts.wellspoc.ui.wizard;

import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.ltts.wellspoc.ui.model.WellInformation;

public class WellSelection extends WizardPage {

	private Table table;
	public static List<WellInformation> listOfWells = WellInformation.getWellInformationList();
	private Composite composite;

	public WellSelection() {
		// TODO Auto-generated constructor stub
		super("Well Selection Page");
		setTitle("Wells Selection");
		setDescription("Select wells name");
		setControl(table);
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub

		String[] wellList = { "Well 1", "Well 2", "Well 3", "Well 4", "Well 5" };

		composite = new Composite(parent, SWT.NONE);
		FillLayout fillLayout = new FillLayout();

		composite.setLayout(fillLayout);

		table = new Table(composite, SWT.CHECK | SWT.BORDER | SWT.FULL_SELECTION);

		TableColumn wellSellection = new TableColumn(table, SWT.CENTER);
		TableColumn wellName = new TableColumn(table, SWT.LEFT);

		wellSellection.setText("Well Sellection");
		wellName.setText("Wells Name");

		wellSellection.setWidth(250);
		wellName.setWidth(336);

		for (int i = 0; i < wellList.length; i++) {
			TableItem wellItem = new TableItem(table, SWT.NONE);

			wellItem.setText(0, "");
			wellItem.setText(1, wellList[i]);
		}

		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		table.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event e) {
				// TODO Auto-generated method stub

				if (e.detail == SWT.CHECK) {

					TableItem item = (TableItem) e.item;

					for (int i = 0; i < listOfWells.size(); i++) {

						if (listOfWells.get(i).getWellName().equals(item.getText(1))) {
							if (listOfWells.get(i).isSelected()) {
								listOfWells.get(i).setSelected(false);
							} else {
								listOfWells.get(i).setSelected(true);
							}
						}

					}
				}
			}
		});

		setControl(composite);
		setPageComplete(false);

	}

}
