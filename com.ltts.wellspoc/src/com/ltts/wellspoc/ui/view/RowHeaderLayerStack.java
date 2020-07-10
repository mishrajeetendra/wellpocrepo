package com.ltts.wellspoc.ui.view;

import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.layer.RowHeaderLayer;
import org.eclipse.nebula.widgets.nattable.layer.AbstractLayerTransform;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;

public class RowHeaderLayerStack extends AbstractLayerTransform {

	public RowHeaderLayerStack(IDataProvider dataProvider) {
		DataLayer dataLayer = new DataLayer(dataProvider, 50, 20);
		RowHeaderLayer rowHeaderLayer = new RowHeaderLayer(dataLayer, WellsInformationView.bodyLayer,
				WellsInformationView.bodyLayer.getSelectionLayer());
		setUnderlyingLayer(rowHeaderLayer);
	}
}
