package threadPool;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by XinChen on 2022/8/23
 *
 * @Description : TODO     线程池的创建方式
 *
 * 线程池的创建方式总共有以下 7 种：
 *
 * 1.Executors.newFixedThreadPool：创建一个固定大小的线程池，可控制并发的线程数，超出的线程会在队列中等待。
 *
 * 2.Executors.newCachedThreadPool：创建一个可缓存的线程池，若线程数超过处理所需，缓存一段时间后会回收，若线程数不够，则新建线程。
 *
 * 3.Executors.newSingleThreadExecutor：创建单个线程数的线程池，它可以保证先进先出的执行顺序。
 *
 * 4.Executors.newScheduledThreadPool：创建一个可以执行延迟任务的线程池。
 *
 * 5.Executors.newSingleThreadScheduledExecutor：创建一个单线程的可以执行延迟任务的线程池。
 *
 * 6.Executors.newWorkStealingPool：创建一个抢占式执行的线程池（任务执行顺序不确定）【JDK 1.8 添加】。
 *
 * 7.ThreadPoolExecutor：手动创建线程池的方式，它创建时最多可以设置 7 个参数。
 *
 * >>>>>>> 而线程池的创建推荐使用最后一种 ThreadPoolExecutor 的方式来创建，因为使用它可以明确线程池的运行规则，规避资源耗尽的风险。
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//        fixedThreadPool1();
//        fixedThreadPool2();
//        cachedThreadPool();
//        singleThreadExecutor();
//        scheduledThreadPool();
//        singleThreadScheduledExecutor();
//        workStealingPool();
        myThreadPoolExecutor();
    }

    /**
     * 创建一个固定大小的线程池，可控制并发线程数
     */
    public static void fixedThreadPool1() {
        // 创建两个线程的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        // 创建任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("running... the name is : " + Thread.currentThread().getName());
            }
        };
        // 线程池执行任务(一次添加四个任务)
        // 执行任务的方法有两种:submit 和 execute
        threadPool.submit(runnable);
        threadPool.execute(runnable);
        threadPool.execute(runnable);
        threadPool.execute(runnable);
    }

    public static void fixedThreadPool2() {
        // create thread pool
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        // execute the task
        threadPool.execute(() -> {
            System.out.println("running... the name is : " + Thread.currentThread().getName());
        });
    }

    /**
     * CachedThreadPool 可缓存的线程池
     * 若线程数超过任务所需，那么多余的线程会被缓存一段时间后才被回收，若线程数不够，则会新建线程
     * ------->>>> 使用场景
     * >>> CachedThreadPool 是根据短时间的任务量来决定创建的线程数量的，所以它适合短时间内有突发大量任务的处理场景。
     */
    public static void cachedThreadPool() {
        // create thread pool
        ExecutorService threadPool = Executors.newCachedThreadPool();
        // execute the task
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                System.out.println("running... the name is : " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * 创建单个线程的线程池，它可以保证先进先出的执行顺序
     * <p>
     * ------>>> 单个线程的线程池有什么意义？
     * >>> 单个线程的线程池相比于线程来说，它的优点有以下 2 个：
     * >>> 1.可以复用线程：即使是单个线程池，也可以复用线程。
     * >>> 2.提供了任务管理功能：单个线程池也拥有任务队列，在任务队列可以存储多个任务，这是线程无法实现的，
     * 并且当任务队列满了之后，可以执行拒绝策略，这些都是线程不具备的。
     */
    public static void singleThreadExecutor() {
        ExecutorService threadExecutor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadExecutor.execute(() -> {
                System.out.println(index + " : is running...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * 创建一个可以执行延迟任务的线程池 ， 可以用来做定时任务
     */
    public static void scheduledThreadPool() {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
        System.out.println("add task, time : " + new Date());
        threadPool.schedule(() -> {
            System.err.println("task be exeuted,time : " + new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 3, TimeUnit.SECONDS);
    }

    /**
     * 创建一个单线程的可以执行延迟任务的线程池，此线程池可以看作是 ScheduledThreadPool 的单线程池版本
     */
    public static void singleThreadScheduledExecutor() {
        ScheduledExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();
        System.out.println("add task, time : " + new Date());
        threadPool.schedule(() -> {
            System.err.println("task be exeuted,time : " + new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 5, TimeUnit.SECONDS);
    }

    /**
     * 创建一个抢占式执行的线程池（任务执行顺序不确定），此方法是 JDK 1.8 版本新增的，因此只有在 JDK 1.8 以上的程序中才能使用
     */
    public static void workStealingPool() {
        ExecutorService threadPool = Executors.newWorkStealingPool();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPool.execute(() -> {
                System.out.println(index + "  be executed, the name is : " + Thread.currentThread().getName());
            });
        }
        // Ensure that tasks are completed. （确保任务执行完成）
        while (!threadPool.isTerminated()) {}
    }

    /**
     * ThreadPoolExecutor 是最原始、也是最推荐的手动创建线程池的方式，它在创建时最多提供 7 个参数可供设置
     *
     * ------>>>>> ThreadPoolExecutor 相比于其他创建线程池的优势在于，它可以通过参数来控制最大任务数和拒绝策略，让线程池的执行更加透明和可控
     *【强制要求】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
     */
    public static void myThreadPoolExecutor() {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 100, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPool.execute(() -> {
                System.out.println(index + "  be executed, the name is : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
