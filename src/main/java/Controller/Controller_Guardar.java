package Controller;

import View.Guardar;
import Model.Modelo_Guardar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;


public class Controller_Guardar implements ActionListener, ItemListener {
    private Guardar guardar;
    private Modelo_Guardar modeloGuardar;
    public String Ruta;
    public String ItemSelected;
    public int carrera;
    public String NombreArchivo;


    public Controller_Guardar (Guardar guardar) {
        this.guardar = guardar;
        modeloGuardar = new Modelo_Guardar();
        this.guardar.getSubmit().addActionListener(this);
        this.guardar.getBuscarProyecto().addActionListener(this);
        this.guardar.getSubmit().setFocusable(false);
        this.guardar.getBuscarProyecto().setFocusable(false);
        this.guardar.getCarreras().addItemListener(this);
        this.guardar.getCarreras().setFocusable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.guardar.getSubmit()) {

            if (this.modeloGuardar.GuardarProyecto(this.guardar.getCampo().getText(),ItemSelected,Ruta,this.modeloGuardar.Formartearfecha(this.guardar.getDateChooser().getDate()))) {
                try {
                    if (this.modeloGuardar.MoverArchivo(Ruta,this.guardar.Rutas[carrera]+NombreArchivo)) {
                        this.guardar.Alert("Proyecto Guardado Exitosamente!!");
                    }
                } catch (IOException ex) {
                    this.guardar.Alert("Error, verifique los campos");
                }
            }
        } else if (e.getSource() == this.guardar.getBuscarProyecto()) {
            Ruta = this.modeloGuardar.ObtenerRutaProyecto(this.guardar.getFileChooser());
            NombreArchivo = this.modeloGuardar.ObtenerNombreArchivo(this.guardar.getFileChooser());
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            ItemSelected = e.getItem().toString();

            switch (ItemSelected) {
                case "Informática": carrera = 0; break;
                case "Agroalimentaria": carrera = 1; break;
                case "Educación Inicial": carrera = 3; break;
                case "Educación Física": carrera = 4; break;
                case "Educación sin mención": carrera = 2; break;
                default: break;
            }
        }
    }
}
