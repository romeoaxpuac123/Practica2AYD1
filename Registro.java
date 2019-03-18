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
	
	//Metodo login para acceder a la plataforma 
	// usuario : nombre del usuario que accede
	// contraseña : contraseña del usuario que accede
	//Retorna verdadero si el nombre de usuario y contraseña son válidos

	Metodo login(texto usuario, texto contraseña){
		//Retorna el resultado del ejecutar el procedimiento almacenado en la base de datos
		booleano respuesta = DB.ejecutar('validar_registro('+usuario+','+contraseña')')

		si (respuesta = verdadero){
			ir "http://www.GrooveShark/Principal.com"
		}
		ir "http://www.GrooveShark/Login.com"
	}
	
	//Revisión realizada con éxito, llevada a cabo por Brayan Brito - 201114566
	
	//SE añadirá el metodo para agregar una playlist.
	
	public boolean insertLista(Playlist Playlist) 
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
	
	public boolean insertCancion(Playlist Playlist, Cancion Song) 
    {
        try
        {
            String sql = "INSERT INTO ListasCancion(name, nameCancion) VALUES (?,?)";
            PreparedStatement preparedStatement = con.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, Playlist.getName());
            preparedStatement.setString(2, Cancion.getName());
            preparedStatement.executeUpdate();
            return true;         
        } 
        catch (SQLException e) 
        {
            System.out.println("Error creando list: " + e.getMessage());
            return false;
        }
    }
	
	//Método para realizar busquedas
	//busqueda: Es el valor por el que se hace la búsqueda
	// tipo_busqueda: Es un número que identifica el tipo de búsqueda a realizarse
	public void Buscar(String busqueda, int tipo_busqueda){
		Tabla canciones;
		if(tipo_busqueda == 1){
			//Busqueda por nombre
			canciones = BD.ejecutar('SELECT canciones WHERE nombre='+busqueda)
		}else if(tipo_busqueda == 2){
			//Busqueda por género
			canciones = BD.ejecutar('SELECT canciones WHERE genero='+busqueda)
		}else if(tipo_busqueda == 3){
			//Busqueda por pais
			canciones = BD.ejecutar('SELECT canciones WHERE pais='+busqueda)
		}else if(tipo_busqueda == 4){
			//Busqueda por artísta
			canciones = BD.ejecutar('SELECT canciones WHERE artista='+busqueda)
		}
		//Método que muestra en la página las canciones obtenidas de la búsqueda
		Ver(canciones);
	}
	
}


/// revisión del registro en release
///domingo por la mañana
<<<<<<< HEAD

///verificando las versiones de este documento
//utlima version 
=======
>>>>>>> release
