package ti.tandemscroll;


import java.util.Vector;
/**
 * Controller to allow the controlling scroll view to  dispatch events to other scroll views that 
 * have been registered as listeners.  
 */
public class TandemController
{
	private Vector<TandemListener> mListeners = new Vector<TandemListener>();
	
	private boolean mInDispatch = false;
	
	public boolean registerTandemListener(TandemListener listener)
	{
		return mListeners.add(listener);
	}
	
	public boolean unregisterTandemListener(TandemListener listener)
	{
		return mListeners.remove(listener);
	}
	
	
	public boolean isInDispatch()
	{
		return mInDispatch;
	}
	
	public void dispatchTandemScroll(int x, int y, int diff)
	{
		mInDispatch = true;
		for(TandemListener view : mListeners){
			view.tandemScroll(x, y * 2);
		}
	    mInDispatch = false;
	}
}


interface TandemListener
{
	public boolean registerTandemListener(TandemListener listener);
	public boolean unregisterTandemListener(TandemListener listener);
	public void tandemScroll(int x, int y);
}
