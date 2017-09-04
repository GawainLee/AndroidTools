package com.tapwater.thecomplicatedgame;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by Tapwater on 16-12-6.
 */

public class GameObject extends Thread {
    private int hp;
    private float hitRate;
    private float defenseRate;
    private float moveSpeed;
    private float attackSpeed;
    private float attackStrikingDistance;
    private int direction;//^=0, >=1, |=2, <=3
    private int imageID;
    private float morale;

    private boolean byAttack = false;
    private int time;

    private boolean alive = true;

    public Handler handler;

    public GameObject(float attackSpeed, float attackStrikingDistance,
                      float defenseRate, int direction, float hitRate,
                      int hp, int imageID, float morale, float moveSpeed) {
        this.attackSpeed = attackSpeed;
        this.attackStrikingDistance = attackStrikingDistance;
        this.defenseRate = defenseRate;
        this.direction = direction;
        this.hitRate = hitRate;
        this.hp = hp;
        this.imageID = imageID;
        this.morale = morale;
        this.moveSpeed = moveSpeed;
    }

    public GameObject() {
    }

    @Override
    public void run() {
        while (alive)
        {
            handler = null;
            if (moveSpeed!=0)
            {
                Looper.prepare();
                handler = new Handler()
                {
                    @Override
                    public void handleMessage(Message msg) {
                        if (msg.what == 0x123)
                        {
                            System.out.println("Moving");
                        }
                    }
                };
                Looper.loop();
            }
            if (byAttack)
            {

            }

        }

    }

    public boolean idAlive() {
        return alive;
    }

    public void setDead(boolean alive) {
        this.alive = alive;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(float attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public float getAttackStrikingDistance() {
        return attackStrikingDistance;
    }

    public void setAttackStrikingDistance(float attackStrikingDistance) {
        this.attackStrikingDistance = attackStrikingDistance;
    }

    public boolean isByAttack() {
        return byAttack;
    }

    public void setByAttack(boolean byAttack) {
        this.byAttack = byAttack;
    }

    public float getDefenseRate() {
        return defenseRate;
    }

    public void setDefenseRate(float defenseRate) {
        this.defenseRate = defenseRate;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public float getHitRate() {
        return hitRate;
    }

    public void setHitRate(float hitRate) {
        this.hitRate = hitRate;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public float getMorale() {
        return morale;
    }

    public void setMorale(float morale) {
        this.morale = morale;
    }

    public float getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
