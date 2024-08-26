package menu;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Named
@ApplicationScoped
public class AppMenu {

    private List<MenuCategory> menuCategories;
    private List<MenuItem> menuItems;

    // CHECKSTYLE:OFF
    @PostConstruct
    public void init() {
        menuCategories = new ArrayList<>();
        menuItems = new ArrayList<>();

        List<MenuItem> administrationMenus = new ArrayList<>();
        List<MenuItem> referenceMenus = new ArrayList<>();
        List<MenuItem> paiMenus = new ArrayList<>();

        administrationMenus.add(new MenuItem("Utilisateurs", "/paie/pages/admin/users/list.xhtml", "fa-solid fa-users"));
        administrationMenus.add(new MenuItem("Rôles", "/paie/pages/admin/roles/list.xhtml", "fa-solid fa-ring"));
        administrationMenus.add(new MenuItem("Eglises", "/paie/pages/admin/entites/eglises/list.xhtml", "fa-solid fa-synagogue"));
        administrationMenus.add(new MenuItem("Membres", "/paie/pages/admin/members/list.xhtml", "fa-solid fa-users"));
        administrationMenus.add(new MenuItem("Personnes", "/paie/pages/admin/persons/list.xhtml", "fa-solid fa-user"));
        administrationMenus.add(new MenuItem("Localités", "/paie/pages/admin/localities/locality/list.xhtml", "fa-solid fa-location-dot"));
        administrationMenus.add(new MenuItem("Types de localités", "/paie/pages/admin/localities/type-locality/list.xhtml", "fa-solid fa-location-dot"));
        administrationMenus.add(new MenuItem("Paramètres", "/paie/pages/admin/roles/list.xhtml", "fa-solid fa-gear"));
        administrationMenus.add(new MenuItem("Crédits", "/paie/pages/admin/loan/list.xhtml", "fa-solid fa-coins"));

        referenceMenus.add(new MenuItem("Pays", "/paie/pages/admin/references/country/list.xhtml", "fa-solid fa-globe"));
        referenceMenus.add(new MenuItem("Sexe", "/paie/pages/admin/references/sexe/list.xhtml", "fa-solid fa-genderless"));
        referenceMenus.add(new MenuItem("Départements", "/paie/pages/admin/references/department/list.xhtml", "fa-solid fa-users-viewfinder"));
        referenceMenus.add(new MenuItem("Années", "/paie/pages/admin/references/annees/list.xhtml", "fa-regular fa-calendar"));

        paiMenus.add(new MenuItem("Promesses", "/paie/pages/admin/pay/promised/list.xhtml", "fa-solid fa-handshake-slash"));
        paiMenus.add(new MenuItem("Paiements", "/paie/pages/admin/pay/payment/list.xhtml", "fa-solid fa-money-bill-transfer"));
        paiMenus.add(new MenuItem("Sommes payés", "/paie/pages/admin/pay/sum-pay/list.xhtml", "fa-solid fa-circle-dollar-to-slot"));

        menuCategories.add(new MenuCategory("Administration", administrationMenus));
        menuCategories.add(new MenuCategory("References", referenceMenus));
        menuCategories.add(new MenuCategory("Paiements", paiMenus));

        for (MenuCategory category : menuCategories) {
            for (MenuItem menuItem : category.getMenuItems()) {
                menuItem.setParent(category);
                if (menuItem.getUrl() != null) {
                    menuItems.add(menuItem);
                }
                if (menuItem.getMenuItems() != null) {
                    for (MenuItem item : menuItem.getMenuItems()) {
                        item.setParent(menuItem);
                        if (item.getUrl() != null) {
                            menuItems.add(item);
                        }
                    }
                }
            }
        }
    }

    public List<MenuItem> completeMenuItem(String query) {
        String queryLowerCase = query.toLowerCase();
        List<MenuItem> filteredItems = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.getUrl() != null
                    && (item.getLabel().toLowerCase().contains(queryLowerCase) || anyParentContainsQuery(item, queryLowerCase))) {
                filteredItems.add(item);
            } else if (item.getBadge() != null) {
                if (item.getBadge().toLowerCase().contains(queryLowerCase)) {
                    filteredItems.add(item);
                }
            }
        }
        filteredItems.sort(Comparator.comparing(m -> m.getParent().getLabel()));
        return filteredItems;
    }

    protected boolean anyParentContainsQuery(MenuItem item, String query) {
        MenuItem parent = item.getParent();
        while (parent != null) {
            if (parent.getLabel().toLowerCase().contains(query)) {
                return true;
            }
            parent = parent.getParent();
        }

        return false;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public List<MenuCategory> getMenuCategories() {
        return menuCategories;
    }
}
