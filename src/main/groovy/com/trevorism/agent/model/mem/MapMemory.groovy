package com.trevorism.agent.model.mem

class MapMemory implements Memory{

    Map<String, Object> data = [:]

    @Override
    Map<String, Object> getData() {
        return data
    }

    void addToMemory(String key, Object value){
        data.put(key, value)
    }
}
