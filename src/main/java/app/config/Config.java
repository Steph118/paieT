package app.config;

import java.util.List;

public class Config {

    private String version;
    private List<ConfigPermissionCategory> permission_categories;
    private List<ConfigMenu> menus;

    public Config() {
        //
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<ConfigPermissionCategory> getPermission_categories() {
        return permission_categories;
    }

    public void setPermission_categories(List<ConfigPermissionCategory> permission_categories) {
        this.permission_categories = permission_categories;
    }

    public List<ConfigMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<ConfigMenu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Config{" + "version=" + version + ", permission_categories=" + permission_categories + ", menus=" + menus + '}';
    }
    

}
