 import groovy.sql.Sql
 import static java.sql.ResultSet.*

def db = [
  url: 'jdbc:sqlserver://172.17.0.3:1433;databaseName=test_stiven;user=sa;password=Der3480*',
  user: 'sa',
  password: 'Der3480*',
  driver: 'com.microsoft.sqlserver.jdbc.SQLServerDriver'
]
def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)
sql.execute 'SELECT * FROM usuario'