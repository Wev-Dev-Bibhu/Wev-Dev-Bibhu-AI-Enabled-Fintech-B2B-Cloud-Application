package com.crud.DataFetch;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MultipleDelete")
public class MultipleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MultipleDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select[] = request.getParameterValues("sl_no"); 
	    StringBuffer sb = new StringBuffer(); 
	    for(int i = 0; i < select.length; i++) {
	        sb.append(select[i] + ",");
	    }
	    String params = sb.toString(); 
	    params = params.substring(0, params.length()-1);
	    
	   try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/grey_goose", "root", "root");
	        PreparedStatement ps = con.prepareStatement("DELETE FROM winter_internship WHERE sl_no IN("+params +")");
	        
	        ps.executeUpdate();

	} catch (Exception e) {
			e.printStackTrace();
			}
}
}
