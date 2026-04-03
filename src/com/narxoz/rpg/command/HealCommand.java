package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.ArenaFighter;

public class HealCommand implements ActionCommand {
    private final ArenaFighter target;
    private final int healAmount;
    private int actualHealApplied;

    public HealCommand(ArenaFighter target, int healAmount) {
        this.target = target;
        this.healAmount = healAmount;
    }

    @Override
    public void execute() {
        if (target.getHealPotions() <= 0) {
            actualHealApplied = 0;
            System.out.println("[Command] No heal potions left for " + target.getName() + ".");
            return;
        }

        int healthBefore = target.getHealth();
        target.heal(healAmount);
        actualHealApplied = target.getHealth() - healthBefore;

        System.out.println("[Command] Heal restored " + actualHealApplied + " HP to " + target.getName() + ".");
    }

    @Override
    public void undo() {
        target.takeDamage(actualHealApplied);
        System.out.println("[Undo] Removed " + actualHealApplied + " healed HP from " + target.getName() + ".");
    }

    @Override
    public String getDescription() {
        return "Heal for " + healAmount + " HP";
    }
}