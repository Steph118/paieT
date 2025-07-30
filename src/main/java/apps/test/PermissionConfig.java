/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apps.test;

/**
 *
 * @author steph18
 */
public class PermissionConfig {

    private String code;
    private String label;

    public PermissionConfig() {
        //
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "PermissionConfig{" + "code=" + code + ", label=" + label + '}';
    }
    

}
