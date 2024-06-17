package Controller;

import Model.Modelo_Visualizar;
import View.Visualizar;
import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller_Visualizar implements ActionListener, ItemListener {
    private Visualizar visualizar;
    private Modelo_Visualizar modeloVisualizar;
    public String ItemSelected, carrera;
    public int ColumnIndex, RowIndex;

    public Controller_Visualizar(Visualizar visualizar) {
        this.visualizar = visualizar;
        this.visualizar.getCarreras().addItemListener(this);
        this.visualizar.getBtnBuscar().addActionListener(this);
        this.visualizar.getBtnAbrirProyecto().addActionListener(this);
        modeloVisualizar = new Modelo_Visualizar();
    }

    public void SetTable(String Carrera) throws SQLException {
        String[] ProyectData = new String[5];
        visualizar.getModeloTablaProyectos().setRowCount(0);
        ResultSet Data = (ResultSet) modeloVisualizar.GetCarreras(Carrera);

        while (Data.next()) {
            ProyectData[0] = Data.getString(1);
            ProyectData[1] = Data.getString(2);
            ProyectData[2] = Data.getString(3);
            ProyectData[3] = Data.getString(4);
            ProyectData[4] = Data.getString(5);
            visualizar.getModeloTablaProyectos().addRow(ProyectData);
        }
        visualizar.getTablaProyectos().setModel(visualizar.getModeloTablaProyectos());
    }

    public void AbrirProyecto () throws IOException {
        ColumnIndex = this.visualizar.getTablaProyectos().getSelectedColumn();
        RowIndex = this.visualizar.getTablaProyectos().getSelectedRow();
        String Ruta = (String) this.visualizar.getTablaProyectos().getValueAt(RowIndex,ColumnIndex);
        try {
            Desktop.getDesktop().open(new File(Ruta));
        }catch(IOException e){
            e.printStackTrace();
        }catch(IllegalArgumentException e){
            this.visualizar.AlertError("No se pudo encontrar el archivo, seleccione la ruta interna del proyecto");
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.visualizar.getBtnBuscar()) {
            try {
                SetTable(carrera);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == this.visualizar.getBtnAbrirProyecto()) {
            try {
                AbrirProyecto();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            ItemSelected = e.getItem().toString();

            switch (ItemSelected) {
                case "Informática":
                    carrera = "Informática";
                    break;
                case "Agroalimentaria":
                    carrera = "Agroalimentaria";
                    break;
                case "Educación Inicial":
                    carrera = "Educación Inicial";
                    break;
                case "Educación Física":
                    carrera = "Educación Física";
                    break;
                case "Educación sin mención":
                    carrera = "Educación sin mención";
                    break;
                default:
                    carrera = "";
                    break;
            }
        }
    }

}
