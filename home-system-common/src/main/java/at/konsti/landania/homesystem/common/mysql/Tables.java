package at.konsti.landania.homesystem.common.mysql;

public class Tables {

    public static void create() {

        Connection.onUpdate("CREATE TABLE IF NOT EXISTS homes(UUID TEXT, name TEXT, world TEXT, x INTEGER(100), y INTEGER(100), z INTEGER(100))");

    }

}
