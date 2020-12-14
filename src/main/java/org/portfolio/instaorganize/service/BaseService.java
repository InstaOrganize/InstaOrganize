package org.portfolio.instaorganize.service;

import java.util.List;
import java.util.UUID;

public abstract class BaseService<T> {
    public abstract List<T> getAll();
    public abstract T get(UUID id);
    public abstract void create(T t);
    public abstract void update(T t);
    public abstract void delete(T t);
}
