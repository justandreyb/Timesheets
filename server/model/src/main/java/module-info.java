module model {
    requires java.persistence;

    requires org.hibernate.commons.annotations;
    requires org.hibernate.orm.core;

    exports com.justandreyb.timesheets.server.model.user;
    exports com.justandreyb.timesheets.server.model;
}
