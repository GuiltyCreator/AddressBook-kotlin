package Demo.db.DAO

import Demo.db.dbc.DatabaseConnection
import Demo.db.vo.Friend
import java.lang.Exception

/**
 * 代理实现类，主要完成数据库的打开和关闭并且调用真实实现类对象的操作；
 *
 */
class FriendDAOProxy:IFriendDAO{
    override fun findAll(): List<Friend> {
        var friends:List<Friend> = listOf()
        try {
            friends=this.dao!!.findAll()
        }
        catch(e:Exception){
            e.printStackTrace()
        }
        finally {
            this.dbc!!.close()
        }
        return friends
    }

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