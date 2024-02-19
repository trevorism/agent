package com.trevorism.agent.model

import com.trevorism.agent.model.act.Action
import com.trevorism.agent.model.mem.Memory

interface SelectionAlgorithm {

    Action chooseAction(Motivation motivation, Memory memory, List<Constraint> constraints);

}