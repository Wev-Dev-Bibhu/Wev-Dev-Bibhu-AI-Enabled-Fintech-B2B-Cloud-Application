package com.crud.DataFetch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class UpdatePredictedData
 */
@WebServlet("/UpdatePredictedData")
public class UpdatePredictedData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePredictedData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String aging_bucket = request.getParameter("aging_bucket");
		String sl_no = request.getParameter("sl_no");
		System.out.println(aging_bucket + "  " + sl_no);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/grey_goose","root","root");
			PreparedStatement ps = con.prepareStatement("update winter_internship set aging_bucket = ? where sl_no = ? ;");
			
			ps.setString(1, aging_bucket);
			ps.setString(2, sl_no);
			int x = ps.executeUpdate();
			
			if(x == 1) System.out.println("Updated Value."); else System.out.println("Error Hai Bhai ..");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
