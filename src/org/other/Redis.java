package org.other;

import redis.clients.jedis.Jedis;

public class Redis {
    private Jedis jedis;

    public Redis() {
        jedis = new Jedis("localhost");
    }

    public void set(String k, String v) {
        jedis.set(k, v);
        jedis.expire(k, 120);

    }

    public String get(String k) {
        return jedis.get(k);

    }

}
