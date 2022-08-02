package com.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.model.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Configuration config = configureConfiguration();

        try (SessionFactory sessionFactory = config.buildSessionFactory()) {
            //save
            sessionFactory.inTransaction(session -> {
                PojoClass pojoExample = new PojoClass("Data", 123, new Date());

                Customer customer = new Customer("Alex")
                        .setJson(pojoExample)
                        .setXml(Map.of("Kye1", "Value1", "Key2", "Value2"))
                        .setZoneOffset(ZoneOffset.UTC)
                        .setBitSetAttr(BitSet.valueOf(new long[] {1, 0, 0, 1}))
                        .setZonedDateTime(ZonedDateTime.now())
                        .setOffsetDateTime(OffsetDateTime.now())
                        .setNumericBoolean(true)
                        .setTrueFalseBool(true)
                        .setYesNoBool(true)
                        .setSimpleBool(true)
                        .setXml(Map.of("Key1", "Value1", "Key2", "Value2"));
                session.persist(customer);

                session.persist(new JdbcTypeEntity());

                Map<String, String> mapJson = new LinkedHashMap<>();
                mapJson.put("Abc", "1");
                ObjectMapper mapper = new ObjectMapper();
                session.persist(new JsonEntity()
                        .setJsonStr("Hello World")
                        .setJsonCollection(Arrays.asList("Abc", "1"))
                        .setJsonMap(mapJson)
                        .setJsonNode(mapper.valueToTree(pojoExample))
                        .setJsonPojo(pojoExample)
                        .setJsonPojoCollection(Set.of(pojoExample)));

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

        config.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost/empty_db");
        config.setProperty("hibernate.connection.username", "cuba");
        config.setProperty("hibernate.connection.password", "cuba");
        config.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

//        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/jpab_test");
//        config.setProperty("hibernate.connection.username", "root");
//        config.setProperty("hibernate.connection.password", "root");
//        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

//        config.setProperty("hibernate.connection.url", "jdbc:sqlserver://localhost;databaseName=jpab_test");
//        config.setProperty("hibernate.connection.username", "sa");
//        config.setProperty("hibernate.connection.password", "saPass");
//        config.setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");

//        config.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521/orcl");
//        config.setProperty("hibernate.connection.username", "jpab_test");
//        config.setProperty("hibernate.connection.password", "jpab_test");
//        config.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");

//        config.setProperty("hibernate.connection.url", "jdbc:db2://localhost:50001/testdb:currentSchema=JPAB_TEST;");
//        config.setProperty("hibernate.connection.username", "root");
//        config.setProperty("hibernate.connection.password", "root");

//        config.setProperty("hibernate.connection.url", "jdbc:hsqldb:file:~/petclinic/db;shutdown=true");
//        config.setProperty("hibernate.connection.username", "sa");
//        config.setProperty("hibernate.connection.password", "");

//        config.setProperty("hibernate.connection.url", "jdbc:h2:file:./.amplicode/h2/petclinic");
//        config.setProperty("hibernate.connection.username", "sa");
//        config.setProperty("hibernate.connection.password", "");
//        config.setProperty("hibernate.connection.driver_class", "org.h2.Driver");

        config.setProperty("hibernate.hbm2ddl.auto", "create");
        config.setProperty("hibernate.format_sql", "true");
        config.setProperty("hibernate.show_sql", "true");
        config.setProperty("hibernate.type.json_format_mapper", "org.hibernate.type.JacksonJsonFormatMapper");

        config.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        config.addAnnotatedClass(Customer.class);
        config.addAnnotatedClass(JdbcTypeEntity.class);
        config.addAnnotatedClass(JsonEntity.class);
        return config;
    }

}
