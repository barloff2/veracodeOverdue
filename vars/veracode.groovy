import groovy.sql.Sql
import static java.sql.ResultSet.*

void call() {
    def db = Database(
        connectionString: 'jdbc:sqlserver://172.17.0.3:1433;databaseName=test_stiven;user=sa;password=Der3480*',
        driverName: 'com.microsoft.sqlserver.jdbc.SQLServerDriver'
    )
    def result = db.read([
        sql: 'SELECT * FROM usuario',
        returnRows: 10
    ])

    /*String query = "SELECT * FROM usuario"
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
    String url = "jdbc:sqlserver://172.17.0.3:1433"
    def connectionString = "jdbc:sqlserver://172.17.0.3:1433;databaseName=test_stiven;user=sa;password=Der3480*"
    def sql = Sql.newInstance(url, username, password, driver)
    def result = sql.rows(query)*/
}
