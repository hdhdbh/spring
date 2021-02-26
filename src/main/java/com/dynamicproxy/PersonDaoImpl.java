package com.dynamicproxy;

public class PersonDaoImpl implements PersonDao {
    @Override
    public void savePerson() {
        System.out.println("保存个人信息");
    }

    @Override
    public void updatePerson() {
        System.out.println("修改个人信息");
    }
}
