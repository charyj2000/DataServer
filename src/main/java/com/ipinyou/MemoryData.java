package com.ipinyou;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

class MemoryData {

    private static Map <String, Queue<String>> map;
    private static boolean isStop = true;

    static {

        map = new ConcurrentHashMap<String, Queue<String>>();

        new Thread(new Runnable() {

            public void run() {

                while (isStop) {

                    if (map.isEmpty()) {
                        System.out.println("map is empty ");
                    }

                    for(String key: map.keySet()){
                        System.out.println("ID " + key + " has : " + map.get(key).size() );
                    }
                    System.out.println("------------------------");

                    try {
                        Thread.sleep(Properties.CLEAR_INTERVAL);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }


    static String get(String id){

        if(!map.containsKey(id)){
            return "";
        }

        String e = map.get(id).poll();

        return null == e ? "" : e;
    }

    static void set(String id, String key){

        if(!map.containsKey(id)){
            map.put(id, new ConcurrentLinkedQueue<String>());
        }

        map.get(id).offer(key);
    }

    static void clean(String id){

        if (map.containsKey(id))
        map.get(id).clear();
    }

    static void start(){

    }
}
