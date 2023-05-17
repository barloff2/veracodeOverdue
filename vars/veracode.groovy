import groovy.sql.Sql
import static java.sql.ResultSet.*
import java.sql.DriverManager

void call() {
    withCredentials([usernamePassword(credentialsId: 'DatabaseVeracode', passwordVariable: 'SQLSERVER_PWD', usernameVariable: 'SQLSERVER_USER')]) {
        sh(script:"""
            export PATH=\$PATH:/opt/mssql-tools/bin
            sqlcmd -S 172.17.0.2 -d test_stiven -U ${SQLSERVER_USER} -P ${SQLSERVER_PWD} -Q \"SELECT * FROM usuario;\" -o ./output.txt
            cat ./output.txt
        """)
    }

    /*String query = "SELECT * FROM usuario"
    //def driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
    String username =  'sa'
    String password = 'Der3480*'
    String url = "jdbc:sqlserver://172.17.0.2:1433;databaseName=test_stiven;TrustServerCertificate=true"
    //String cert = "TrustServerCertificate=true"
    Conection con = null
    def classLoader = this.class.classLoader
    while (classLoader.parent) {
        classLoader = classLoader.parent
        if (classLoader.getClass() == java.net.URLClassLoader) {
            classLoader.addURL(new File("${JDBC_SQLSERVER}").toURI().toURL())
            break;
        }
    }
    
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
    con = DriverManager.getConnection(url, username, password)
    stmt = con.createStatment()
    
    /*def sql = Sql.newInstance(url, username, password, driver)

    def result = sql.rows(query)

    sql.close()*/
}
