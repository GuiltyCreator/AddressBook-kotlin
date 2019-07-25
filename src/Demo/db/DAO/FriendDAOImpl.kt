package Demo.db.DAO

import Demo.db.vo.Friend
import java.lang.Exception
import java.sql.*

/**
 * DAO接口的真实实现类，主要完成具体数据库操作，但不负责数据库的打开和关闭；
 *
 */
class FriendDAOImpl(val conn:Connection) :IFriendDAO{

    override fun findAll(): List<Friend> {
        var friend:Friend
        var friends:MutableList<Friend> = mutableListOf()
        try {
            val sql = "select * from so_address"
            this.pstmt = this.conn.prepareStatement(sql)
            val rs: ResultSet = this.pstmt!!.executeQuery()
            while (rs.next()) {
                friend = Friend(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5))
                friends.add(friend)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        finally {
            if(this.pstmt!=null){
                try {
                    this.pstmt!!.close()
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }
        return friends
    }

    private var pstmt : PreparedStatement?=null

    override fun find(id: Int): Friend? {
        var friend:Friend?=null
        try {
            val sql = "select * from so_address where id=?"
            this.pstmt = this.conn.prepareStatement(sql)
            this.pstmt?.setInt(1, id)
            val rs: ResultSet = this.pstmt!!.executeQuery()
            while (rs.next()) {
                friend = Friend(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        finally {
            if(this.pstmt!=null){
                try {
                    this.pstmt!!.close()
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }
        return friend
    }
}
