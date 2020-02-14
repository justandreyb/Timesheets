module core {
    requires java.sql;
    requires org.slf4j;
    requires spring.core;
    requires spring.beans;
    requires spring.context;

    requires model;
    requires database;
    requires service;

    opens com.justandreyb.timesheets.server.config;
}
