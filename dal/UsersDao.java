package app.dal;

import app.model.*;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class UsersDao {
	protected ConnectionManager connectionManager;
	private static UsersDao instance = null;
	protected UsersDao() {
		connectionManager = new ConnectionManager();
	}
	public static UsersDao getInstance() {
		if(instance == null) {
			instance = new UsersDao();
		}
		return instance;
	}

	/**
		Create user instance
	 */
	public Users create(Users user) throws SQLException {
		String insertUser = "INSERT INTO Users(UserName, Password,"
				+ "Created, isMember,"
				+ "FirstName,LastName,"
				+ "Email, Phone,"
				+ "CompetencyLevel) "
				+ "VALUES(?,?,?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;		
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertUser);

			insertStmt.setString(1, user.getUserName());
			insertStmt.setString(2, user.getPassword());
			insertStmt.setTimestamp(3, new Timestamp(user.getCreated().getTime()));
			insertStmt.setBoolean(4, user.isMember());
			insertStmt.setString(5, user.getFirstName());
			insertStmt.setString(6, user.getLastName());
			insertStmt.setString(7, user.getEmail());
			insertStmt.setString(8, user.getPhone());
			insertStmt.setString(9, user.getCompetencyLevel().name());

			insertStmt.executeUpdate();
			
			return user;
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
	 * Update the password for user 
	 */
	public Users updateLastName(Users user, String newPassword) throws SQLException {
		String updateUser = "UPDATE Users SET Password=? WHERE UserName=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateUser);
			updateStmt.setString(1, newPassword);
			updateStmt.setString(2, user.getUserName());
			updateStmt.executeUpdate();
			user.setPassword(newPassword);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(updateStmt != null) {
				updateStmt.close();
			}
		}
	}

	/**
	 * Delete user
	 */
	public Users delete(Users user) throws SQLException {
		String deleteUser = "DELETE FROM Users WHERE UserName=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteUser);
			deleteStmt.setString(1, user.getUserName());
			deleteStmt.executeUpdate();

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
	 * Get user from competency level
	 */
	
	public Users getUserFromCompetencyLevel(Users.CompetencyLevel competency) throws SQLException {
		String selectUser = "SELECT UserName,Password, "
				+ "Created, isMember, "
				+ "FirstName,LastName, "
				+ "Email, Phone,"
				+ "CompetencyLevel  "
				+ "FROM Users "
				+ "WHERE CompetencyLevel=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setString(1, competency.name());
			results = selectStmt.executeQuery();

			if(results.next()) {
				String userName = results.getString("UserName");
				String password = results.getString("Password");
				Date created = new Date(results.getTimestamp("Created").getTime());
				boolean isMember = results.getBoolean("isMember");
				String firstName = results.getString("FirstName");
				String lastName = results.getString("LastName");
				String email = results.getString("Email");
				String phone = results.getString("Phone");
				Users.CompetencyLevel competencyLevel = Users.CompetencyLevel.valueOf(results.getString("CompetencyLevel"));
				
				Users user = new Users(userName,password,created,isMember,firstName,lastName,
						email,phone,competencyLevel);
				return user;
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
	 * Get the matching users from the date registered
	 */
	public List<Users> getUsersFromCreateDate(Date created) throws SQLException {
		List<Users> users = new ArrayList<Users>();
		String selectUser = "SELECT UserName,Password, "
				+ "Created, isMember, "
				+ "FirstName,LastName, "
				+ "Email, Phone,"
				+ "CompetencyLevel  "
				+ "FROM Users "
				+ "WHERE Created=?;";
		
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			// there is a error if I put as setDate(1, created), it shows the sql.date
			// does not match util date. So my solution is to cast the date to sql.date here
			// If there is any better solution, please add. 
			
			selectStmt.setDate(1, (java.sql.Date) created);
			results = selectStmt.executeQuery();
			while(results.next()) {
				String userName = results.getString("UserName");
				String password = results.getString("Password");
				Date resultCreated = new Date(results.getTimestamp("Created").getTime());
				boolean isMember = results.getBoolean("isMember");
				String firstName = results.getString("FirstName");
				String lastName = results.getString("LastName");
				String email = results.getString("Email");
				String phone = results.getString("Phone");
				Users.CompetencyLevel competencyLevel = Users.CompetencyLevel.valueOf(results.getString("CompetencyLevel"));
				Users user = new Users(userName,password,resultCreated,isMember,firstName,lastName,
						email,phone,competencyLevel);
				users.add(user);
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
		return users;
	}
}
