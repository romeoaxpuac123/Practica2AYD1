public class UserDaoImpl
{
    private DbConnection con;
 
    public UserDaoImpl(DbConnection con) {
        this.con = con;
    }
    
    public boolean insert(User user) 
    {
        try
        {
            String sql = "INSERT INTO users(username, password, email) VALUES (?,?,?)";
            PreparedStatement preparedStatement = con.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.executeUpdate();
            return true;         
        } 
        catch (SQLException e) 
        {
            System.out.println("Error insertando al usuario: " + e.getMessage());
            return false;
        }
    }
	
	//SE añadirá el metodo para agregar una playlist.
	
	public boolean insert(Playlist Playlist) 
    {
        try
        {
            String sql = "INSERT INTO Listas(username, name) VALUES (?,?)";
            PreparedStatement preparedStatement = con.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, Playlist.getUsername());
            preparedStatement.setString(2, Playlist.getName());
            preparedStatement.executeUpdate();
            return true;         
        } 
        catch (SQLException e) 
        {
            System.out.println("Error creando list: " + e.getMessage());
            return false;
        }
    }
	
}