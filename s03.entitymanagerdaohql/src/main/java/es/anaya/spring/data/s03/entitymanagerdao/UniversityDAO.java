package es.anaya.spring.data.s03.entitymanagerdao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UniversityDAO {
 @PersistenceContext
 private EntityManager entityManager;

 public University findById(Long universityId) {
  String hql = "select u from University u where u.id = :id";
  return (University) entityManager
    .createQuery(hql)
    .setParameter("id", universityId)
    .getSingleResult();
 }

 public List<University> findByName(String name) {
  String hql = "select u from University u where u.name like :name";
  return (List<University>) entityManager
    .createQuery(hql)
    .setParameter("name", "%"+ name +"%")
    .getResultList();

 }
 
 public List<University> findAll() {
  String hql = "FROM University as u ORDER BY u.id";
  return (List<University>) entityManager.createQuery(hql).getResultList();
 }


 public List<University> search(String name, Integer year) {
  String hql = "FROM University as u WHERE u.name = ? and u.year = ?";
  return (List<University>) entityManager
    .createQuery(hql)
    .setParameter(1, name)
    .setParameter(2, year)
    .getResultList();
 }
 
 public void add(University university) {
  entityManager.persist(university);
  entityManager.flush();
 }

 public void update(University university) {
  entityManager.persist(university);
  entityManager.flush();
 }

 public void delete(University university) {
  entityManager.remove(university);
 }
}