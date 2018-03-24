package main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import net.sf.json.JSONObject;

@ServerEndpoint(value ="/websocket",configurator = HttpSessionConfigurator.class)
public class server{
	HttpSession httpSession;
	
	static int count=0;
	
	@OnOpen
	public void onOpen(Session session,EndpointConfig config){
        count++;
        httpSession=(HttpSession) config.getUserProperties().get("HttpSession");
        data.users.put((String) httpSession.getAttribute("admine"), session);
    }
	
	@OnClose
    public void onClose(){
        count--;
        data.users.put((String) httpSession.getAttribute("admine"), null);
    }
	
	@OnMessage
	public void onMessage(String message, Session session) {
		 try {
			 System.out.println(message);
			 JSONObject ob=JSONObject.fromObject(message);
			 ob.put("fromadmine",httpSession.getAttribute("admine"));
			 String towho=ob.getString("toadmine");
			 Session tosession=data.users.get(towho);
			 if(tosession!=null){
				 tosession.getBasicRemote().sendText(ob.toString());
			 }else{
				 JSONObject obs=new JSONObject();
				 obs.put("message", "the user is not online");
				 obs.put("fromadmine", "server");
				 obs.put("toadmine", httpSession.getAttribute("admine"));
				 session.getBasicRemote().sendText(obs.toString());
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	@OnError
    public void onError(Session session, Throwable error){
        data.users.put((String) httpSession.getAttribute("admine"), null);
        error.printStackTrace();
    }
}
