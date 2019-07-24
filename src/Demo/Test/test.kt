package Demo.Test

import Demo.factory.DAOFactory
import Demo.vo.Friend

fun main() {
    val friend:Friend=DAOFactory.getIFriendDAOInstance().find(1)!!
    println("Id:${friend.id}")
    println("姓名:${friend.name}")
    println("电话:${friend.phone}")
    println("备注:${friend.note}")
}