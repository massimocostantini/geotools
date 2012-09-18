/*
 *  GeoBatch - Open Source geospatial batch processing system
 *  https://github.com/nfms4redd/nfms-geobatch
 *  Copyright (C) 2007-2012 GeoSolutions S.A.S.
 *  http://www.geo-solutions.it
 *
 *  GPLv3 + Classpath exception
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.geotools.data.sqlserver;

import org.geotools.jdbc.JDBCDataStore;
import org.geotools.jdbc.JDBCGeometryTestSetup;

/**
 * @author DamianoG
 * 
 */
public class SQLServerGeometryTestSetup extends JDBCGeometryTestSetup {

    protected SQLServerGeometryTestSetup() {
        super(new SQLServerTestSetup());
    }

    public void setUp() throws Exception {
        super.setUp();
        runSafe("DROP TABLE GEOMETRY_COLUMNS");
<<<<<<< HEAD
        runSafe("DROP TABLE gtmeta");
=======
>>>>>>> 8dabe817fc37f968ea1dff771a8a2c148994927a

        // create the geometry columns
        run("CREATE TABLE GEOMETRY_COLUMNS(" + "F_TABLE_SCHEMA VARCHAR(30) NOT NULL,"
                + "F_TABLE_NAME VARCHAR(30) NOT NULL," + "F_GEOMETRY_COLUMN VARCHAR(30) NOT NULL,"
                + "COORD_DIMENSION INTEGER," + "SRID INTEGER NOT NULL,"
                + "TYPE VARCHAR(30) NOT NULL," + ");");

<<<<<<< HEAD
        String sql = "CREATE TABLE gtmeta (" 
                + "id int IDENTITY(0,1) PRIMARY KEY, geom geometry, intProperty int , "
                + "doubleProperty float, stringProperty varchar(255))";
        run(sql);
        
        sql = "CREATE SPATIAL INDEX _gtmeta_geom_index on gtmeta(geom) WITH (BOUNDING_BOX = (-10, -10, 10, 10))"; 
        run(sql);
        
        sql = "INSERT INTO GEOMETRY_COLUMNS (F_TABLE_SCHEMA, F_TABLE_NAME, F_GEOMETRY_COLUMN, COORD_DIMENSION, SRID, TYPE) " + 
                "VALUES ('', 'gtmeta','geom', 2, 4326, 'POINT')";
        run(sql);
=======
>>>>>>> 8dabe817fc37f968ea1dff771a8a2c148994927a
    }

    @Override
    protected void dropSpatialTable(String tableName) throws Exception {
        runSafe("DELETE FROM GEOMETRY_COLUMNS WHERE F_TABLE_NAME = '" + tableName + "'");
        runSafe("DROP TABLE " + tableName);
    }

    public void setupMetadataTable(JDBCDataStore dataStore) {
        ((SQLServerDialect) dataStore.getSQLDialect()).setGeometryMetadataTable("GEOMETRY_COLUMNS");
<<<<<<< HEAD
=======

>>>>>>> 8dabe817fc37f968ea1dff771a8a2c148994927a
    }

}
