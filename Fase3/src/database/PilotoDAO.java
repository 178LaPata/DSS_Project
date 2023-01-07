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

                    p = new Piloto (rs.getInt("idPiloto"),
                            rs.getString("Nome"),
                            rs.getInt("SVA"),
                            rs.getInt("CTS"));
                } else {
                    p = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
            return p;
    }

    public void updatePiloto(Piloto p) {
        try (Connection conn =
                     DriverManager.getConnection(DAOconfig.URL+DAOconfig.CREDENTIALS);
             Statement stm = conn.createStatement()) {

            stm.executeUpdate("INSERT INTO Piloto VALUES ("+p.getIdPiloto()+"','"+p.getNome()+"','"+
            p.getSVA()+"','"+p.getCTS()+"','"+ ")" +
                    "ON DUPLICATE KEY UPDATE Nome=Values(Nome), SVA=Values(SVA), CTS=Values(CTS)");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }
}
