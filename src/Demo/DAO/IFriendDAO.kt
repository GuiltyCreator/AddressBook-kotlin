package Demo.DAO

import Demo.vo.Friend

interface IFriendDAO {
    fun find(id:Int):Friend?
}