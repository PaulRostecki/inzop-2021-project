import org.ini4j.Ini;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;


/**
 * Database connection tests
 *
 * @author created: Mikołaj Mumot on 14.01.2022
 * @author last changed:
 */

public class DatabaseTest {
    static private Connection con;

    @BeforeAll
    static void setUp() {
        try {
            Ini ini = new Ini(new File(DatabaseTest.class.getResource("config.ini").getFile()));

            String url =
                    "jdbc:" + ini.get("PostgreSQL", "driver") + "://"
                            + ini.get("PostgreSQL", "host") + ":"
                            + ini.get("PostgreSQL", "port") +"/"
                            + ini.get("PostgreSQL", "db") ;
            con = DriverManager.getConnection(url, ini.get("PostgreSQL", "user"),
                    ini.get("PostgreSQL", "pass"));

        } catch (IOException | SQLException e) {
            fail("Nie uzyskano połączenia z bazą danych");
        }
    }

    @AfterAll
    static void disconnect() {
        try {
            con.close();
        } catch (SQLException e) {
            fail("Nie udało się zamknąć połączenia z bazą");
        }
    }

    @Test
    void test1() {
        assertNotNull(con);
    }

}
