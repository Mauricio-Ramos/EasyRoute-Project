package easyRouteWS;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;



/**
 * Servlet implementation class servlet
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PointDAO pointDAO = new PointDAO(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String role = request.getParameter("role");

		//response.setContentType("application/json;charset=UTF-8");
		response.setContentType("application/json");
		
		if(role.equals("get")) {
			
			
			
			ArrayList<Point> points = pointDAO.getPoints();

			Gson gson = new GsonBuilder().create();
			JsonArray jarray = gson.toJsonTree(points).getAsJsonArray();
			JsonObject jsonObject = new JsonObject();
			jsonObject.add("points", jarray);

			response.getWriter().append(jsonObject.toString());

		}
		else if(role.equals("getID")) {
			String pointID = request.getParameter("id");
			
			System.out.println("Value "+pointID);
			
			Point point = pointDAO.getPoints(Integer.parseInt(pointID));
			
			System.out.println(point.getId()+" "+point.getLatitude()+" "+point.getLongitude()+" "+point.getAccessType()+" "+point.getPointTitle());
            
			Gson gson = new Gson();
	        String jsonClient = gson.toJson(point);			
			
	        response.getWriter().append(jsonClient);
		}
		else if(role.equals("getComments")) {			
				
			String commentID = request.getParameter("id");

			ArrayList<Comment> listComments = pointDAO.getComments(Integer.parseInt(commentID));

			Gson gson = new GsonBuilder().create();
			JsonArray jarray = gson.toJsonTree(listComments).getAsJsonArray();
			JsonObject jsonObject = new JsonObject();
			jsonObject.add("comments", jarray);

			response.getWriter().append(jsonObject.toString());	      
			
			System.out.println("GetComments OK");
			
		}
		else {
			System.out.println(role + " Error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("application/json;charset=UTF-8");
		
		String role = request.getParameter("role");
		
		if(role.equals("insertPoint")) {
			System.out.println("insertPoint OK");
			
			Point point = new Point();
			JSONObject jObj = new JSONObject();
			StringBuilder json = new StringBuilder();		
			BufferedReader reader = request.getReader();
			String linha;
			
			while((linha = reader.readLine()) != null ) {
			    json.append(linha);
			}	
			
			try {
				System.out.println(json.toString());
				jObj = new JSONObject(json.toString());
				
				point.setId(jObj.getInt("id"));
	            point.setLatitude(jObj.getDouble("latitude"));
	            point.setLongitude(jObj.getDouble("longitude"));
	            point.setAccessType(jObj.getInt("accessType"));
	            point.setPointTitle(jObj.getString("pointTitle"));
	            
	            pointDAO.insertPoint(point);
	            
			} catch (JSONException e) {
				System.out.println(json.toString());
				e.printStackTrace();
			}
		}
		else if (role.equals("insertComment")) {
			System.out.println("insertComment OK");
			
			Comment comment = new Comment();
			
			JSONObject jObj = new JSONObject();
			StringBuilder json = new StringBuilder();		
			BufferedReader reader = request.getReader();
			String linha;
			
			while((linha = reader.readLine()) != null ) {
			    json.append(linha);
			}
			
			try {				
				System.out.println(json.toString());
				jObj = new JSONObject(json.toString());
				
				comment.setIdPoint(jObj.getInt("idPoint"));
				comment.setComment(jObj.getString("comment"));
				
				pointDAO.insertComment(comment);
				
			} catch (JSONException e) {
				System.out.println(json.toString());
				e.printStackTrace();
			}			
		}
		else if(role.equals("delete")) {
			
			String pointID = request.getParameter("id");
			
			pointDAO.delete(Integer.parseInt(pointID));
			
		}
		else {
			System.out.println(role + " Error");
		}
	}
	
}
