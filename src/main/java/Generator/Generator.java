package Generator;

import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOrganization;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import Request.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Generator {

    private Map<String, Object> requestField = new HashMap<>();
    private List<PanacheEntityBase> DAOs;

    public Generator(List<PanacheEntityBase> DAOs, Request requestObject) throws IllegalAccessException {

        this.DAOs = DAOs;

        Field[] fieldList = requestObject.getClass().getDeclaredFields();
        for (Field f :fieldList) {
            f.setAccessible(true);
            this.requestField.put(f.getName(), f.get(requestObject));
        }
    }

    public List<PanacheEntityBase> generate() {

        for(PanacheEntityBase DAO : this.DAOs) {
            this.requestField.forEach((key, value) -> {
                try {
                    Field f = DAO.getClass().getDeclaredField(key);
                    f.setAccessible(true);
                    f.set(DAO, value);
                } catch (NoSuchFieldException | IllegalAccessException ignored) {
                    System.out.println(OrgOrganization.class+", key: "+key+", "+"value: "+value);
                }
            });
        }
        return this.DAOs;
    }

}
