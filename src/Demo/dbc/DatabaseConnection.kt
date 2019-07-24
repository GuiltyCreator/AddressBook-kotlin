package Demo.dbc

import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager

class DatabaseConnection{
    var conn:Connection?=null

    constructor(dbURL:String,username:String,password:String){
        try {
            Class.forName("com.mysql.jdbc.Driver")
            println("驱动加载")
            this.conn=DriverManager.getConnection(dbURL,username,password)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
        fun close(){

            if(this.conn!=null){
                try{
                    this.conn!!.close()
                }
                catch (e:Exception){e.printStackTrace()}
            }
        }

}