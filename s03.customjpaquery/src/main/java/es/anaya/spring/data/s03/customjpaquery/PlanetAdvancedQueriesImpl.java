package es.anaya.spring.data.s03.customjpaquery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PlanetAdvancedQueriesImpl implements PlanetAdvancedQueries {
  @PersistenceContext
  private EntityManager em;

  @Override
  public Long countPlanets(Integer moonNumber) {
    String hql = "select count(*) from Planet p where size(p.moons) > 3";
    return (Long)em.createQuery(hql).getResultList().get(0);
  }

}
