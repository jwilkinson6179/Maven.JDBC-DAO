package daos;

import java.util.List;

public interface MyDao<T>
{
    public T findById(Integer id);

    public List findAll();

    public T update(T dto);

    public T create(T dto);

    public void delete(Integer id);

}
