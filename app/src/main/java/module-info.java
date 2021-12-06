module USOS
{
    requires javafx.controls;
    requires javafx.fxml;

    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;

    requires org.apache.commons.lang3;

    opens panel to javafx.fxml;
    exports panel;

    opens init to javafx.fxml, javafx.graphics;
    exports init;

    opens constant;

    opens util;

}