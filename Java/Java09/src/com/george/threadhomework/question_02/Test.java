package com.george.threadhomework.question_02;

import com.george.threadAPI.SleepAndJoin;

/**
 * 第二题：分析以下需求，并用代码实现<p>
 * 训练目标：<p>
 * &emsp;&emsp;掌握java中多线程基本使用<p>
 * 需求描述：<p>
 * &emsp;&emsp;有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池中的奖项为{10,5,20,50,100,200,500,800,2,80,300,700}; <p>
 * &emsp;&emsp;创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，随机从抽奖池中获取奖项元素并打印在控制台上,格式如下:<p>
 *
 * 	&emsp;&emsp;1.每次抽出一个奖项就打印一个(随机)<p>
 * 		&emsp;&emsp;&emsp;&emsp;抽奖箱1 又产生了一个 10 元大奖<p>
 * 		&emsp;&emsp;&emsp;&emsp;抽奖箱1 又产生了一个 100 元大奖<p>
 * 		&emsp;&emsp;&emsp;&emsp;抽奖箱1 又产生了一个 200 元大奖<p>
 * 		&emsp;&emsp;&emsp;&emsp;抽奖箱1 又产生了一个 800 元大奖<p>
 * 		&emsp;&emsp;&emsp;&emsp;抽奖箱2 又产生了一个 700 元大奖<p>
 * 		&emsp;&emsp;&emsp;&emsp;//.....<p>
 *
 * 	&emsp;&emsp;2.每次抽的过程中，不打印，抽完时一次性打印(随机)<p>
 * 		&emsp;&emsp;&emsp;&emsp;在此次抽奖过程中，抽奖箱1总共产生了6个奖项，分别为：10,20,100,500,2,300最高奖项为300元，总计额为932元<p>
 * 		&emsp;&emsp;&emsp;&emsp;在此次抽奖过程中，抽奖箱2总共产生了6个奖项，分别为：5,50,200,800,80,700最高奖项为800元，总计额为1835元<p>
 *
 * 	&emsp;&emsp;3.每次抽的过程中，不打印，抽完时一次性打印(随机)<p>
 * 		&emsp;&emsp;&emsp;&emsp;在此次抽奖过程中，抽奖箱1总共产生了6个奖项，分别为：10,20,100,500,2,300最高奖项为300元，总计额为932元<p>
 * 		&emsp;&emsp;&emsp;&emsp;在此次抽奖过程中，抽奖箱2总共产生了6个奖项，分别为：5,50,200,800,80,700最高奖项为800元，总计额为1835元<p>
 * 		&emsp;&emsp;&emsp;&emsp;在此次抽奖过程中,抽奖箱2中产生了最大奖项,该奖项金额为800元<p>
 * 	以上打印效果只是数据模拟,实际代码运行的效果会有差异<p>
 * */
public class Test {
    public static void main(String[] args) {

        LotteryBox lotteryBox = new LotteryBox();
        System.out.println("================* 打印方式一 *===============");
        Thread t1 = new Thread(() -> {
            int i = 0;
            int success = 0;
            while ( i < 6 && success!= 6){
                if (lotteryBox.draw() && success < 6) {
                    i ++;
                    success ++;
                }else i--;
            }
        }, "抽奖箱 1");

        Thread t2 = new Thread(() ->{
            int i = 0;
            int success = 0;
            while ( i < 6 && success != 6 ){
                if (lotteryBox.draw() && success < 6) {
                    i ++;
                    success ++;
                }else i--;
            }
        }, "抽奖箱 2");

        t1.start();
        t2.start();

        try {
            t1.join(); // 等待线程1结束
            t2.join(); // 等待线程2结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("================* 打印方式二 *===============");
        System.out.println("在此次抽奖过程中，抽奖箱1总共产生了6个奖项，分别为：" + lotteryBox.getResults1() + "最高奖项为" + lotteryBox.getMaxPrize()[0]);
        System.out.println("在此次抽奖过程中，抽奖箱2总共产生了6个奖项，分别为：" + lotteryBox.getResults2() + "最高奖项为" + lotteryBox.getMaxPrize()[1]);

        int max = Math.max(lotteryBox.getMaxPrize()[0], lotteryBox.getMaxPrize()[1]);

        if(lotteryBox.getMaxPrize()[0] > lotteryBox.getMaxPrize()[1]){
            System.out.println("在此次抽奖过程中," + "抽奖箱1" + "中产生了最大奖项,该奖项金额为" + max +"元");
        }else  System.out.println("在此次抽奖过程中," + "抽奖箱2" + "中产生了最大奖项,该奖项金额为" + max +"元");
    }
}
