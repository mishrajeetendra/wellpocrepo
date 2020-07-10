package com.ltts.wellspoc.ui.view;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.DefaultNatTableStyleConfiguration;
import org.eclipse.nebula.widgets.nattable.data.IColumnAccessor;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.data.ListDataProvider;
import org.eclipse.nebula.widgets.nattable.data.ReflectiveColumnPropertyAccessor;
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultColumnHeaderDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultCornerDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultRowHeaderDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.layer.CornerLayer;
import org.eclipse.nebula.widgets.nattable.grid.layer.GridLayer;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.ltts.wellspoc.ui.model.WellInformation;

public class WellsInformationView extends ViewPart {

	public static final String ID = "com.ltts.wellspoc.wellinformationview";

	public static BodyLayerStack bodyLayer;
	private static NatTable natTable;
	private static List<WellInformation> selectedWell = new ArrayList<WellInformation>();
	private List<WellInformation> listOfSelectedWells = new ArrayList<WellInformation>();
	IDataProvider bodyDataProvider = null;

	public WellsInformationView() {
		listOfSelectedWells = getWellInformationList();
	}

	@Override
	public void createPartControl(Composite parent) {

		GridData gridData = new GridData();
		gridData.heightHint = (int) 24;
		gridData.widthHint = (int) 110;

		Map<String, String> columnHeaderName = new LinkedHashMap<String, String>();
		columnHeaderName.put("wellName", "Well Name");
		columnHeaderName.put("easting", "Easting");
		columnHeaderName.put("northing", "Northing");
		columnHeaderName.put("azimuth", "Azimuth");
		columnHeaderName.put("field", "Field");
		columnHeaderName.put("reservoir", "Reservoir");
		columnHeaderName.put("type", "Type");

		IColumnAccessor<WellInformation> columnPropertyAccessor = new ReflectiveColumnPropertyAccessor<WellInformation>(
				columnHeaderName.keySet().toArray(new String[columnHeaderName.size()]));

		bodyDataProvider = new ListDataProvider<WellInformation>(listOfSelectedWells, columnPropertyAccessor);
		bodyLayer = new BodyLayerStack(bodyDataProvider);

		// Column Data Provider
		DefaultColumnHeaderDataProvider columnData = new DefaultColumnHeaderDataProvider(
				columnHeaderName.values().toArray(new String[columnHeaderName.size()]));
		ColumnHeaderLayerStack columnlayer = new ColumnHeaderLayerStack(columnData);

		// Row Data Provider
		DefaultRowHeaderDataProvider rowdata = new DefaultRowHeaderDataProvider(bodyDataProvider);
		RowHeaderLayerStack rowlayer = new RowHeaderLayerStack(rowdata);

		// Corner Data Provider
		DefaultCornerDataProvider cornerdata = new DefaultCornerDataProvider(columnData, rowdata);
		DataLayer cornerDataLayer = new DataLayer(cornerdata);
		CornerLayer cornerLayer = new CornerLayer(cornerDataLayer, rowlayer, columnlayer);

		GridLayer gridlayer = new GridLayer(bodyLayer, columnlayer, rowlayer, cornerLayer);
		natTable = new NatTable(parent, gridlayer, false);

		natTable.addConfiguration(new DefaultNatTableStyleConfiguration());

		natTable.setLayoutData(gridData);
		natTable.configure();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	public static List<WellInformation> getWellInformationList() {
		// TODO Auto-generated method stub
		return selectedWell;
	}

	public static void getUpdatedWellsTable(List<WellInformation> listOfSelectedWells) {
		// TODO Auto-generated method stub
		selectedWell.clear();
		selectedWell.addAll(listOfSelectedWells);
	}

	public void setWellData(List<WellInformation> listOfSelectedWells) {
		// TODO Auto-generated method stub
		getUpdatedWellsTable(listOfSelectedWells);
		natTable.refresh();
	}

}
