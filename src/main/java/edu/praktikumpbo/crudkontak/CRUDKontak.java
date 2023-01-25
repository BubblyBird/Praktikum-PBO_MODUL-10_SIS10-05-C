/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package edu.praktikumpbo.crudkontak;

import edu.praktikumpbo.crudkontak.Frame.FrameKontak;
import javax.swing.SwingUtilities;

/**
 *
 * @author Putri
 */
public class CRUDKontak {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FrameKontak form = new FrameKontak();
                form.setLocationRelativeTo (null);
                form.setVisible(true);
            }
        });
    }
}
