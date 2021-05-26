package efs.task.todoapp.repository;

import efs.task.todoapp.Base64Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UserRepository implements Repository<String, UserEntity> {
    List<UserEntity> userEntityList = new ArrayList<>();


    // dodaje nowego użytkownika
    @Override
    public String save(UserEntity userEntity) {
        String userNameEncoded = Base64Utils.encode(userEntity.getUsername());
        String passwordEncoded = Base64Utils.encode(userEntity.getPassword());
        String authEncoded = (userNameEncoded + "=:" +passwordEncoded);
        userEntityList.add(userEntity);
        return authEncoded;

    }


    @Override
    public UserEntity query(String s) {
        return null;
    }
    // brak - 404
    @Override
    public List<UserEntity> query(Predicate<UserEntity> condition) {
        return null;
    }

    // brak - 404
    @Override
    public UserEntity update(String s, UserEntity userEntity) {
        return null;
    }

    // brak - 404
    @Override
    public boolean delete(String s) {
        return false;
    }
}
