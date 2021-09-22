package cn.ambow.huigu;
// 封装： javabean  私有属性 共有getter/setter   空构造
/*
* 私有属性：  private   只能在本类中使用 ，别人不能随便更改
* 共有getter/setter :  当前类实例化后可以通过对象名.方法名调用
*                      public  整个项目中
*                      类是抽象的，若想用类中的东西【属性、方法】，需要实例化当前类
*                      对象是类的具体， 类名 对象名 = new  构造方法；
*                      调用类中的东西， 对象名.东西《不能是private 》
*                      构造方法： public    类名（形参）{}
*                         java 语言是区分大小写的
*                         重载：方法名相同，参数列表的个数或者类型必须不同
*                         手动增加构造方法， 默认无参数的就不存在了，
*  变量： 修饰符  数据类型  变量名 ；
*         描述类的特征
*         员工特征： 姓名  性别  工号 年龄 部门 职位
*   1  李四   男    25    资金部
*   2  张三   女    32    人力部
*   3  赵六   女     22   资金部
*   4  李四1   男    45   资金部
*   5  张三2   女    32   人力部
*   6  赵六3   女     52  人力部
*
*   为啥不选择这样存？
*   假设，现在公司整顿， 需要修改”人力部“ 改成 ”人力资源管理部“
*    如何改呢？需要先得到所有人， 遍历，if( 人get部门.equals("人力部”)){  人set部门("人力资源管理部") }
*    假设1万人， 必须循环一万次
*
*  private Dept edept ；   【需要在数据库中设计外键， 员工关联部门】
*  需要先有部门
*  1. 资金部
*  2. 人力部
*
*  直接该Dept 这个类， 查询人力部， 修改， 一次
*
 *   1  李四   男    25    new Dept(1)
 *   2  张三   女    32    new Dept(2)
 *   3  赵六   女     22   new Dept(1)
 *   4  李四1   男    45   new Dept(1)
 *   5  张三2   女    32   new Dept(2)
 *   6  赵六3   女     52  new Dept(2)
*
*    private int edept ;//但是这里的值，是参考Dept类中提供的， 不可以自己任意赋值  【不需要设置外键，人工干预】
 *   1  李四   男    25    1    2
 *   2  张三   女    32    2    2
 *   3  赵六   女     22   1    2
 *   4  李四1   男    45   1    0
 *   5  张三2   女    32   2    2
 *   6  赵六3   女     52  2    2
 *
 *   人力部 任吏部
 * */
public class EmpInfo {
      private int eid ;
      // 为这个属性赋值的方式，
    // 实例化当前类的时候new 空构造方法， 对象名.setEid(12) ;
      /*  EmpInfo empInfo = new EmpInfo();
        empInfo.setEid(12);*/
    // 实例化当前类new 有参数构造
      /* EmpInfo  empInfo = new EmpInfo(12);*/
      private String ename ;
      private String esex ;
      private int eage ;
      //private Stirng edept ;
     // private int edept ;//但是这里的值，是参考Dept类中提供的， 不可以自己任意赋值
      private Dept edept ;
      private int ezhiWei; // 0表示总经理  1表示副总经理   2员工   若职位与部门挂钩，建议再创建一个职位类

    public EmpInfo() { // 实例化当前内类
    }

    public EmpInfo(int eid) {// 实例化当前类且可以给全局变量eid 赋值
        this.eid = eid;
    }

    public EmpInfo(int eid, String ename, String esex, int eage, Dept edept, int ezhiWei) {
        this.eid = eid;
        this.ename = ename;
        this.esex = esex;
        this.eage = eage;
        this.edept = edept;
        this.ezhiWei = ezhiWei;
    }

    public int getEid() {
       // int id = 0 ; // 局部变量没有初始化功能，变量不初始化不能使用
      //  return id;
        return eid ; // 全局变量具有默认初始化话 ， 此刻的值0
    }

    public void setEid(int eid) {
        this.eid = eid;  // this.全局变量 = 形参的值；   为全局变量eid 赋值
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public int getEage() {
        return eage;
    }

    public void setEage(int eage) {
        this.eage = eage;
    }

    public Dept getEdept() {
        return edept;
    }

    public void setEdept(Dept edept) {
        this.edept = edept;
    }

    public int getEzhiWei() {
        return ezhiWei;
    }

    public void setEzhiWei(int ezhiWei) {
        this.ezhiWei = ezhiWei;
    }

    /*
    * 返回值类型， 调用者更方便的使用
    * 形参： 方法体需要几个啥样的就定义几个啥样的？
    *        用几个定义几个？
    *
    *        需要几个啥样的，就定义几个啥样的？ 需要怎么决定？
    *
    *        我： 调用者     你： 此方法
    *    方法定义： public  你给我啥   方法名（我给你啥）{
    *                  需要根据我给你的， 你给我处理
    *                  最终将处理结果给我
    *               }
    *
    *     方法调用： 调用方法的返回值类型  变量名 =  对象名.方法名（我给你具体值）；
    *
    *
    * */
    // new  xx?   xx是一定存在的，
    /*
    *  public  你给我啥   方法名（我给你啥）{
     *                  需要根据我给你的， 你给我处理
     *                  最终将处理结果给我
     *  }
     *  public  String   setName(int id ){
     *      .....
     *      return "走私";
     *  }
     *  方法调用： 调用方法的返回值类型  变量名 =  对象名.方法名（我给你具体值）；
     *              String              aa    =  new EmpInfo().setName(1);
     *               ---> 调用setName方法，将1赋值给id,
     *                     将setName()的返回值赋值给变量aa
     *
     * */
    public EmpInfo login(String name ,String pwd){
        EmpInfo emp = null;
        if(name.equals("犯罪")&& pwd.equals("随时")){
            emp = new EmpInfo();
            //赋值 set方法
        }
        return emp ;
    }
    // 调用方法的返回值类型  变量名 =  对象名.       方法名（我给你具体值）；


    public String setName(int id ){
        EmpInfo               emps = new EmpInfo().login("好孩子","认真听讲");
//      String str = new str();
        String str = new String();

        return str ;
    }




}
