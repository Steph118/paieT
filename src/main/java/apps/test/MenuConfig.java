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
public class MenuConfig {

    private String code;
    private String label;
    private List<MenuItemConfig> items;

    public MenuConfig() {
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

    public List<MenuItemConfig> getItems() {
        return items;
    }

    public void setItems(List<MenuItemConfig> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "MenuConfig{" + "code=" + code + ", label=" + label + ", items=" + items + '}';
    }
    

}
