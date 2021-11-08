package tikto.utama;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;

import tikto.utama.ejb.Follower;
import tikto.utama.servlet.FollowerImpl;

@WebServlet("/listing")
public class mainApp extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Follower> listing = new ArrayList<Follower>();

	private Gson gson = new Gson();
	private FollowerImpl followerImpl;
	
	public mainApp() {
		super();
		followerImpl = new FollowerImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String index = request.getParameter("index");
		if(index == null) {	
			List<Follower> listing= followerImpl.listOfFollower();
			String listingCpy = this.gson.toJson(listing);
			
			JSONObject obj = new JSONObject(listingCpy);
			String xml_data = XML.toString(obj);			
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/xml");
			response.setCharacterEncoding("UTF-8");
			out.print(xml_data);
			out.flush();
		}else{
			Integer findIndex = Integer.parseInt(index);
			Follower selectFollower = followerImpl.viewDetailFollower(findIndex);
			String detailFollower = this.gson.toJson(selectFollower);
			
			JSONObject obj = new JSONObject(detailFollower);
			String xml_data = XML.toString(obj);
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/xml");
			response.setCharacterEncoding("UTF-8");
			out.print(xml_data);
			out.flush();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Integer id = Integer.parseInt(request.getParameter("id"));
		String realName = request.getParameter("name");	
		Follower inp = new Follower();
		inp.setId(id);
		inp.setRealname(realName);
		followerImpl.addFollower(inp);
	}	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Integer newId = Integer.parseInt(request.getParameter("id"));
		String newRealName = request.getParameter("name");
		
		Follower inp = new Follower();
		
		inp.setId(newId);
		inp.setRealname(newRealName);
		followerImpl.updatFollower(inp);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String index = request.getParameter("index");
		Integer numIndex = Integer.parseInt(index);
		followerImpl.deleteFollower(numIndex);
	}
}
