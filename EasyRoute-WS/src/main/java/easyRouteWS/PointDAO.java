package easyRouteWS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import easyRouteWS.Point;
import easyRouteWS.Comment;

public class PointDAO {
	
	ArrayList<Point> listPoints = new ArrayList<Point>();
	ArrayList<Comment> listComment = new ArrayList<Comment>();
	
	Connection connection = ConnectionMySQL.getConexao();
	ResultSet result;	
	//Point newPoint = new Point();	
	
	public int insertPoint(Point point) {		
		int res = 0;
		
		/*try {
			connection.setAutoCommit(false);
					
			String insert = "INSERT INTO points(latitude, longitude, access_type) VALUES("+pt.getLatitude()+", "+pt.getLongitude()+", "+pt.getAccessType()+");";
			String query = "SELECT id FROM points ORDER BY id DESC LIMIT 1;";
			
			PreparedStatement statementInsert = connection.prepareStatement(insert);
			PreparedStatement statementQuery =  connection.prepareStatement(query);
			
			statementInsert.executeUpdate(insert);
			result = statementQuery.executeQuery(query);
			
			connection.commit();
			
			result.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			res = result.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		System.out.println("========== InsertPoint DAO ========== ");
		System.out.println("ID: "+point.getId());
		System.out.println("Latitude: "+point.getLatitude());
		System.out.println("Longitude: "+point.getLongitude());
		System.out.println("Access Type: "+point.getAccessType());
		System.out.println("Point Title: "+point.getPointTitle());
		listPoints.add(point);
		return res;
	}
	
	public void insertComment(Comment comentario) {
		
		/*try {
			connection.setAutoCommit(false);
				
			String insert = "INSERT INTO comments(id_point, comment) VALUES("+comentario.getIdPoint()+", '"+comentario.getComment()+"');";
			PreparedStatement statementInsert = connection.prepareStatement(insert);
			
			statementInsert.executeUpdate(insert);			
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		System.out.println("========== InsertComment DAO ========== ");
		System.out.println("Point ID: "+comentario.getIdPoint());
		System.out.println("Comment: "+comentario.getComment());
		
	}
	
	public ArrayList<Point> getPoints() {
		
		/*String query = "SELECT * FROM points";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			
			while(result.next()){
				//System.out.println(result.getInt(1));
				Point newPoint = new Point();				
				newPoint.setId(result.getInt(1));
				newPoint.setLatitude(result.getDouble(2));
				newPoint.setLongitude(result.getDouble(3));
				newPoint.setAccessType(result.getInt(4));
				
				listPoints.add(newPoint);				
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		listPoints.add(new Point(1, 10, 40, 1, "ponto1"));
		listPoints.add(new Point(2, 20, 40, 2, "ponto2"));
		listPoints.add(new Point(3, 30, 40, 3, "ponto3"));
		listPoints.add(new Point(4, 40, 40, 4, "ponto4"));
		listPoints.add(new Point(5, 50, 50, 5, "ponto5"));
		
		return listPoints;
	}
	
	public Point getPoints(int id) {
		
		Point newPoint = new Point();	
		/*String query = "SELECT * FROM points WHERE id = "+id;
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			result.next();
			
			newPoint.setId(result.getInt(1));
			newPoint.setLatitude(result.getDouble(2));
			newPoint.setLongitude(result.getDouble(3));
			newPoint.setAccessType(result.getInt(4));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newPoint;*/
		
		
		listPoints.add(new Point(1, 10, 40, 1, "ponto1"));
		listPoints.add(new Point(2, 20, 40, 2, "ponto2"));
		listPoints.add(new Point(3, 30, 40, 3, "ponto3"));
		listPoints.add(new Point(4, 40, 40, 4, "ponto4"));
		listPoints.add(new Point(5, 50, 50, 5, "ponto5"));
		
		newPoint = listPoints.get(id);
		return newPoint;
		
	}
	
	public ArrayList<Comment> getComments(int id) {
		
		/*String query = "SELECT id_point, comment FROM comments WHERE id_point = "+id;
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			
			while(result.next()){
				Comment comment = new Comment();				
				comment.setIdPoint(result.getInt(1));
				comment.setComment(result.getString(2));
				
				listComment.add(comment);				
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		listComment.add(new Comment(1, "Comentario 1"));
		listComment.add(new Comment(1, "Comentario 2"));
		listComment.add(new Comment(1, "Comentario 3"));
		listComment.add(new Comment(2, "Comentario 1"));
		listComment.add(new Comment(2, "Comentario 2"));
		listComment.add(new Comment(2, "Comentario 3"));
		
		ArrayList<Comment> listCommentAux = new ArrayList<Comment>();
		
		for(int i=0; i<listComment.size(); i++){
			if(listComment.get(i).getIdPoint() == id){
				listCommentAux.add(listComment.get(i));
			}
		}
		
		return listCommentAux;
	}

	public void delete(int id) {

		/*String query = "DELETE FROM points WHERE id = " + id;

		try {
			PreparedStatement statement = connection.prepareStatement(query);

			statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		System.out.println("Delete Point: "+id);
	}

}
