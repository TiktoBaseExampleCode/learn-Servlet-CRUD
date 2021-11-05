import java.util.ArrayList;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import tikto.utama.ejb.Follower;

@WebServlet("/listing")
public class mainApp extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Follower> listing = new ArrayList<Follower>();
	private Gson gson = new Gson();
	
	public mainApp() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String listingCpy = this.gson.toJson(listing);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(listingCpy);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id = request.getParameter("id");
		String realName = request.getParameter("name");		
		Follower inp = new Follower();
		inp.setId(id);
		inp.setRealname(realName);
		listing.add(inp);
	}	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String index = request.getParameter("index");
		String newId = request.getParameter("id");
		String newRealName = request.getParameter("name");
		
		Integer targetIndex = Integer.parseInt(index);
		
		Follower inp = new Follower();
		
		inp.setId(newId);
		inp.setRealname(newRealName);
		
		listing.set(targetIndex, inp);
		
//		if(listing.contains(inp)){
//			listing.set(targetIndex, inp);	
//		} else {
//			listing.add(inp);
//		}	
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String index = request.getParameter("index");
		try {
			listing.remove(Integer.parseInt(index));
		}catch(Exception e) {
			
		}
	}
}
