/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.common;

import com.zaxxer.hikari.HikariDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author S2028398
 */
public class DatasourceUtility {

    public static javax.sql.DataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setInitializationFailTimeout(0);
        dataSource.setMaximumPoolSize(5);

        dataSource.setDataSourceClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
        dataSource.addDataSourceProperty("url", "jdbc:sqlserver://LPTAXN73\\SQLEXPRESS14;databaseName=school_DB");
        dataSource.addDataSourceProperty("user", "terry");
        dataSource.addDataSourceProperty("password", "Passwords.");

        return dataSource;
    }

    public static javax.sql.DataSource getDataSourceLookup() {
        try {
            InitialContext initialContext = new InitialContext();
            javax.sql.DataSource dataSource = (javax.sql.DataSource) initialContext.lookup("java:/schoolDS");
            return dataSource;

        } catch (NamingException ex) {
            Logger.getLogger(DatasourceUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
