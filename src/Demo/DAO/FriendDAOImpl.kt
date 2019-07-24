package Demo.DAO

import Demo.vo.Friend
import java.lang.Exception
import java.sql.*

class FriendDAOImpl(val conn:Connection) :IFriendDAO{

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
