package random

import java.security.SecureRandom
import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random

/*项目名: java-study-example
*文件名: RandomTest
*创建者: 小亮
*创建时间:2020/12/20 10:02 下午
*描述: 产生随机数几种方法
*/

fun main(args: Array<String>) {
    /**
     * 使用Math的静态方法 random
     * 产生0-1之间的随机数
     * [* System.nanoTime() = Returns the current value of the running Java Virtual Machine's
     * high-resolution time source, in nanoseconds.]
     * this(seedUniquifier() ^ System.nanoTime());
     */
    println("-----Math.random(--")
    //第一种方式
    for (i in 0..10) {
        println(Math.random().toString())
    }

    println("--------random------------")
    //设置种子,缺点 随机数每次都打印相同
    val random = Random
//    nextBoolean() - 返回均匀分布的 true 或者 false
//nextBytes(byte[] bytes)
//nextDouble() - 返回 0.0 到 1.0 之间的均匀分布的 double
//nextFloat() - 返回 0.0 到 1.0 之间的均匀分布的 float
//nextGaussian()- 返回 0.0 到 1.0 之间的高斯分布（即正态分布）的 double
//nextInt() - 返回均匀分布的 int
//nextInt(int n) - 返回 0 到 n 之间的均匀分布的 int （包括 0，不包括 n）
//nextLong() - 返回均匀分布的 long
    for (i in 0..4) {
        println(random.nextBoolean())
    }

    println("------ThreadLocalRandom----------")
    /**
     * ThreadLocalRandom
     * 每一个线程有一个独立的随机数生成器，
     * 用于并发产生随机数，
     * 能够解决多个线程发生的竞争争夺。效率更高！
     * ThreadLocalRandom 不是直接用 new 实例化，
     * 而是第一次使用其静态方法 current() 得到
     * ThreadLocal<ThreadLocalRandom> 实例
     * ，然后调用 java.util.Random 类提供的方法获得各种随机数
     */
    for (i in 0..10) {
        println(ThreadLocalRandom.current().nextInt())
    }
    println("------secureRandom--------")
    /**
     *  java.Security.SecureRandom
    也是继承至 java.util.Random。
    操作系统收集了一些随机事件，比如鼠标点击，键盘点击等等，
    SecureRandom 使用这些随机事件作为种子。
    SecureRandom 提供加密的强随机数生成器 (RNG)，
    要求种子必须是不可预知的，产生非确定性输出。 SecureRandom
    也提供了与实现无关的算法，因此，调用方（应用程序代码）会请求特定的 RNG
    算法并将它传回到该算法的 SecureRandom 对象中。
    如果仅指定算法名称，如下所示：
    SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
    如果既指定了算法名称又指定了包提供程序，如下所示：
    SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
     */
    val secureRandom = SecureRandom.getInstance("SHA1PRNG")
    for (i in 0..10){
        println(secureRandom.nextInt())
    }
}
