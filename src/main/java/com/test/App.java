package com.test;

import com.test.model.Customer;
import com.test.model.PojoClass;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.BitSet;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Configuration config = configureConfiguration();

        try (SessionFactory sessionFactory = config.buildSessionFactory()) {
            //save
            sessionFactory.inTransaction(session -> {
                Customer customer = new Customer("Alex")
                        .setJson(new PojoClass("Data", 123, new Date()))
                        .setXml(Map.of("Kye1", "Value1", "Key2", "Value2"))
                        .setZoneOffset(ZoneOffset.UTC)
                        .setBitSetAttr(BitSet.valueOf(new long[] {1, 0, 0, 1}))
                        .setZonedDateTime(ZonedDateTime.now())
                        .setOffsetDateTime(OffsetDateTime.now())
                        .setNumericBoolean(true)
                        .setTrueFalseBool(true)
                        .setYesNoBool(true)
                        .setSimpleBool(true);
                session.persist(customer);
                session.flush();
            });


            //find
            sessionFactory.inTransaction(session -> {
                List<Customer> allCustomers = session.createQuery("select c from Customer c", Customer.class).getResultList();
                System.out.println(allCustomers.stream().map(Customer::toString).collect(Collectors.joining(", ")));
            });
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    private static Configuration configureConfiguration() {
        Configuration config = new Configuration();
        config.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost/empty_db");
        config.setProperty("hibernate.connection.username", "cuba");
        config.setProperty("hibernate.connection.password", "cuba");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        config.setProperty("hibernate.hbm2ddl.auto", "create");
        config.setProperty("hibernate.format_sql", "true");
        config.setProperty("hibernate.show_sql", "true");
        config.setProperty("hibernate.type.json_format_mapper", "org.hibernate.type.JacksonJsonFormatMapper");

        config.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        config.addAnnotatedClass(Customer.class);
        return config;
    }

}
