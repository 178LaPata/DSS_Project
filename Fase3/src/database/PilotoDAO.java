package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Jogo.Extra.Piloto;

public class PilotoDAO {
    public Piloto get() {
        Piloto p = null;
        try (Connection conn = 
                    DriverManager.getConnection(DAOconfig.URL+DAOconfig.CREDENTIALS);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Piloto WHERE idPiloto="+1+" ")) {
                if (rs.next()) {
                    int on = rs.getInt("Online");
                    boolean online = false;
                    if(on == 1)
                        online = true;
    
                    p = new Piloto (rs.getInt("idPiloto"),
                            rs.getString("Nome"),
                            rs.getString("SVA"),
                            rs.getString("CTS"),
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
                    }


