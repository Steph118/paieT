/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.PermissionCategory;
import jakarta.transaction.Transactional;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author steph18
 */
@Transactional
public class PermissionCategoryDao extends RepositoryDao<PermissionCategory, Long> {

    public PermissionCategoryDao() {
        super(PermissionCategory.class);
    }

    public Map<String, PermissionCategory> getExistingCategoriesPermissions() {
        return em.createQuery(
                        "SELECT DISTINCT c FROM PermissionCategory c LEFT JOIN FETCH c.permissions",
                        PermissionCategory.class)
                .getResultStream()
                .collect(Collectors.toMap(PermissionCategory::getCode, c -> c));
    }

}
