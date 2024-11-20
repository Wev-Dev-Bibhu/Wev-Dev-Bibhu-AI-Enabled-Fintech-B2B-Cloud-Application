package com.crud.DataFetch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class AnalyticsView
 */
@WebServlet("/AnalyticsView")
public class AnalyticsView extends HttpServlet {      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalyticsView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String clear_date_from = request.getParameter("clear_date_from");
			String clear_date_to = request.getParameter("clear_date_to");
			
			String due_in_date_from = request.getParameter("due_date_from");
			String due_in_date_to = request.getParameter("due_date_to");
			
			String baseline_create_date_from = request.getParameter("baseline_create_date_from");
			String baseline_create_date_to = request.getParameter("baseline_create_date_to");
			
			String invoice_currency = request.getParameter("invoice_currency");
			
			System.out.println(clear_date_from + " And " + clear_date_to + " AND " +invoice_currency);
			ArrayList<DataFetch> df = new ArrayList<>();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/grey_goose","root","root");	
			try {
				String query = "SELECT winter_internship.business_code,winter_internship.invoice_currency,winter_internship.total_open_amount, COUNT(winter_internship.business_code) ,business.business_name FROM winter_internship INNER JOIN business ON winter_internship.business_code=business.business_code WHERE  invoice_currency = ? OR clear_date BETWEEN ? AND ? OR due_in_date BETWEEN ? AND ? OR baseline_create_date BETWEEN ? AND ? GROUP BY business_code;";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1,invoice_currency);
				ps.setString(2, clear_date_from);
				ps.setString(3, clear_date_to);
				ps.setString(4, due_in_date_from);
				ps.setString(5, due_in_date_to);
				ps.setString(6, baseline_create_date_from);
				ps.setString(7, baseline_create_date_to);
		        ResultSet rs = ps.executeQuery();
				 while (rs.next()) {
					 DataFetch data = new DataFetch();
					 data.setInvoice_currency(rs.getString("invoice_currency"));
					 data.setTotal_open_amount(rs.getDouble("total_open_amount"));
					 data.setNo_of_customers(rs.getInt("COUNT(winter_internship.business_code)"));
					 data.setBusiness_name(rs.getString("business_name"));
					 df.add(data);
			        }
				 Gson gson = new GsonBuilder().serializeNulls().create();
					String invoiceData = gson.toJson(df);
					response.setContentType("application/json");
					try {
						response.getWriter().write(invoiceData);
					} catch (Exception e) {
						e.printStackTrace();
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
