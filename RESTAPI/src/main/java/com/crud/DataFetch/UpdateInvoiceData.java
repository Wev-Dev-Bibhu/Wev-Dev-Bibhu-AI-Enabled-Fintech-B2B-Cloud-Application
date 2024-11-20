package com.crud.DataFetch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateInvoiceData
 */
@WebServlet("/UpdateInvoiceData")
public class UpdateInvoiceData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInvoiceData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String invoice_currency = request.getParameter("invoiceCurrency");
		String cust_payment_terms = request.getParameter("customerPayment");
		String sl_no = request.getParameter("deleteInvoiceId");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/grey_goose","root","root");
			PreparedStatement ps = con.prepareStatement("update winter_internship set invoice_currency = ?,cust_payment_terms = ? where sl_no = ? ;");
			ps.setString(1,invoice_currency);
			ps.setString(2, cust_payment_terms);
			ps.setString(3, sl_no);
			ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
