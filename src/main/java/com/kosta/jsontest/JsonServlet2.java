package com.kosta.jsontest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class JsonServlet2
 */
@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();

		JSONObject totalObject = new JSONObject(); 
		//{}
		JSONArray membersArray = new JSONArray(); 
		//[]
		JSONObject memberInfo = new JSONObject(); 
		//{"name":"������","age"25,"gender":"����","nickname":"��������"}

		memberInfo.put("name", "������");
		memberInfo.put("age", "25");
		memberInfo.put("gender", "����");
		memberInfo.put("nickname", "��������");
        
		//  �迭�� �Է�
		//[{"name":"������","age":25,"gender":"����","nickname":"��������"}]
		membersArray.add(memberInfo);

		//{"name":"�迬��","age":21,"gender":"����","nickname":"Įġ"}
		memberInfo = new JSONObject();
		memberInfo.put("name", "�迬��");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "����");
		memberInfo.put("nickname", "Įġ");
		membersArray.add(memberInfo);

		
		totalObject.put("members", membersArray);
		//["members" : {"name":"������","age":25,"gender":"����","nickname":"��������"}
		//				{"name":"�迬��","age":21,"gender":"����","nickname":"Įġ"}]
		
		String jsonInfo = totalObject.toJSONString();
		System.out.print(jsonInfo);
		writer.print(jsonInfo);
	}

}