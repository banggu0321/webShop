package com.kosta.filterListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class MyListener2
 *
 */
@WebListener
public class MyListener2 implements HttpSessionAttributeListener {

    public MyListener2() {
        System.out.println("MyListener2 implements HttpSessionAttributeListener...»ý¼º");
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	System.out.println("MyListener2 implements HttpSessionAttributeListener...Added");
       }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("MyListener2 implements HttpSessionAttributeListener...Removed");
       }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	System.out.println("MyListener2 implements HttpSessionAttributeListener...Replaced");
    }
	
}
