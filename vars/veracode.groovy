import groovy.sql.Sql
import static java.sql.ResultSet.*

void call() {
    def db = database(
        connectionString: 'jdbc:sqlserver://172.17.0.3:1433;;databaseName=test_stiven;user=sa;password=Der3480*',
        driverName: 'com.microsoft.sqlserver.jdbc.SQLServerDriver'
    )
    def result = db.read([
        sql: 'SELECT * FROM usuario',
        returnRows: 10
    ])
}
