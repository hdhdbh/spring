package com.staticproxy;

public class Test {
    public static void main(String[] args) {
        PersonDao personDao = new PersonImpl();
        Transaction transaction = new Transaction();
        PersonDao proxy = new PersonDaoProxy(personDao, transaction);
        proxy.savePerson();
    }
}
