package Demo.db.vo

/**
 * 主要由属性，setter, getter方法组成，VO类中的属性与表中的字段相对应，每一个VO类的对象都表示表中的每一条记录；
 */
data class Friend(val id:Int,val name:String,val phone:String,val address:String,val note:String){

    /**
     * 默认返回以空格分隔的通讯录信息
     *
     * @return 字符串格式信息
     */
    fun getInfo()="id:${this.id}    name:${this.name}   phone:${this.phone}     address:${this.address}     note:${this.note}"

    /**
     * 重载上面的 getInfo 方法，返回指定分隔符分隔的通讯录信息
     *
     * @return 字符串格式信息
     */
    fun getInfo(delimiter:String)="id:${this.id}${delimiter}name:${this.name}${delimiter}phone:${this.phone}${delimiter}address:${this.address}${delimiter}note:${this.note}"

}
