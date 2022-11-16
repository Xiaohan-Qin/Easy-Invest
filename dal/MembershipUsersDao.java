package app.dal;

import app.model.*;
import blog.model.BlogUsers;

import java.util.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;




public class MembershipUsersDao extends UsersDao{
	private static MembershipUsersDao instance = null;
	protected MembershipUsersDao() {
		super();
	}
	public static MembershipUsersDao getInstance() {
		if(instance == null) {
			instance = new MembershipUsersDao();
		}
		return instance;
	}

	
	/**
	 *  create the membership user instance. There is no auto-generated Id 
	 */
	
	public MembershipUsers create(MembershipUsers membershipUser) throws SQLException {
		// Insert the User super class
		create(new Users(membershipUser.getUserName(), membershipUser.getPassword(),
				membershipUser.getCreated(),membershipUser.isMember(),
				membershipUser.getFirstName(),membershipUser.getLastName(),
				membershipUser.getEmail(),membershipUser.getPhone(),
				membershipUser.getCompetencyLevel()));

		String insertMembershipUser = "INSERT INTO MembershipUsers(UserName, Revenue) VALUES(?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertMembershipUser);
			insertStmt.setString(1, membershipUser.getUserName());
			insertStmt.setFloat(2, membershipUser.getRevenue());
			insertStmt.executeUpdate();
			return membershipUser;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(insertStmt != null) {
				insertStmt.close();
			}
		}
		
	}
	
	/**
	 * update the password of membership users
	 * the update only in the super class table
	 */
	public MembershipUsers updatePassword(MembershipUsers membershipUser, String newPassword) throws SQLException {
		super.updatePassword(membershipUser, newPassword);
		return membershipUser;
	}
	
	/**
	 * Delete the membership User instance
	 */
	public MembershipUsers delete(MembershipUsers membershipUser) throws SQLException {
		String deleteMembershipUser = "DELETE FROM MembershipUsers WHERE UserName=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteMembershipUser);
			deleteStmt.setString(1, membershipUser.getUserName());
			int affectedRows = deleteStmt.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("No records available to delete for UserName=" + membershipUser.getUserName());
			}
			super.delete(membershipUser);

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}
	
	

	
	/**
	 * Get membership user (all information included) by username
	 */
	public MembershipUsers getMembershipUserFromUserName(String userName) throws SQLException {
		// build the membership user object and use the User super class
		String selectMembershipUser =
				"SELECT MembershipUsers.UserName AS UserName, Password,"
				+ "Created, isMember,FirstName, LastName,"
				+ "Email, Phone, CompetencyLevel, Revenue"
				+ "FROM MembershipUsers INNER JOIN Users,"
				+ "ON MembershipUsers.UserName = Users.UserName"
				+ "WHERE MembershipUsers.UserName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectMembershipUser);
			selectStmt.setString(1, userName);
			results = selectStmt.executeQuery();
			if(results.next()) {
				String resultUserName = results.getString("UserName");
				String password = results.getString("Password");
				Date created = new Date(results.getTimestamp("Created").getTime());
				
				boolean isMember = results.getBoolean("isMember");
				String firstName = results.getString("FirstName");
				String lastName = results.getString("LastName");
				
				String email = results.getString("Email");
				String phone = results.getString("Phone");
				MembershipUsers.CompetencyLevel competencyLevel = MembershipUsers.CompetencyLevel.valueOf(
						results.getString("CompetencyLevel"));
				
				float revenue = results.getFloat("Revenue");
				MembershipUsers membershipUser = new MembershipUsers(resultUserName,password,
						created, isMember, firstName, lastName,
						email, phone, competencyLevel, revenue);
				
				return membershipUser;
}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}
	
	/**
	 * Get all strategy post by username
	 */
	
	// Align the class name for strategyPost? 
	// Do I need to use union to combine strategy post and repost together? How to realize?
	// StrategyPost will be imported
	public Strategypost getStrategyPostsFromUserName(String userName) throws SQLException {
		// membership user is the child of the users
		String selectPost = ""
				+ "SELECT StrategyPost.UserName AS UserName,"
				+ "PostID, Title, Content, Created"
				+ "Published, Likes"
				+ "FROM StrategyPost INNER JOIN MembershipUsers"
				+ "ON StrategyPost.UserName = MembershipUsers.UserName"
				+ "WHERE StrategyPost.UserName=?;";
		Connection connection = null;
		PreparedStatement  selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPost);
			selectStmt.setString(1, userName);
			results = selectStmt.executeQuery();
			
			if(results.next()) {
				// refer to strategy post class				
				int postId = results.getInt("PostID");
				String title = results.getString("Title");
				String content = results.getString("Content");
				Date created = new Date(results.getTimestamp("Created").getTime());
				
				String resultUserName = results.getString("UserName");
				boolean published = results.getBoolean("Published");
				int likes = results.getInt("Likes");
				
				StrategyPost strategyPost = new StrategyPost(postId, title, content, created, 
						resultUserName, published, likes);
				return selectPost;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}
	
	/**
	 * Get the list of membership users from the username
	 */
	public List<MembershipUsers> getMembershipUsersFromUserName(String userName)
			throws SQLException {
		List<MembershipUsers> membershipUsers = new ArrayList<MembershipUsers>();
		String selectMembershipUsers =
			"SELECT MembershipUsers.UserName AS UserName, Password,"
			+ "Created, isMember,FirstName, LastName,"
			+ "Email, Phone, CompetencyLevel, Revenue"
			+"FROM MembershipUsers INNER JOIN Users " 
			+"  ON MembershipUsers.UserName = Users.UserName " 
			+"WHERE Users.UserName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectMembershipUsers);
			selectStmt.setString(1, userName);
			results = selectStmt.executeQuery();
			while(results.next()) {
				String resultUserName = results.getString("UserName");
				String password = results.getString("Password");
				Date created = new Date(results.getTimestamp("Created").getTime());
				
				boolean isMember = results.getBoolean("isMember");
				String firstName = results.getString("FirstName");
				String lastName = results.getString("LastName");
				
				String email = results.getString("Email");
				String phone = results.getString("Phone");
				MembershipUsers.CompetencyLevel competencyLevel = MembershipUsers.CompetencyLevel.valueOf(
						results.getString("CompetencyLevel"));
				
				float revenue = results.getFloat("Revenue");
				MembershipUsers membershipUser = new MembershipUsers(resultUserName,password,
						created, isMember, firstName, lastName,
						email, phone, competencyLevel, revenue);
				membershipUsers.add(membershipUser);
			}
	

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return membershipUsers;
		
	}
	