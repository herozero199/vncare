package predicate;

import CustomAnnotation.*;
import DAO.org_officer;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import oracle.jdbc.proxy.annotation.Pre;
import repository.Repo;
import search.SearchCriteria;
import search.SearchOperation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DanhSach {

    CriteriaBuilder builder;
    Predicate predicate;

    public DanhSach(CriteriaBuilder builder, Predicate predicate) {
        this.builder = builder;
        this.predicate = predicate;
    }
    public DanhSach() {}

    public Predicate getPredicateKhoa_Phong(List<SearchCriteria> searchCriteriaList, Root<?> root, String org_level) {
        searchCriteriaList.stream()
                .filter(searchCriteria -> !searchCriteria.key.equals("trang") && !searchCriteria.key.equals("sodong") && searchCriteria.value!=null)
                .forEach(searchCriteria -> {
                    if(searchCriteria.value instanceof String)
                        this.predicate = this.builder.and(predicate, builder.like(root.get(searchCriteria.key), "%"+searchCriteria.value+"%"));
                    else
                        this.predicate = this.builder.and(predicate, builder.equal(root.get(searchCriteria.key), searchCriteria.value));
                });
        predicate = builder.and(predicate, builder.equal(root.get("org_level"), org_level));

        return this.predicate;
    }

    public Predicate getPredicateNhanVien (List<SearchCriteria> searchCriteriaList, Root<org_officer> root) {
        searchCriteriaList.stream()
                .filter(searchCriteria -> !searchCriteria.key.equals("trang") && !searchCriteria.key.equals("sodong") && searchCriteria.value!=null)
                .forEach(searchCriteria -> {
                    if(searchCriteria.value instanceof String)
                        this.predicate = this.builder.and(predicate, builder.like(root.get(searchCriteria.key), "%"+searchCriteria.value+"%"));
                    else
                        this.predicate = this.builder.and(predicate, builder.equal(root.get(searchCriteria.key), searchCriteria.value));
                });
        predicate = builder.and(predicate, builder.equal(root.get("status"), 1));
        return predicate;
    }


    public static Predicate get(List<? extends PanacheEntityBase> repos, CriteriaBuilder builder, List<Root<?>> roots,
                                List<SearchCriteria> searchCriteriaList, String name) {

        Predicate whereClause = builder.conjunction();

        // Xét từng đối tượng
        for(int i=0; i<repos.size(); ++i) {

            // Lấy tất cả các thuộc tính của đối tượng
            Field[] fields = repos.get(i).getClass().getDeclaredFields();
            for(Field f : fields) {

                // Lấy tất cả các annotation Where của thuộc tính f
                Where[] a = Arrays.stream(f.getAnnotationsByType(Wheres.class).getClass().getAnnotationsByType(Where.class))
                                             .filter(annotation -> annotation.name().equals(name)).toList().toArray(new Where[0]);

                // Tùy thuộc vào giá trị connector của annotation thì toán tử sẽ có giá trị khác nhau
                for(Where w : a) {

                    // Nếu connector có giá trị là "&" thì tương đương với toán tử AND
                    if(Objects.equals(w.connector(), "&"))
                        whereClause = builder.and(whereClause, builder.equal(roots.get(i).get(f.getName()) , getValue(f, w.value())));
                    // Nếu connector có giá trị là "&" thì tương đương với toán tử OR
                    else if(Objects.equals(w.connector(), "|"))
                        whereClause = builder.or(whereClause, builder.equal(roots.get(i).get(f.getName()) , getValue(f, w.value())));
                };
            }

            // Xét từng điều kiện lọc
            for(SearchCriteria searchCriteria : searchCriteriaList)
            {
                // Không xét điều kiện liên quan tới trang và số dòng
                if(searchCriteria.key.equals("trang") || searchCriteria.key.equals("sodong"))
                    continue;

                if(roots.get(i).get(searchCriteria.key).getJavaType() == String.class)
                    whereClause = builder.and(whereClause, builder.like(roots.get(i).get(searchCriteria.key), "%" + searchCriteria.value + "%"));
                else
                    whereClause = builder.and(whereClause, builder.equal(roots.get(i).get(searchCriteria.key), searchCriteria.value));
            };

        }

        return whereClause;
    }

    private static Object getValue(Field f, String value) {

        if(f.getType() == Integer.class)
            return Integer.parseInt(value);
        else if (f.getType() == Long.class)
            return Long.parseLong(value);
        else if(f.getType() == Double.class)
            return Double.parseDouble(value);

        return value;
    }

}
