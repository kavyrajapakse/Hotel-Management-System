/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treeresort.component;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JPasswordField;

/**
 *
 * @author Dilhara
 */
public class RoundPasswordField extends JPasswordField{

    public RoundPasswordField() {
        init();
    }
    private void init(){
        this.putClientProperty(FlatClientProperties.STYLE, "arc:999; "
               + "margin:0,10,0,10"); 
    }
}
