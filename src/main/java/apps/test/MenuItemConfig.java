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
public class MenuItemConfig {

    private String code;
    private String label;
    private String path;
    private String icon;
    private String requiredPermission;
    private List<MenuItemConfig> children;

    public MenuItemConfig() {
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getRequiredPermission() {
        return requiredPermission;
    }

    public void setRequiredPermission(String requiredPermission) {
        this.requiredPermission = requiredPermission;
    }

    public List<MenuItemConfig> getChildren() {
        return children;
    }

    public void setChildren(List<MenuItemConfig> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "MenuItemConfig{" + "code=" + code + ", label=" + label + ", path=" + path + ", icon=" + icon + ", requiredPermission=" + requiredPermission + ", items=" + children + '}';
    }
    
    
    
}
