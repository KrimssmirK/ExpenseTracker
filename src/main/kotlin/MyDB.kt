import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

class SQLiteDatabase(url_param: String = "jdbc:sqlite:ExpenseTracker.db") {
    val connection: Connection = DriverManager.getConnection(url_param)
    val statement: Statement = connection.createStatement()
    var resultSet: ResultSet? = null


    // this ensures the table exists
    init {
        val createTableSQL = """
        CREATE TABLE IF NOT EXISTS balance (
            date TEXT,
            amount INTEGER
        );
        """.trimIndent()

        statement.executeUpdate(createTableSQL)
    }

    fun retrieve() : Balance {
        val querySQL = "SELECT * FROM balance ORDER BY date DESC;"
        resultSet = statement.executeQuery(querySQL)

        // debugging
//        while (resultSet?.next() == true) {
//            val amount = resultSet?.getInt("amount")
//            val date = resultSet?.getString("date")
//            println("date: $date")
//            println("Amount: $amount")
//        }
        resultSet?.next()
        val amount = resultSet?.getInt("amount")
        return Balance(amount)
    }

    fun update(amount: Int) : Unit {
        val insertSQL = "INSERT INTO balance VALUES (datetime(), $amount);"
        statement.executeUpdate(insertSQL)
    }

    // close resources
    fun close() : Unit {
        resultSet?.close()
        statement.close()
        connection.close()
    }

    // Attributes
    // 1. url of db
    // 2. ResultSet
    // 3. Statement
    // 4. Connection

    // Operations
    // 1. retrieve
    // 2. update
    // 3. close

    // Question?
    // Can be the attributes of the class declared not in the primary constructor??
    // how to create abstract class??
    // what are the other data types in sqlite??

}





