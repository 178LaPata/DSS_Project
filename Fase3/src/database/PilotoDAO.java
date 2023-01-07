package database;
import Piloto;

public class PilotoDAO {
    public Carro get() {

    }



}


/*
public class GestorDAO {

    public Gestor get() {
        Gestor p = null;
        try (Connection conn =
                     DriverManager.getConnection(DAOconfig.URL+DAOconfig.CREDENTIALS);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM Gestor WHERE idGestor="+1+" ")) {
            if (rs.next()) {
                int on = rs.getInt("Online");
                boolean online = false;
                if(on == 1)
                    online = true;

                p = new Gestor(rs.getInt("idGestor"),
                        rs.getString("Nome"),
                        rs.getString("Password"),
                        online);
            } else {
                p = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return p;
    }
 
 */
