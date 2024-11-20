package com.crud.DataFetch;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.*;

/**
 * Servlet implementation class RestApiFetch
 */
@WebServlet("/RestApiFetch")
public class RestApiFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RestApiFetch() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/grey_goose","root","root");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from winter_internship;");
			ArrayList<DataFetch> df = new ArrayList<>();
			
			
			while(rs.next()) {
				DataFetch data = new DataFetch();
				
				data.setSl_no(rs.getInt("sl_no"));
				data.setBusiness_code(rs.getString("business_code"));
				data.setCust_number(rs.getInt("cust_number"));
				data.setClear_date(rs.getString("clear_date"));
				data.setBuisness_year(rs.getInt("Buisness_year"));
				data.setDoc_id(rs.getString("doc_id"));
				data.setPosting_date(rs.getString("posting_date"));
				data.setDocument_create_date(rs.getString("document_create_date"));
				data.setDue_in_date(rs.getString("due_in_date"));
				data.setInvoice_currency(rs.getString("invoice_currency"));
				data.setDocument_type(rs.getString("document_type"));
				data.setPosting_id(rs.getInt("posting_id"));
				data.setTotal_open_amount(rs.getDouble("total_open_amount"));
				data.setBaseline_create_date(rs.getString("baseline_create_date"));
				data.setCust_payment_terms(rs.getString("cust_payment_terms"));
				data.setInvoice_id(rs.getInt("invoice_id"));
				data.setAging_bucket(rs.getString("aging_bucket"));
				
				
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
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
