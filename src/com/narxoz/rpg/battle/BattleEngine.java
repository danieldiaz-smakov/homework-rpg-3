package com.narxoz.rpg.battle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class BattleEngine {
    private static BattleEngine instance;
    private Random random = new Random(1L);

    private BattleEngine() {
    }

    public static BattleEngine getInstance() {
        if (instance == null) {
            instance = new BattleEngine();
        }
        return instance;
    }

    public BattleEngine setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public EncounterResult runEncounter(List<Combatant> teamA, List<Combatant> teamB) {
        EncounterResult result = new EncounterResult();
        if (teamA == null || teamB == null) {
            result.setWinner("Invalid");
            result.setRounds(0);
            result.addLog("Teams cannot be null.");
            return result;
        }

        List<Combatant> aliveA = new ArrayList<>(teamA);
        List<Combatant> aliveB = new ArrayList<>(teamB);

        removeDead(aliveA);
        removeDead(aliveB);

        if (aliveA.isEmpty() || aliveB.isEmpty()) {
            result.setWinner(aliveA.isEmpty() && aliveB.isEmpty() ? "Draw" : aliveA.isEmpty() ? "Team B" : "Team A");
            result.setRounds(0);
            result.addLog("One or both teams had no living combatants at start.");
            return result;
        }

        int round = 0;
        while (!aliveA.isEmpty() && !aliveB.isEmpty()) {
            round++;
            result.addLog("--- Round " + round + " ---");

            // Team A attacks Team B
            for (Combatant attacker : aliveA) {
                if (!attacker.isAlive()) continue;
                Combatant target = pickRandomAlive(aliveB);

                if (target == null) break;
                int damage = attacker.getAttackPower();
                target.takeDamage(damage);
                result.addLog(attacker.getName() + " hits " + target.getName() + " for " + damage + " damage.");

                if (!target.isAlive()) {
                    result.addLog(target.getName() + " falls.");
                }
            }
            removeDead(aliveB);
            if (aliveB.isEmpty()) break;

            // Team B attacks Team A
            for (Combatant attacker : aliveB) {
                if (!attacker.isAlive()) continue;
                Combatant target = pickRandomAlive(aliveA);

                if (target == null) break;
                int damage = attacker.getAttackPower();
                target.takeDamage(damage);
                result.addLog(attacker.getName() + " hits " + target.getName() + " for " + damage + " damage.");

                if (!target.isAlive()) {
                    result.addLog(target.getName() + " falls.");
                }
            }
            removeDead(aliveA);
        }

        result.setRounds(round);

        if (aliveA.isEmpty() && aliveB.isEmpty()) {
            result.setWinner("Draw");
        }
        else {
            result.setWinner(aliveA.isEmpty() ? "Team B" : "Team A");
        }

        result.addLog("Battle ends. Winner: " + result.getWinner() + " in " + round + " round(s).");
        return result;
    }

    private static void removeDead(List<Combatant> list) {
        list.removeIf(c -> !c.isAlive());
    }

    private Combatant pickRandomAlive(List<Combatant> list) {
        List<Combatant> living = new ArrayList<>();

        for (Combatant c : list) {
            if (c.isAlive()) living.add(c);
        }

        if (living.isEmpty()) return null;

        return living.get(random.nextInt(living.size()));
    }
}
