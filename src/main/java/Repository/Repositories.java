package Repository;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Transient;
import jakarta.persistence.TypedQuery;
import DAO.DAO;
import jakarta.transaction.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Repositories {

    @Inject
    EntityManager entityManager;

    public List<Object> layDanhSach(String query, String requestObjectName, Integer trang, Integer soDong, String filter)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        trang = (trang==null) ? 0:trang;
        soDong = (soDong==null) ? 20:soDong;
        filter = (filter==null) ? "true":filter;

        query = query.replace("?filter", filter);

        List<Object> resultList = new ArrayList<>();
        TypedQuery<Object[]> q = entityManager.createQuery(query, Object[].class);
        q.setFirstResult(trang*soDong);
        q.setMaxResults(soDong);
        List<Object[]> queryList = q.getResultList();

        for(Object[] i : queryList) {
            resultList.add(Class.forName(requestObjectName).getConstructor(List.class).newInstance(Arrays.asList(i)));
        }

        return resultList;
    }

    public Object layChiTiet(String query, String requestObjectName, Long id)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        query = query.replace("?id", String.valueOf(id));
        TypedQuery<Object[]> q = entityManager.createQuery(query, Object[].class);

        Object[] result = q.getSingleResult();
        return Class.forName(requestObjectName).getConstructor(List.class).newInstance(Arrays.asList(result));
    }

    @Transactional
    public void them(DAO dao) {
        dao.persistAndFlush();
    }

    @Transactional
    public int xoa(String query, Long id) {

        query = query.replace("?id", String.valueOf(id));
        return entityManager.createQuery(query).executeUpdate();
    }

}
