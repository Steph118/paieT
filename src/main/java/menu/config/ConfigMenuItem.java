/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu.config;

import java.util.List;

/**
 *
 * @author steph18
 */
public class ConfigMenuItem {

    private String code;
    private String label;
    private String path;
    private String icon;
    private String requiredPermission;
    private int order;
    private List<ConfigMenuItem> items;

    public ConfigMenuItem() {
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

    public List<ConfigMenuItem> getItems() {
        return items;
    }

    public void setItems(List<ConfigMenuItem> items) {
        this.items = items;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ConfigMenuItem{" + "code=" + code + ", label=" + label + ", path=" + path + ", icon=" + icon + ", requiredPermission=" + requiredPermission + ", order=" + order + ", children=" + items + '}';
    }

}
