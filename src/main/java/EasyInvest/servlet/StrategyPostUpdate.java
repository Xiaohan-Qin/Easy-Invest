package EasyInvest.servlet;

import EasyInvest.dal.*;
import EasyInvest.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/strategypostupdate")
public class StrategyPostUpdate extends HttpServlet {
	
	protected StrategyPostDao strategyPostDao;
//	
//	@Override
//	public void init() throws ServletException {
//		strategyPostDao = strategyPostDao.getInstance();
//	}
//	
//	@Override
//	public void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		// Map for storing messages.
//        Map<String, String> messages = new HashMap<String, String>();
//        req.setAttribute("messages", messages);
//
//        // Retrieve user and validate.
//        String userName = req.getParameter("username");
//        if (userName == null || userName.trim().isEmpty()) {
//            messages.put("success", "Please enter a valid UserName.");
//        } else {
//        	try {
//        		BlogUsers blogUser = strategyPostDao.getBlogUserFromUserName(userName);
//        		if(blogUser == null) {
//        			messages.put("success", "UserName does not exist.");
//        		}
//        		req.setAttribute("blogUser", blogUser);
//        	} catch (SQLException e) {
//				e.printStackTrace();
//				throw new IOException(e);
//	        }
//        }
//        
//        req.getRequestDispatcher("/UserUpdate.jsp").forward(req, resp);
//	}
//	
//	@Override
//    public void doPost(HttpServletRequest req, HttpServletResponse resp)
//    		throws ServletException, IOException {
//        // Map for storing messages.
//        Map<String, String> messages = new HashMap<String, String>();
//        req.setAttribute("messages", messages);
//
//        // Retrieve user and validate.
//        String userName = req.getParameter("username");
//        if (userName == null || userName.trim().isEmpty()) {
//            messages.put("success", "Please enter a valid UserName.");
//        } else {
//        	try {
//        		StrategyPost strategyPost = strategyPostDao.getBlogUserFromUserName(userName);
//        		if(blogUser == null) {
//        			messages.put("success", "UserName does not exist. No update to perform.");
//        		} else {
//        			String newLastName = req.getParameter("lastname");
//        			if (newLastName == null || newLastName.trim().isEmpty()) {
//        	            messages.put("success", "Please enter a valid LastName.");
//        	        } else {
//        	        	blogUser = strategyPostDao.updateLastName(blogUser, newLastName);
//        	        	messages.put("success", "Successfully updated " + userName);
//        	        }
//        		}
//        		req.setAttribute("blogUser", blogUser);
//        	} catch (SQLException e) {
//				e.printStackTrace();
//				throw new IOException(e);
//	        }
//        }
//        
//        req.getRequestDispatcher("/StrategyPostUpdate.jsp").forward(req, resp);
//    }
}
