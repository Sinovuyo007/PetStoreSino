package za.ac.cput.service;

public interface IService<Type, ID> {
    Type create(Type type);

    Type read(ID id);

    Type update(Type type);

    boolean delete(ID id);
}