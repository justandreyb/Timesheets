module service {
    requires java.naming;
    requires org.slf4j;
    requires spring.core;
    requires spring.beans;
    requires spring.orm;
    requires spring.context;
    requires spring.tx;
    requires org.hibernate.orm.core;

    requires model;

    exports com.justandreyb.timesheets.server.service;
    exports com.justandreyb.timesheets.server.service.config;
}
