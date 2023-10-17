package Request;

import DAO.DAO;
import jakarta.ws.rs.core.Response;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Request {

    public List<DAO> extract(List<Class<? extends DAO>> extractTo, Class<? extends Request> extractFrom)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
    {
            List<DAO> result = new ArrayList<>();
            for (Class<? extends DAO> i : extractTo) {
                    DAO dao = i.getConstructor().newInstance();
                for (Field j : i.getDeclaredFields()) {
                    try {
                        dao.set(j.getName(), extractFrom.getDeclaredField(j.getName()).get(this));
                    } catch (ReflectiveOperationException ignored) {    }
                }
                result.add(dao);
            }
            return result;
    }
}
