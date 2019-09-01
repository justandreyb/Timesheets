module core {
    requires java.sql;
    requires org.slf4j;
    requires spring.core;
    requires spring.beans;
    requires spring.orm;
    requires spring.context;
    requires com.zaxxer.hikari;
    requires org.hibernate.orm.core;

    requires model;

    opens com.justandreyb.timesheets.server.config;
}
