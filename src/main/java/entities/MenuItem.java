/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author komilo
 */
@Entity
@Table(name = "menu_items")
public class MenuItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "label", nullable = false)
    private String label;

    @Column(name = "path", nullable = false)
    private String path;

    @Column(name = "icon", nullable = true)
    private String icon;

    @Column(name = "badge", nullable = true)
    private String badge;

    @Column(name = "badge_severity", nullable = true)
    private String badgeSeverity;

    @Column(name = "image_source", nullable = true)
    private String imageSource;

    @Column(name = "weight", nullable = true)
    private int weight;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "parent_item_id", nullable = true)
    private MenuItem parentItem;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_code", nullable = true)
    private Permission permission;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentItem")
    private List<MenuItem> items = new ArrayList<>();

    public MenuItem() {
    }

    public MenuItem(String code, String label, int weight) {
        this.code = code;
        this.label = label;
        this.weight = weight;
        this.path = "#";
    }

    public MenuItem(String code, String label, String itemPath, String iconClass, int weight) {
        this.code = code;
        this.label = label;
        this.path = itemPath;
        this.icon = iconClass;
        this.weight = weight;
    }

    public MenuItem(String code, String label, int weight, MenuItem parentItem, Menu parentMenu) {
        this.code = code;
        this.label = label;
        this.path = "#";
        this.weight = weight;
        this.parentItem = parentItem;
        this.menu = parentMenu;
    }

    public MenuItem(String code, String label, String itemPath, String iconClass, int weight, MenuItem parentItem, Menu parentMenu, Permission permission) {
        this.code = code;
        this.label = label;
        this.path = itemPath;
        this.icon = iconClass;
        this.weight = weight;
        this.parentItem = parentItem;
        this.menu = parentMenu;
        this.permission = permission;
    }

    public boolean isTopMenu() {
        return this.parentItem == null;
    }

    public boolean hasItems() {
        return this.items.size() >= 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getBadgeSeverity() {
        return badgeSeverity;
    }

    public void setBadgeSeverity(String badgeSeverity) {
        this.badgeSeverity = badgeSeverity;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public MenuItem getParentItem() {
        return parentItem;
    }

    public void setParentItem(MenuItem parentItem) {
        this.parentItem = parentItem;
    }

    public Menu getParentMenu() {
        return menu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.menu = parentMenu;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuItem other = (MenuItem) obj;
        return Objects.equals(this.code, other.code);
    }

    @Override
    public String toString() {
        return "MenuItem{" + "id=" + id + ", code=" + code + ", label=" + label + ", path=" + path + ", icon=" + icon + ", badge=" + badge + ", badgeSeverity=" + badgeSeverity + ", imageSource=" + imageSource + ", weight=" + weight + ", parentItem=" + parentItem + ", menu=" + menu + ", permission=" + permission + ", items=" + items + '}';
    }

}
