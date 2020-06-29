package com.ltts.helloworld;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public static final String PERSPECTIVE_ID = "com.ltts.helloworld.perspective";

	@Override
	public void createInitialLayout(IPageLayout layout) {
	}
}
