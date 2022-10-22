package com.announcement;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteAnnouncementServlet")
public class DeleteAnnouncementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String adid = request.getParameter("adid");
		boolean isTrue;
		
		isTrue = AnnouncementDBUtil.deleteannouncement(adid);
		
		if(isTrue == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("announcementaccount.jsp");
			dispatcher.forward(request, response);
		}
		else {
			List<Announcement> anuDetails = AnnouncementDBUtil.getAnnouncementDetails(adid);
			request.setAttribute("anuDetails", anuDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("announcementinsert.jsp");
			dispatcher.forward(request, response);
		}
	}

}
