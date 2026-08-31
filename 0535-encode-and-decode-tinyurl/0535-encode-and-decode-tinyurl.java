public class Codec {
    HashMap<String, String> map = new HashMap<>();

    public String encode(String longUrl) {
        String key = "http://lc/" + map.size();
        map.put(key, longUrl);

        return key;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));