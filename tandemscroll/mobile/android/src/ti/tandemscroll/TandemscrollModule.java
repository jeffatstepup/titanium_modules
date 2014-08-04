package ti.tandemscroll;

import java.util.ArrayList;
import java.util.List;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.kroll.common.Log;

import ti.modules.titanium.ui.ScrollViewProxy;
import ti.modules.titanium.ui.widget.TiUIScrollView;
import android.view.View;
/**
 * This module is used to ensure the scroll views will move in tandem on Android, with no perceptible delay.
 */

@Kroll.module(name="Tandemscroll", id="ti.tandemscroll")
public class TandemscrollModule extends KrollModule
{

	// Standard Debugging variables
	private static final String TAG = "TandemscrollModule";
	private TandemListener _controllingScroll; 
	private List<TandemListener> _listeners; 
	//private List<View> _listeners; 
	
	// You can define constants with @Kroll.constant, for example:
	// @Kroll.constant public static final String EXTERNAL_NAME = value;
	
	public TandemscrollModule()
	{
		super();
		_listeners = new ArrayList<TandemListener>();
		//_listeners = new ArrayList<View>();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		Log.d(TAG, "inside onAppCreate");
		// put module init code that needs to run when the application is created
	}
	
	

	// Methods
	@Kroll.method
	public void lockTogether(TiViewProxy[] views)
	{
		View syncView = null; 
		
		Log.d(TAG, "locking " + views.length);
		for(int i =0; i < views.length; i++){
			//get down the native view
			TiViewProxy proxy = views[i];
			if(proxy instanceof TandemScrollProxy)
			{
				TandemScrollProxy scroll = (TandemScrollProxy)proxy;
				TandemScrollView scrollview = scroll.getTandemScrollView();
				View view = scrollview.getNativeView();
				if(view instanceof TandemListener){
					//the last view is always the controlling scroll view
					if(i == views.length -1){
						this._controllingScroll = (TandemListener)view;
					}
					else{
						this._listeners.add((TandemListener)view);
					}
				}
			}
			else{
				//add the normal view 
			//	this._listeners.add(proxy.getOrCreateView().getNativeView());
			}
		}	
		//Register listeners
		for(int i = 0; i < _listeners.size(); i++){
			_controllingScroll.registerTandemListener(_listeners.get(i));
		}
		
	}
	
	

}

