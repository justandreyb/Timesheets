module database {
    requires java.sql;
    requires spring.core;
    requires spring.beans;
    requires spring.context;
    requires spring.orm;
    requires spring.jdbc;
    requires spring.tx;
    requires com.zaxxer.hikari;
    requires org.hibernate.orm.core;
    requires java.persistence;

    requires model;

    opens com.justandreyb.timesheets.server.database.config;

    exports com.justandreyb.timesheets.server.database.config;
}
