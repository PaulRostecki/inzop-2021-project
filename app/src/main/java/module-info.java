module USOS
{
    requires javafx.controls;
    requires javafx.fxml;

    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;
    requires org.apache.commons.lang3;

    requires java.persistence;
    requires java.naming;
    requires org.hibernate.orm.core;

    requires java.sql;
    requires net.bytebuddy;
    requires java.xml;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    requires com.fasterxml.classmate;

    opens panel to javafx.fxml;
    exports panel;

    opens model.model to java.base, org.hibernate.orm.core;
    exports model.model;

    opens model.extensions to java.base, org.hibernate.orm.core;
    exports model.extensions;

    opens init to javafx.fxml, javafx.graphics;
    exports init;

    opens constant;

    opens factory;
    exports model.orm;
    opens model.orm to java.base, org.hibernate.orm.core;
}
