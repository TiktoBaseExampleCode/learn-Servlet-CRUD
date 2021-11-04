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
	/**
	 * 
	 */
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
	
	protected void doPatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String index = request.getParameter("index");
		
		Follower inp = new Follower();
		inp.setId(request.getParameter("id"));
		inp.setRealname(request.getParameter("name"));
		
		if(listing.contains(inp)){
			listing.set(Integer.parseInt(index), inp);	
		} else {
			listing.add(inp);
		}
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
