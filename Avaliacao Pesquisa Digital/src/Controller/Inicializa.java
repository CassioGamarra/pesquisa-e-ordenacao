/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ViewCompleta;

/**
 *
 * @author cassio
 */
public class Inicializa {
    public static void main(String[] args) {
        ViewCompleta view = new ViewCompleta();
        view.setExtendedState(view.MAXIMIZED_BOTH);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
