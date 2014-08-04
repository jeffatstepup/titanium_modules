/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package ti.tandemscroll;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.util.Log;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiCompositeLayout;
import org.appcelerator.titanium.view.TiCompositeLayout.LayoutArrangement;
import org.appcelerator.titanium.view.TiUIView;

import ti.modules.titanium.ui.widget.TiUIScrollView;

import android.app.Activity;
import android.view.View;


// This proxy can be created by calling Tandemscroll.createTandemScroll({<scroll view attributes>})
@Kroll.proxy(creatableInModule=TandemscrollModule.class)
public class TandemScrollProxy extends TiViewProxy
{
	// Standard Debugging variables
	private static final String TAG = "TandemScrollProxy";
	
	// Constructor
	public TandemScrollProxy()
	{
		super();
	}

	@Override
	public TiUIView createView(Activity activity)
	{
		TiUIView view = new TandemScrollView(this);
		view.getLayoutParams().autoFillsHeight = true;
		view.getLayoutParams().autoFillsWidth = true;
		return view;
	}
	
     /** 
      * Get access to the TandemScrollView
      * @return TandemScrollView
      */
	 public TandemScrollView getTandemScrollView() {
         return (TandemScrollView) getOrCreateView();
	 } 
	
		
	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict options)
	{
		super.handleCreationDict(options);
	}
	
}