package dominio;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class FormatoTabla extends DefaultTableCellRenderer {

    private int columna_patron;

    public FormatoTabla(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
//        setBackground(Color.white);//color de fondo
//        table.setForeground(Color.black);//color de texto
        //Si la celda corresponde a una fila con estado FALSE, se cambia el color de fondo a rojo
//        if( table.getValueAt(row,columna_patron).equals("32111993") )
//        {
//            setBackground(Color.MAGENTA);
//        }
//        table.setBackground((row % 2 == 0) ? Color.white : (new Color(162, 229, 229)));
        String aux = table.getValueAt(row, columna_patron).toString();
        if (aux.equals("Temprano")) {
            setBackground(Color.GREEN);
        }

        if (aux.equals("Falta")) {
            setBackground(Color.RED);
        }

        if (aux.equals("Tarde")) {
            setBackground(Color.YELLOW);
        }
        if (aux.equals("Permiso")) {
            setBackground(Color.ORANGE);
        }
        if (aux.equals("Ninguno")) {
            setBackground(Color.WHITE);
        }
        

//        if (table.getValueAt(row, columna_patron).equals("Rojo")) {
//            table.setBackground(Color.RED);
//        }
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
    }

}
