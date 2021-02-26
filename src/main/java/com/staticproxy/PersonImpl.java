package com.staticproxy;

public class PersonImpl implements PersonDao {
    @Override
    public void savePerson() {
        System.out.println("保存个人信息");
    }
}
