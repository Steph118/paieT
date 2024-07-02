/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Contributor;

/**
 * @author steph18
 */
public class ContributorDao extends RepositoryDao<Contributor, Integer> {

    public ContributorDao(Class<Contributor> entityClass) {
        super(entityClass);
    }

}
