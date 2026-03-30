/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treeresort.component;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JTextField;

/**
 *
 * @author Dilhara
 */
public class RoundTextfield extends JTextField{

    public RoundTextfield() {
        init();
    }
    private void init(){
       this.putClientProperty(FlatClientProperties.STYLE, "arc:999; "
               + "margin:0,10,0,10"); // TOP, LEFT, BOTTOM, RIGHT
    }
}
