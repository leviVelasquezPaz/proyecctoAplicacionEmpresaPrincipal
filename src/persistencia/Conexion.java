package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    
    public static  Connection conexion() {
         Connection cone = null;
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            cone = DriverManager.getConnection("jdbc:mysql://192.168.1.37/dbempresa", "levi", "123456789");
            System.out.println("conexion exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return cone;
    }

}
