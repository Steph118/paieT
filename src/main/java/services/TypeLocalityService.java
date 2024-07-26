/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import dao.TypeLocalityDao;
import entities.TypeLocality;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import service.interfaces.TypeLocalityServiceLocal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author steph18
 */
@Stateless
public class TypeLocalityService extends GenericServiceLocalImpl<TypeLocality, Integer> implements TypeLocalityServiceLocal {

    @EJB
    private TypeLocalityDao dao;

    @Override
    protected RepositoryDao<TypeLocality, Integer> getDAO() {
        return dao;
    }

    @Override
    public List<TypeLocality> getAll(Integer id) {
        return dao.getAll(id);
    }

    @Override
    public List<TypeLocality> getBrothers(TypeLocality typeLocality) {
        if (Objects.nonNull(typeLocality.getTypeLocalityParent())) {
            return dao.getBrothers(typeLocality.getId(), typeLocality.getTypeLocalityParent().getId());
        }
        return new ArrayList<>();
    }

    @Override
    public List<TypeLocality> getAscendants(TypeLocality typeLocality) {
        List<TypeLocality> ascendants = new ArrayList<>();
        TypeLocality parent = typeLocality.getTypeLocalityParent();
        if (Objects.nonNull(parent)) {
            ascendants.add(parent);
            while (Objects.nonNull(parent.getTypeLocalityParent())) {
                ascendants.add(parent.getTypeLocalityParent());
                parent = parent.getTypeLocalityParent();
            }
        }
        return ascendants;
    }

    @Override
    public List<TypeLocality> getAscendantsAndBrothers(TypeLocality typeLocality) {
        List<TypeLocality> ascendants = new ArrayList<>();
        ascendants.addAll(this.getBrothers(typeLocality));
        ascendants.addAll(this.getAscendants(typeLocality));
        return ascendants;
    }

    @Override
    public List<TypeLocality> getOthersRoots(TypeLocality typeLocality) {
        return dao.getOthersRoots(typeLocality.getId());
    }

    @Override
    public List<TypeLocality> getRoots() {
        return dao.getRoots();
    }

    @Override
    public List<TypeLocality> getAppropriateTypesLoclity(TypeLocality entity, Integer entityId) {
        if (entity.isRoot()) {
            return entity.getChildreen().isEmpty() ? dao.getAll(entityId) : dao.getOthersRoots(entityId);
        } else {
            return entity.getChildreen().isEmpty() ? dao.getAll(entityId) : this.getAscendantsAndBrothers(entity);
        }

    }

    @Override
    public List<TypeLocality> getDescendants(TypeLocality typeLocality) {
        List<TypeLocality> childreen = new ArrayList<>();
        getDescendants2(typeLocality, childreen);
        return childreen;
    }

    private void getDescendants2(TypeLocality typeLocality, List<TypeLocality> childreen) {
        if (!typeLocality.getChildreen().isEmpty()) {
            for (TypeLocality child : typeLocality.getChildreen()) {
                childreen.add(child);
                getDescendants2(child, childreen);
            }
        }
    }

}
