package com.hipet.hipetspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class HipetSpringbootApplicationTests {
    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    // A Test on can we connect mysql.
    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

}
