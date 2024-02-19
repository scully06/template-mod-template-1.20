package com.haru.first.entity.ai;

import com.haru.first.entity.custom.PorcupineEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;

public class PorcupineAttackGoal extends MeleeAttackGoal {
    private final PorcupineEntity entity;
    private int attackDelay = 20;
    private int tickUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;
    public PorcupineAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((PorcupineEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 20;
        tickUntilNextAttack = 20;
    }


    @Override
    protected void attack(LivingEntity pEnemy) {
        if (isEnemyWithinAttackDistance(pEnemy)){
            shouldCountTillNextAttack = true;
            if(isTimeToStartAttackAnimation()){
                entity.setAttacking(true);
            }

            if(isTimeToAttack()){
                this.mob.getLookControl().lookAt(pEnemy.getX(),pEnemy.getY(),pEnemy.getZ());
                performAttack(pEnemy);
            }
        }else{
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout =0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy){
        return this.entity.distanceTo(pEnemy) <= 2f;
    }
    protected boolean isTimeToStartAttackAnimation(){
        return this.tickUntilNextAttack <= attackDelay;
    }
    protected boolean isTimeToAttack(){
        return this.tickUntilNextAttack <= 0;
    }
    protected  void resetAttackCooldown() {
        this.tickUntilNextAttack = this.getTickCount(attackDelay = 2);
    }
    protected void performAttack(LivingEntity pEnemy){
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(pEnemy);
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack){
            this.tickUntilNextAttack = Math.max(this.tickUntilNextAttack -1,0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}
