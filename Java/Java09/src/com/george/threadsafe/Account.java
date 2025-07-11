package com.george.threadsafe;

@SuppressWarnings("all")
public class Account {
    private String CardId;
    private int money;

    public Account() {
    }

    public Account(String CardId, int money) {
        this.CardId = CardId;
        this.money = money;
    }

    public void spendmoney(int money){
        Thread t = Thread.currentThread();
        //ctrl + Alt + T
        if(this.money >= money){
            System.out.println(t.getName() + "来取钱" + money + "成功");
            this.money -= money;
            System.out.println(t.getName() + "剩余" + this.money + "元");
        }else{
            System.out.println(t.getName() + "来取钱，余额" + this.money + "不足");
        }
    }

    /**
     * 获取
     * @return CardId
     */
    public String getCardId() {
        return CardId;
    }

    /**
     * 设置
     * @param CardId
     */
    public void setCardId(String CardId) {
        this.CardId = CardId;
    }

    /**
     * 获取
     * @return money
     */
    public int getMoney() {
        return money;
    }

    /**
     * 设置
     * @param money
     */
    public void setMoney(int money) {
        this.money = money;
    }

    public String toString() {
        return "Account{CardId = " + CardId + ", money = " + money + "}";
    }
}
