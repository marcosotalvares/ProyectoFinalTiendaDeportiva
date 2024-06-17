import Contenedor.Tienda;
import UI.ConsolaUI;

import Exception.IdNotFoundException;
import Exception.IdDuplicatedException;
import Exception.UserNotFoundException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        ConsolaUI consolaUI = new ConsolaUI(tienda);
        try {
            consolaUI.mostrarMenuIngreso();
        } catch (IdDuplicatedException | IdNotFoundException | UserNotFoundException e ) {
            System.out.println(e.getMessage());
        }
    }
}