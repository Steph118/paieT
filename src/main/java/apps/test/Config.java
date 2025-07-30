package apps.test;

import java.util.List;

public class Config {

    private String version;
    private List<PermissionCategoryConfig> permission_categories;
    private List<MenuConfig> menus;

    public Config() {
        //
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<PermissionCategoryConfig> getPermission_categories() {
        return permission_categories;
    }

    public void setPermission_categories(List<PermissionCategoryConfig> permission_categories) {
        this.permission_categories = permission_categories;
    }

    public List<MenuConfig> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuConfig> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Config{" + "version=" + version + ", permission_categories=" + permission_categories + ", menus=" + menus + '}';
    }
    

}
