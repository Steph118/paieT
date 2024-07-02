package menu;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class MenuItem implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String label;
    private String url;
    private List<MenuItem> menuItems;
    private String badge;
    private String badgeSeverity;
    private MenuItem parent;
    private String imageSrc;

    public MenuItem(String label, String url) {
        this.label = label;
        this.url = url;
    }

    public MenuItem(String label, String url, String imageSrc) {
        this.label = label;
        this.url = url;
        this.imageSrc = imageSrc;
    }

    public MenuItem(String label, String url, String badge, String imageSrc) {
        this.label = label;
        this.url = url;
        this.badge = badge;
        this.imageSrc = imageSrc;
    }

    public MenuItem(String label, List<MenuItem> menuItems) {
        this.label = label;
        this.menuItems = menuItems;
    }

    public MenuItem(String label, List<MenuItem> menuItems, String badge) {
        this.label = label;
        this.menuItems = menuItems;
        this.badge = badge;
    }

    public String getLabel() {
        return label;
    }

    public String getUrl() {
        return url;
    }

    public String getBadge() {
        return badge;
    }

    public String getBadgeSeverity() {
        if (badgeSeverity != null) {
            return badgeSeverity;
        }
        badgeSeverity = "primary";
        if ("Deprecated".equalsIgnoreCase(badge)) {
            badgeSeverity = "warning";
        }
        if ("New".equalsIgnoreCase(badge)) {
            badgeSeverity = "success";
        }
        return badgeSeverity;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public MenuItem getParent() {
        return parent;
    }

    public void setParent(MenuItem parent) {
        this.parent = parent;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, url);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MenuItem)) {
            return false;
        }
        MenuItem other = (MenuItem) obj;
        return Objects.equals(label, other.label) && Objects.equals(url, other.url);
    }

    @Override
    public String toString() {
        return "MenuItem [label=" + label + ", url=" + url + "]";
    }
}
