package jdbc_library_manegment_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LibraryCRUD {
	
	public Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/librarydb";
		String user ="root";
		String pass="root";
		
		Connection connection = DriverManager.getConnection(url, user, pass);
		
		return connection;
	}

	public int registerPerson(Library library) throws Exception
	{
		Connection connection = getConnection();
		
		String sql = "insert into signindata values(?,?,?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, library.getId());
		preparedStatement.setString(2, library.getName());
		preparedStatement.setString(3,library.getEmail() );
		preparedStatement.setLong(4, library.getPhone());
		preparedStatement.setString(5, library.getPassword());
		
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
	
	public String logIn(String email) throws Exception
	{
		Connection connection =getConnection();
		String sql = "select password from signindata where email=? ";
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null;
		while (resultSet.next()) 
		{
			password =resultSet.getString("password");
		}
		connection.close();
		
		return password;
	}

	public int addBook(Library library) throws Exception
	{
		Connection connection = getConnection();
		
		String sql = "insert into librarydata values(?,?,?,?)";
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		preparedStatement.setInt(1, library.getbId());
		preparedStatement.setString(2, library.getbName());
		preparedStatement.setString(3, library.getOuther());
		preparedStatement.setString(4, library.getType());
		
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
		
	}
}
