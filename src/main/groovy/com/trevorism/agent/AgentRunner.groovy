package com.trevorism.agent

import com.trevorism.agent.model.act.Action

class AgentRunner implements Runnable {

    IntelligentAgent agent

    AgentRunner(IntelligentAgent agent){
        this.agent = agent
    }

    void run(){
        while(agent.isAlive()){
            agent.preThink()
            Action action = agent.act()
            agent.postThink(action)
        }
    }
}
