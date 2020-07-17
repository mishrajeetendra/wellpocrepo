package com.ltts.wellspoc.ui.model;

import java.util.ArrayList;
import java.util.List;

public class WellInformation {

	private String wellName;
	private String easting;
	private String northing;
	private String azimuth;
	private String field;
	private String reservoir;
	private String type;
	private boolean isSelected;

	public static List<WellInformation> listOfWells = new ArrayList<WellInformation>();

	public WellInformation() 
	{
		super();
	}

	public WellInformation(String wellName, String easting, String northing, String azimuth, String field,
			String reservoir, String type, boolean isSelected) {
		super();
		this.wellName = wellName;
		this.easting = easting;
		this.northing = northing;
		this.azimuth = azimuth;
		this.field = field;
		this.reservoir = reservoir;
		this.type = type;
		this.isSelected = isSelected;
	}

	public String getWellName() {
		return wellName;
	}

	public void setWellName(String wellName) {
		this.wellName = wellName;
	}

	public String getEasting() {
		return easting;
	}

	public void setEasting(String easting) {
		this.easting = easting;
	}

	public String getNorthing() {
		return northing;
	}

	public void setNorthing(String northing) {
		this.northing = northing;
	}

	public String getAzimuth() {
		return azimuth;
	}

	public void setAzimuth(String azimuth) {
		this.azimuth = azimuth;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getReservoir() {
		return reservoir;
	}

	public void setReservoir(String reservoir) {
		this.reservoir = reservoir;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public static List<WellInformation> getWellInformationList() {

		WellInformation well1 = new WellInformation("Well 1", "420107.6", "7244305.1", "240", "Ghawar",
				"Not Fm. 2 HD Top", "Horizontal", false);
		WellInformation well2 = new WellInformation("Well 2", "450107.6", "6244305.1", "340", "Salala",
				"Not Fm. 2 HD Top", "Vertical", false);
		WellInformation well3 = new WellInformation("Well 3", "470107.6", "5244305.1", "440", "Ghawar",
				"Not Fm. 2 HD Top", "Horizontal", false);
		WellInformation well4 = new WellInformation("Well 4", "490107.6", "4244305.1", "540", "Salala",
				"Not Fm. 2 HD Top", "Deviated", false);
		WellInformation well5 = new WellInformation("Well 5", "510107.6", "3244305.1", "640", "Ghawar",
				"Not Fm. 2 HD Top", "Vertical", false);

		listOfWells.add(well1);
		listOfWells.add(well2);
		listOfWells.add(well3);
		listOfWells.add(well4);
		listOfWells.add(well5);

		return listOfWells;
	}

	@Override
	public String toString() {
		return "WellInformation [wellName=" + wellName + ", easting=" + easting + ", northing=" + northing
				+ ", azimuth=" + azimuth + ", field=" + field + ", reservoir=" + reservoir + ", type=" + type
				+ ", isSelected=" + isSelected + "]";
	}
}
