package encoding;

import java.util.HashMap;

public class L535_TinyUrl_M {

    public class Codec {

        private int id = 0;
        private String chars="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap<Integer, String> map = new HashMap<>();
        // uuid -> base64 encoding
        // compute for some long?
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String short_url = idToShort(this.id);
            map.put(this.id, longUrl);
            // update this.id
            this.id += 1;

            return short_url;
        }

        private String idToShort(int id) {
            String short_url = "";
            while (id > 0) {
                short_url = chars.charAt(id % 62) + short_url;
                id /= 62;
            }

            while (short_url.length() < 6) {
                short_url = "0" + short_url;
            }

            return short_url;
        }

        private int shortUrlToId(String shortUrl) {
            int id = 0;
            for (int i = 0; i < shortUrl.length(); i++) {
                // Here shortUrl.charAt(i) is always going to be between 0-Z
                // so you just need to offset from 0 and get its base 62 value as it's what being converted
                id = id * 62 + shortUrl.charAt(i) - '0';
            }

            return id;
        }


        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            int id = shortUrlToId(shortUrl);
            return map.get(id);
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
}
