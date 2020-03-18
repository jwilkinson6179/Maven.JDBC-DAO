package daos;

import java.util.List;

public interface MyDao<T>
{
    public T findById(Integer id);

    public List findAll();

    public void update(T dto);

    public T create(T dto);

    public void delete(Integer id);

}
