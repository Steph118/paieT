/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apps.test;

import java.util.List;

/**
 *
 * @author steph18
 */
public class PermissionCategoryConfig {

    private String code;
    private String label;
    private List<PermissionConfig> permissions;

    public PermissionCategoryConfig() {
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

    public List<PermissionConfig> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionConfig> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "PermissionCategoryConfig{" + "code=" + code + ", label=" + label + ", permissions=" + permissions + '}';
    }
    
    
    
    
}
