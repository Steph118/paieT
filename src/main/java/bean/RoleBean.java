package bean;

import entities.Permission;
import entities.PermissionCategory;
import entities.Role;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.omnifaces.util.Messages;
import service.interfaces.GenericServiceLocal;
import service.interfaces.RoleServiceLocal;
import services.PermissionCategoryService;
import utils.PermsConstant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named
@ViewScoped
public class RoleBean extends GenericBean<Role, Integer> {

    @Inject
    private RoleServiceLocal roleService;

    @Inject
    private SessionBean sessionBean;

    @Inject
    private PermissionCategoryService permissionCategoryService;

    //private String filterInput;
    private List<PermissionCategory> perms = new ArrayList<>();
    private Set<Permission> permissionsSet = new HashSet<>();

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
        beforeSave();
    }

    public void valuechange(Long id) {
        System.err.println("id permission : " + id);
        permissionsSet.add(new Permission(id));
    }

    @Override
    public void beforeSave() {
        for (Permission p : permissionsSet) {
            System.err.println("p --> " + p);
        }
        this.getEntity().setPermissions(new ArrayList<>(permissionsSet));
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
    @Override
    public void initAdd() {
        this.entity = new Role();
    }

    @Override
    public boolean canAdd() {
        return sessionBean.filterPermission(
                PermsConstant.ROLE_ALL, PermsConstant.ROLE_ADD
        );
    }

    @Override
    public boolean canDelete() {
        return sessionBean.filterPermission(PermsConstant.ROLE_ALL,
                PermsConstant.ROLE_DLETE);
    }

    @Override
    public boolean canDetails() {
        return sessionBean.filterPermission(PermsConstant.ROLE_ALL,
                PermsConstant.ROLE_DETAILS);
    }

    @Override
    public boolean canUpdate() {
        return sessionBean.filterPermission(PermsConstant.ROLE_ALL,
                PermsConstant.ROLE_EDIT);
    }

    public Set<Permission> getPermissionsSet() {
        return permissionsSet;
    }

    public void setPermissionsSet(Set<Permission> permissionsSet) {
        this.permissionsSet = permissionsSet;
    }

   
}
