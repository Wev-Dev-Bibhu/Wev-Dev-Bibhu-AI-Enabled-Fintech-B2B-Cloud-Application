package com.crud.DataFetch;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class AdvanceSearch
 */
@WebServlet("/AdvanceSearch")
public class AdvanceSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvanceSearch() {
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
		// TODO Auto-generated method stub
		try {
		String doc_id = request.getParameter("doc_id");
		String invoice_id = request.getParameter("invoice_id");
		String cust_number = request.getParameter("cust_number");
		String business_year =  request.getParameter("business_year");
		ArrayList<DataFetch> df = new ArrayList<>();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/grey_goose","root","root");
			String query = "SELECT * FROM winter_internship WHERE (doc_id LIKE ? AND invoice_id LIKE ? AND cust_number LIKE ? AND buisness_year LIKE ?) OR (doc_id LIKE ? OR invoice_id LIKE ? AND cust_number LIKE ? AND buisness_year LIKE ?) OR (doc_id LIKE ? OR invoice_id LIKE ? AND cust_number LIKE ? OR buisness_year LIKE ?)  OR (doc_id LIKE ? AND invoice_id LIKE ? OR cust_number LIKE ? OR buisness_year LIKE ?);";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, doc_id);
			ps.setString(2, invoice_id);
			ps.setString(3,cust_number);
			ps.setString(4,business_year);
			ps.setString(5, doc_id);
			ps.setString(6, invoice_id);
			ps.setString(7,cust_number);
			ps.setString(8,business_year);
			ps.setString(9, doc_id);
			ps.setString(10, invoice_id);
			ps.setString(11,cust_number);
			ps.setString(12,business_year);
			ps.setString(13, doc_id);
			ps.setString(14, invoice_id);
			ps.setString(15,cust_number);
			ps.setString(16,business_year);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
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
			ps.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
