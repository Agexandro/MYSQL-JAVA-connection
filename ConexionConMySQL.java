package conexionconmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AleX
 */
public class ConexionConMySQL {

    private final String user = "Alex";
    private final String password = "root";
    private final String url = "jdbc:mysql://localhost:3306/usuarios";
    private Connection conection = null;

    public ConexionConMySQL() {
        try {
            System.out.println("Conectado...");
            this.conection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println("Fatal Error Caos Total Fin Del Mundo: " + e.getMessage());

        }
    }

    public void CloseConection() throws SQLException {
        conection.close();
    }

    public void Statements() throws SQLException {
        Statement statement = this.conection.createStatement();
        ResultSet resultado = statement.executeQuery("Select*from users");
        Imprimir(resultado);
    }

    public void Imprimir(ResultSet bolsitaDatos) throws SQLException {
        int contador = 1;
        while (bolsitaDatos.next()) {
            System.out.println(bolsitaDatos.getString("nombre") + " " + bolsitaDatos.getString("apellido"));
        }
    }

    //Solo Pruebas
    public static void main(String[] args) throws SQLException {
        ConexionConMySQL con = new ConexionConMySQL();
        con.Statements();
        con.CloseConection();
    }
}
