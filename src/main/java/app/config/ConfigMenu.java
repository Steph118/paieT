/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.config;

import java.util.List;

/**
 *
 * @author steph18
 */
public class ConfigMenu {

    private String code;
    private String label;
    private List<ConfigMenuItem> items;

    public ConfigMenu() {
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

    public List<ConfigMenuItem> getItems() {
        return items;
    }

    public void setItems(List<ConfigMenuItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "MenuConfig{" + "code=" + code + ", label=" + label + ", items=" + items + '}';
    }
    

}
