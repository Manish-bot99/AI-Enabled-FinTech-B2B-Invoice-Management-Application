package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class FetchDataServlet
 */
@WebServlet("/FetchDataServlet")
public class FetchDataServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 
 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
 static final String url = "jdbc:mysql://localhost/invoice_management";
 static final String username = "root";
 static final String password = "root";
 

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
  Connection conn = null;
  Statement stmt = null;
  ResultSet result = null;
  List<Response> responserows = new ArrayList<>();
  try {
   Class.forName("com.mysql.cj.jdbc.Driver");
   conn = DriverManager.getConnection(url, username, password);
   stmt = conn.createStatement();
   String sql;
   Integer start=Integer.parseInt(request.getParameter("start"));
   Integer limit=Integer.parseInt(request.getParameter("limit"));

   sql = "Select * from mytable LIMIT "+start+","+limit;
 
   result = stmt.executeQuery(sql);
   while(result.next()) {
    Response responsedata = new Response();
    responsedata.setFIELD1(result.getInt("FIELD1"));
    responsedata.setVisi(result.getInt("visi"));
    responsedata.setName_customer(result.getString("name_customer"));
    responsedata.setCust_number(result.getString("cust_number"));
    responsedata.setInvoice_id(result.getLong("invoice_id"));
    responsedata.setTotal_open_amount(result.getFloat("total_open_amount"));
    responsedata.setDue_in_date(result.getDate("due_in_date"));
    responsedata.setClear_datepredicted(result.getDate("clear_datepredicted"));
    responsedata.setDELAY_BUCKETDAYS(result.getString("DELAY_BUCKETDAYS"));

    responserows.add(responsedata);
   } 
   Gson gson = new GsonBuilder().setPrettyPrinting().create();
   String json = gson.toJson(responserows);
   PrintWriter out = response.getWriter();  
   out.println(json);
   
   conn.close();
   stmt.close();
   result.close();
  }
  catch(Exception e) {
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