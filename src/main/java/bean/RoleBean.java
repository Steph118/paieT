package bean;

import entities.PermissionCategory;
import entities.Role;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import org.omnifaces.util.Messages;
import service.interfaces.GenericServiceLocal;
import service.interfaces.RoleServiceLocal;
import services.PermissionCategoryService;

@Named
@ViewScoped
public class RoleBean extends GenericBean<Role, Integer> {

    @Inject
    private RoleServiceLocal roleService;

    @Inject
    private PermissionCategoryService permissionCategoryService;

    //private String filterInput;
    private List<PermissionCategory> perms = new ArrayList<>();
    private List<Long> permsSelected = new ArrayList<>();

    @Override
    public GenericServiceLocal<Role, Integer> getService() {
        return roleService;
    }

    @Override
    public void initEntity() {
        super.initEntity();
        perms = permissionCategoryService.getAll();
    }

    public List<PermissionCategory> getPerms() {
        return perms;
    }

    @Override
    public void beforeUpdate() {
        System.err.println("size : " + permsSelected.size());
        beforeSave();
    }

    @Override
    public void beforeSave() {
        System.err.println("size : " + permsSelected.size());
        if (this.getEntity().getPermissions().isEmpty()) {
            Messages.addGlobalError("Veuillez selectionner au moins un role");
            throw new AbortProcessingException("Permissions is empty");
        }
    }

//    public String getFilterInput() {
//        return filterInput;
//    }
//
//    public void setFilterInput(String filterInput) {
//        this.filterInput = filterInput;
//    }
//    public List<PermissionCategory> getFilteredPerms() {
//        if (StringUtils.isEmpty(filterInput)) {
//            return perms;
//        }
//
//        String lowerFilter = filterInput.toLowerCase();
//
//        return perms.stream()
//                .map(cat -> {
//                    List<Permission> filteredPerms = cat.getPermissions().stream()
//                            .filter(p -> p.getLabel().toLowerCase().contains(lowerFilter))
//                            .collect(Collectors.toList());
//
//                    if (filteredPerms.isEmpty()) {
//                        return null;
//                    }
//
//                    PermissionCategory filteredCat = new PermissionCategory();
//                    filteredCat.setId(cat.getId());
//                    filteredCat.setCode(cat.getCode());
//                    filteredCat.setDescription(cat.getDescription());
//                    filteredCat.setLabel(cat.getLabel());
//                    filteredCat.setPermissions(filteredPerms);
//                    return filteredCat;
//                })
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList());
//    }
    public List<Long> getPermsSelected() {
        return permsSelected;
    }

    public void setPermsSelected(List<Long> permsSelected) {
        this.permsSelected = permsSelected;
    }

    @Override
    public void initAdd() {
        this.entity = new Role();
    }

    @Override
    public boolean canAdd() {
        return true;
    }

    @Override
    public boolean canDelete() {
        return true;
    }

    @Override
    public boolean canDetails() {
        return true;
    }

    @Override
    public boolean canUpdate() {
        return true;
    }
}
