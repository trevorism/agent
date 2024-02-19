package com.trevorism.agent

import com.trevorism.agent.model.act.Action
import com.trevorism.agent.model.Constraint
import com.trevorism.agent.model.act.DoNothingAction
import com.trevorism.agent.model.mem.MapMemory
import com.trevorism.agent.model.mem.Memory
import com.trevorism.agent.model.Motivation
import com.trevorism.agent.model.SelectionAlgorithm
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class SimpleAgent implements IntelligentAgent{

    private static final int MAX_ACTIONS = 100

    private static Logger log = LoggerFactory.getLogger(SimpleAgent.class)

    final String name
    private int actionsTaken

    SimpleAgent(String name) {
        this.name = name
        this.actionsTaken = 0
    }

    @Override
    String getName() {
        return name
    }

    @Override
    SelectionAlgorithm getSelectionAlgorithm() {
        return {motive, mem, constraints -> new DoNothingAction() } as SelectionAlgorithm
    }

    @Override
    Motivation getMotivation() {
        return { -> [:]} as Motivation
    }

    @Override
    Memory getMemory() {
        return new MapMemory()
    }

    @Override
    List<Constraint> getConstraints() {
        return []
    }

    @Override
    boolean isAlive() {
        return actionsTaken < MAX_ACTIONS
    }

    @Override
    void preThink() {
        log.info("Agent {} is thinking", name)
    }

    @Override
    Action act() {
        Action action = getSelectionAlgorithm().chooseAction(getMotivation(), getMemory(), getConstraints())
        log.info("Agent {} is taking action {} on iteration {}", name, action, actionsTaken)
        action.act()
        actionsTaken++
        return action
    }

    @Override
    void postThink(Action action) {
        log.info("Agent {} is thinking after {}", name, action.getName());
    }
}
