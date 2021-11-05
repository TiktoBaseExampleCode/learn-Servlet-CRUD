package tikto.utama.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FollowerOperation {
	
	void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
