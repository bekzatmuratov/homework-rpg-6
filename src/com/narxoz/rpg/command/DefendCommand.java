package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.ArenaFighter;

public class DefendCommand implements ActionCommand {
    private final ArenaFighter target;
    private final double dodgeBoost;

    public DefendCommand(ArenaFighter target, double dodgeBoost) {
        this.target = target;
        this.dodgeBoost = dodgeBoost;
    }

    @Override
    public void execute() {
        target.modifyDodgeChance(dodgeBoost);
        System.out.println("[Command] " + target.getName() + " gains +" + dodgeBoost + " dodge chance.");
    }

    @Override
    public void undo() {
        target.modifyDodgeChance(-dodgeBoost);
        System.out.println("[Undo] Removed +" + dodgeBoost + " dodge chance from " + target.getName() + ".");
    }

    @Override
    public String getDescription() {
        return "Defend (dodge boost: +" + dodgeBoost + ")";
    }
}