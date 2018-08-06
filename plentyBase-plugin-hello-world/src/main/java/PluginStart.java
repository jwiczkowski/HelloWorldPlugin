
import event.EventBean;
import interfaces.BaseEventListener;
import interfaces.BasePlugin;
import servlets.HelloWorldServlet;

import javax.servlet.http.HttpServlet;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class PluginStart extends BasePlugin
{

	@Override
	public void startupPlugin()
	{
		System.out.println("Example plugin started");
		JOptionPane.showMessageDialog(null, "Hello world", "Info", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public Map<String, BaseEventListener> getEventListeners()
	{
		BaseEventListener testEventListener = new BaseEventListener(){
			@Override
			public void fireEvent(EventBean eventBean)
			{
				System.out.println("Event fired");
				JOptionPane.showMessageDialog(null, "Hello world", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		Map<String, BaseEventListener> eventListeners = new HashMap<>();
		eventListeners.put("helloworld", testEventListener);
		return eventListeners;
	}

	@Override
	public Map<String, HttpServlet> getServlets()
	{
		Map<String, HttpServlet> servlets = new HashMap<>();
		servlets.put("/helloworld", new HelloWorldServlet());
		return servlets;
	}
}
