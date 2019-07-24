package Demo.DAO

import Demo.dbc.DatabaseConnection
import Demo.vo.Friend
import java.lang.Exception

class FriendDAOProxy:IFriendDAO{

    private var dbc:DatabaseConnection?=null
    private var dao:IFriendDAO?=null
    init {
        try {
            this.dbc= DatabaseConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8","root","1234")
        }catch (e:Exception){
            e.printStackTrace()
        }
        this.dao=FriendDAOImpl(this.dbc!!.conn!!)
    }

    override fun find(id: Int): Friend? {
        var friend:Friend?=null
        try {
            friend=this.dao!!.find(id)
        }
        catch(e:Exception){
            e.printStackTrace()
        }
        finally {
            this.dbc!!.close()
        }
        return friend
    }

}