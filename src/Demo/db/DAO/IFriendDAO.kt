package Demo.db.DAO

import Demo.db.vo.Friend

/**
 * 主要定义操作的接口，定义一系列数据库的原子性操作，例如增删改查等；
 */
interface IFriendDAO {
    /**
     * 根据id查找朋友
     * @param id 朋友的id
     * @retuen 朋友实例
     */
    fun find(id:Int):Friend?

    /**
     * 查找所有朋友
     *
     * @return 朋友的集合
     */
    fun findAll():List<Friend>
}