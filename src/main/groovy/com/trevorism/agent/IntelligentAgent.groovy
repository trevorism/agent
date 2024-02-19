package com.trevorism.agent

import com.trevorism.agent.model.act.Action
import com.trevorism.agent.model.Constraint
import com.trevorism.agent.model.mem.Memory
import com.trevorism.agent.model.Motivation
import com.trevorism.agent.model.SelectionAlgorithm

interface IntelligentAgent {

    String getName()

    SelectionAlgorithm getSelectionAlgorithm();

    Motivation getMotivation();

    Memory getMemory()

    List<Constraint> getConstraints()

    boolean isAlive()

    void preThink()

    Action act()

    void postThink(Action action)

}